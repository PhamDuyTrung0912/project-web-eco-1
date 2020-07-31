	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ include file="/common/taglib.jsp" %>
	 
	<c:url var="APIurl" value="/api/product"/>
	<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Home Page</title>

</head>

<body>
	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="/common/admin/navbar.jsp" %>

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- Breadcrumbs-->
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">Product Manager</a></li>
					<li class="breadcrumb-item active">Action</li>
				</ol>

				<!-- Icon Cards-->
					<div class="alert alert-dark" role="alert">
					 Create Product ...
					</div>
						
						
						
						
			<form:form id="formSubmit" action="${pageContext.request.contextPath }/admin/create" method="POST" enctype="multipart/form-data" modelAttribute="product"  >
			  <div class="form-group">
			    <label for="titleProduct">Title Product</label>	
			    <form:input type="text" class="form-control"  placeholder="Enter Title" path="name" id="titleProduct"/>
			  </div>
			  <div class="form-group">
			    <label for="price">Price Product</label>	
			    <form:input type="text" class="form-control"  placeholder="Enter Title" path="price"/>
			  </div>
			   <div class="form-group">
			    <label for="shortDescProduct">Short Description Product</label>	
			    <form:input type="text" class="form-control"  placeholder="Enter Short Description" path="shortDesc"/>
			  </div>
			   <div class="form-group">
			    <label for="contentProduct">Content Product</label>	
			    <form:input type="text" class="form-control" placeholder="Enter Content" path="content"/>
			  </div>
			  
			  <form:hidden path="id" />
			  <div class="form-group">
			    <label for="CategoryProduct">Category product</label>
			    <select class="form-control" id="CategoryProduct" name="categoryCode">	
			    <c:if test="${empty product.categoryCode}">	    
			      <option value="">Chọn Thể Loại</option>
			      <c:forEach var="item" items="${categories.listResult}">
			      <option value="${item.code}">${item.name}</option>
			      </c:forEach>
			    </c:if>
			    <c:if test="${not empty product.categoryCode}">
                                            <option value="">Chọn loại bài viết</option>
                                            <c:forEach var="item" items="${categories.listResult}">
                                                <option value="${item.code}" <c:if test="${item.code == product.categoryCode}">selected="selected"</c:if>>
                                                        ${item.name}
                                                </option>
                                            </c:forEach>
                                        </c:if>
			     
			    </select>
			  </div>
			  
			  <div class="form-group">
			    <label for="sizeProduct">Size product</label>
			    <select class="form-control" id="sizeProduct" name="size">
			      <option value="XL">XL</option>
			      <option value="L">L</option>
			      <option value="M">M</option>
			      <option value="S">S</option>		
			    </select>
			  </div>
			  
			  <div class="form-group">
   						 <label for="imageProduct">Image Product</label>
    					<form:input type="file" class="form-control-file" path="nameImage"/>
 				 </div>
			  
			  
			  
			  <input type="submit"  class="btn btn-primary" id="" value="Submit" />
			</form:form>			
												</br>

		

			</div>
			<!-- /.container-fluid -->

			<!-- Sticky Footer -->
			<footer class="sticky-footer">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright © Your Website 2019</span>
					</div>
				</div>
			</footer>

		</div>
		<!-- /.content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<script type="text/javascript">
	

	$('#btnAddOrUpdateNew').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    var formData = $('#formSubmit').serializeArray();
	    $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;  
        });
	    var files=$('#imageProduct')[0].files[0];
	    
	    if(files != undefined){
			var reader=new FileReader();
			reader.onload=function(e){imageProduct
				data["nameImage"]=e.target.result;
				data["imageProduct"]=files.name;	
			};
			 reader.readAsDataURL(files);
	    }
	    
	    addProduct(data);
	    console.log(data);
	
	});
	
	function addProduct(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            contentType:'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	console.log(result)
            },
            error: function (error) {
            	console.log(error)
            }
        });
    }
	
	</script>

</body>