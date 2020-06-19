<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Fashi Template">
    <meta name="keywords" content="Fashi, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Fashi | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js">
</script>
    <link rel="stylesheet" href="<c:url value='/template/web/css/bootstrap.min.css'/>" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/template/web/css/font-awesome.min.css'/>" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/template/web/css/themify-icons.css'/>" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/template/web/css/elegant-icons.css'/>" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/template/web/css/owl.carousel.min.css'/>" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/template/web/css/nice-select.css'/>" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/template/web/css/jquery-ui.min.css'/>" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/template/web/css/slicknav.min.css'/>" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/template/web/css/style.css'/>" type="text/css" rel="stylesheet">
    
</head>
<body>
	<!-- Navigation -->
	<%@ include file="/common/web/header.jsp" %>

	<dec:body/>

	<!-- Footer -->
	<%@ include file="/common/web/footer.jsp" %>


	<script>
	
	// Get the container element
	var btnContainer = document.getElementById("menulist");

	// Get all buttons with class="btn" inside the container
	var btnsul = btnContainer.getElementsByTagName("ul")[0];

	
	var btns = btnsul.getElementsByTagName("li");
	// Loop through the buttons and add the active class to the current/clicked button
	
	console.log(btns);
	
	$.each(btns,function(index,value){
		
		$(btns[index]).click(function(){
			
			var current=btns.getElementsByClassName("active");
			current[0].className = current[0].className.replace(" active", "");
			$(this).attr("class","active");
		})
		
	})
	
	
	
	</script>
	



	<!-- Bootstrap core JavaScript -->
	<script src="<c:url value='/template/web/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/template/web/js/jquery-ui.min.js'/>"></script>
	<script src="<c:url value='/template/web/js/jquery.countdown.min.js'/>"></script>
	<script src="<c:url value='/template/web/js/jquery.nice-select.min.js'/>"></script>

	<script src="<c:url value='/template/web/js/jquery.zoom.min.js'/>"></script>
	<script src="<c:url value='/template/web/js/jquery.dd.min.js'/>"></script>
	<script src="<c:url value='/template/web/js/jquery.slicknav.js'/>"></script>
	<script src="<c:url value='/template/web/js/owl.carousel.min.js'/>"></script>
   	<script src="<c:url value='/template/web/js/main.js'/>"></script>

  
</body>
</html>