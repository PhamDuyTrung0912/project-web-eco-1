<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ include file="/common/taglib.jsp" %>
    <c:url var="ImageURL" value="/assets/image" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

				

				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"></i> Product List
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th>Id</th>
										<th>Created Date</th>
										<th>Created By</th>
										<th>Modified Date</th>
										<th>Modified By</th>
										
										<th>Content</th>
										<th>Short Desc</th>
										<th>Name Product</th>
										<th>Price Product</th>
										
										<th>Image Product</th>
										<th>Category Product</th>
										<th>Quantity</th>
										<th>Action</th>
									</tr>
								</thead>							
								<tbody>
								<c:forEach var="map" items="${modal.listResult}">
								
									<tr>
										<td>${map.id}</td>
										<td>${map.createdDate}</td>
										<td>${map.createdBy}</td>
										<td>${map.modifiedDate}</td>
										<td>${map.modifiedBy}</td>
										
										<td>${map.content}</td>
										<td>${map.shortDesc}</td>
										<td>${map.name}</td>
										<td>${map.price}</td>
										
										<td><img src="${ImageURL}/${map.imageProduct}.jpg" alt="" width="150px" height="150px"></td>
										<td>${map.categoryCode}</td>
										<td>2</td>
										<td>
											<div style="display: flex;">
												<a href="<c:url value="/admin/update/${map.id}"/>" style=" float:left; margin-right:10px; color: #aaa; ">Edit</a>
												<a href="<c:url value="/admin/delete/${map.id}"/>" style=" color: #aaa;">Delete</a>
											</div>
											
										</td>
									</tr>
								
								
								</c:forEach>
																	
									
								</tbody>
							</table>
						</div>
					</div>
					<div class="card-footer small text-muted">Updated yesterday
						at 11:59 PM</div>
				</div>

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
</html>