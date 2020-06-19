<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp"%>
	<c:url var="RegisterURL" value="/web/register" />
	<c:url var="AddUserURL" value="/api/user" />
	<c:url var="ImageURL" value="/assets/image" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- Breadcrumb Section Begin -->
	<div class="breacrumb-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="breadcrumb-text">
						<a href="#"><i class="fa fa-home"></i> Home</a> <span>Register</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Breadcrumb Form Section Begin -->

	<div class="container">
		<c:if test="${not empty message}">
			<div class="alert alert-${alert}" >
	 			${message}
			</div>
		</c:if>
	</div>

	<!-- Register Section Begin -->
	<div class="register-login-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 offset-lg-3">
					<div class="register-form">
						<h2>Register</h2>
						<form id="formSubmit" >
							<div class="group-input">
								<label for="username">Username or email address *</label> <input
									type="text" id="userName" name="userName" value="">
							</div>
							<div class="group-input">
								<label for="pass">Password *</label> <input type="password"
									id="password" name="password" value="">
							</div>
							<div class="group-input">
								<label for="con-pass">Confirm Password *</label> <input
									type="password" id="con-pass" name="confirmpassword" value="">
							</div>
							<button type="button" id="btnRegister"  class="site-btn register-btn">REGISTER</button>
						</form>
						<div class="switch-login">
							<a href="<c:url value='/web/login'/>" class="or-login">Or Login</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Register Form Section End -->

	<!-- Partner Logo Section Begin -->
	<div class="partner-logo">
		<div class="container">
			<div class="logo-carousel owl-carousel">
				<div class="logo-item">
					<div class="tablecell-inner">
						<img src="https://via.placeholder.com/1900x725" alt="">
					</div>
				</div>
				<div class="logo-item">
					<div class="tablecell-inner">
						<img src="${ImageURL}/logo-2.png" alt="">
					</div>
				</div>
				<div class="logo-item">
					<div class="tablecell-inner">
						<img src="img/logo-carousel/logo-3.png" alt="">
					</div>
				</div>
				<div class="logo-item">
					<div class="tablecell-inner">
						<img src="img/logo-carousel/logo-4.png" alt="">
					</div>
				</div>
				<div class="logo-item">
					<div class="tablecell-inner" >
						<img src="img/logo-carousel/logo-5.png" alt="">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Partner Logo Section End -->
	
	<script >
	
		
		$('#btnRegister').click(function (e) {
			e.preventDefault();
			var data={};
			var formData=$('#formSubmit').serializeArray();
				$.each(formData,function(i,v){
					data[""+v.name+""]=v.value;
					
				});
				if(data["password"]!=data["confirmpassword"]){		
						SamePass();
				}else{
						addUser(data);
				}						
		});
		
		function SamePass(){
			window.location.href="${RegisterURL}?message=err_confirm";
		};
		
		function addUser(data){
			$.ajax({
				url:'${AddUserURL}',
				type:'POST',
				contentType:'application/json',
				data:JSON.stringify(data),
				dataType:'json',
				success: function(rs){
					window.location.href="${RegisterURL}?message=add_user_success";
				},
				error: function(err){
					if(err.responseJSON!=null){									
							for( var PropObject in err.responseJSON){
								$('#'+PropObject).before('<div style="color:red" class="bf-div">'+err.responseJSON[PropObject]+' *</div>');		
								
								setTimeout(function(){ 
									$(".bf-div").hide("slow",function(){
										$(this).remove();
									});
							
									}, 3000);
							}
							
					}else{
						window.location.href="${RegisterURL}?message=err_valid";
					}
					
				}
			})
			
			
		}
	
	
	</script>
	

	

</body>
</html>