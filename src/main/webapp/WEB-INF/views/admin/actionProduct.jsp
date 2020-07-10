<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
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
						
			<form>
			  <div class="form-group">
			    <label for="exampleInputEmail1">Email address</label>	
			    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Password</label>
			    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
			  </div>
			  <div class="form-group">
			    <label for="exampleFormControlSelect1">Example select</label>
			    <select class="form-control" id="exampleFormControlSelect1">
			      <option>1</option>
			      <option>2</option>
			      <option>3</option>
			      <option>4</option>
			      <option>5</option>
			    </select>
			  </div>
			  
			  <button type="submit" class="btn btn-primary">Submit</button>
			</form>			
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

</body>