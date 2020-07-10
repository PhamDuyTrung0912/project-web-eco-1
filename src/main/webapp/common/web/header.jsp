<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.thuchanhchuyensau.util.SecurityUtils"%>
<c:url var="ImageURL" value="/assets/image" />
	
<header class="header-section">
	<div class="header-top">
		<div class="container">
			<div class="ht-left">
				<div class="mail-service">
					<i class=" fa fa-envelope"></i> trungti09121998@gmail.com
				</div>
				<div class="phone-service">
					<i class=" fa fa-phone"></i> +84 382 510 012
				</div>
			</div>
			<div class="ht-right">

				<security:authorize access="isAnonymous()">
					<a class="login-panel" style="margin-left: 20px"
						href="<c:url value="/web/register"/>">Register</a>
					<a href="<c:url value="/web/login"/>" class="login-panel"><i
						class="fa fa-user"></i>Login</a>

				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<a class="login-panel" href="<c:url value="/logout"/>">Logout</a>
					<a class="login-panel" style="margin-right: 20px" href="#">Welcome
						<%=SecurityUtils.getPrincipal().getFullName()%>,
						</a>
				</security:authorize>
				<div class="top-social">
					<a href="facebook.com"><i class="ti-facebook"></i></a> 
					<a href="#"><i class="ti-twitter-alt"></i></a>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="inner-header">
			<div class="row">
				<div class="col-lg-2 col-md-2">
					<div class="logo" style="padding: 0 0">
						<a href="<c:url value="/web/home"/>"> <img
							src="https://via.placeholder.com/150x50" alt="">
						</a>
					</div>
				</div>
				<div class="col-lg-7 col-md-7">
					<div class="advanced-search">
						<button type="button" class="category-btn">All Categories</button>
						
						
						
						<div class="input-group">
						<form action="<c:url value='/web/product/search'/>" >
							<input type="text" placeholder="What do you need?" name="keysearch">
								<button type="submit">
									<i class="ti-search"></i>
								</button>
						</form>
							
						</div>
					</div>
				</div>
				<div class="col-lg-3 text-right col-md-3">
					<ul class="nav-right">
						<li class="heart-icon"><a href="#"> <i
								class="icon_heart_alt"></i> <span>0</span>
						</a></li>
						<li class="cart-icon"><a href="#"> <i
								class="icon_bag_alt"></i> <span>
								<c:if test = "${sessionScope.myCartNum != null}">
        						   <c:out value ="${sessionScope.myCartNum}"/>
      							</c:if>
      							<c:if test = "${sessionScope.myCartNum == null}">
        						   <c:out value = "0"/>
      							</c:if>
							
							</span>
						</a>
							<div class="cart-hover">
								<div class="select-items">
									<table>
										<tbody>
										 <c:forEach var="map" items="${sessionScope.myCartItems}">
											<tr>
												<td class="si-pic"><img src="${ImageURL}/${map.value.product.imageProduct}.jpg" width="100px"
													alt="abc"></td>
												<td class="si-text">
													<div class="product-selected">
														<p>$${map.value.product.price} x ${map.value.quantity}</p>
														<h6>${map.value.product.name}</h6>
													</div>
												</td>
												<td class="si-close"><a href="<c:url value="/web/remove/${map.value.product.id}" />"><i class="ti-close"></i></a></td>
											</tr>
											</c:forEach>										
										</tbody>
									</table>
								</div>
								<div class="select-total">
									<span>total:</span>
									<h5>$${sessionScope.myCartTotal}</h5>
								</div>
								<div class="select-button">
									<a href="<c:url value='/web/sub'/>" class="primary-btn view-card">VIEW CARD</a> 
									<a href="#" class="primary-btn checkout-btn">CHECK OUT</a>
								</div>
							</div></li>
						<li class="cart-price">${sessionScope.myCartTotal}</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="nav-item">
		<div class="container">
			
			
				<nav class="nav-menu mobile-menu" id="menulist">
					<ul>
						<li class="active"><a href="<c:url value='/web/home'/>">Home</a></li>
						<li><a href="<c:url value='/web/shop'/>">Shop</a></li>					
						<li><a href="./blog.html">Blog</a></li>
						<li><a href="./contact.html">Contact</a></li>
					</ul>
				</nav>
			
			<div id="mobile-menu-wrap"></div>
		</div>
	</div>
</header>
<!-- Header End -->