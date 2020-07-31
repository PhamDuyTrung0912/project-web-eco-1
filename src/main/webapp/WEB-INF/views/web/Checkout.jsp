<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/common/taglib.jsp" %>
	<c:url var="ImageURL" value="/assets/image" />
	
	<html>
		<head>
		<meta charset="UTF-8">
		<title>Shopping Cart</title>
		</head>
		<body>
			<div id="preloder">
        <div class="loader"></div>
    </div>

  

    <!-- Breadcrumb Section Begin -->
    <div class="breacrumb-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text product-more">
                        <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                        <a href="./shop.html">Shop</a>
                        <span>Check Out</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Section Begin -->

    <!-- Shopping Cart Section Begin -->
    <section class="checkout-section spad">
        <div class="container">
            <form:form action="${pageContext.request.contextPath }/web/checkout" class="checkout-form" method="POST" modelAttribute="customer">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="checkout-content">
                            <a href="<c:url value="/web/login"/>" class="content-btn">Click Here To Login</a>
                        </div>
                        <h4>Biiling Details</h4>
                        
                        	 <div class="row">
                            <div class="col-lg-6">
                                <label for="fir">First Name<span>*</span></label>
                                <input type="text" id="fir" name="fir">
                            </div>
                            <div class="col-lg-6">
                                <label for="last">Last Name<span>*</span></label>
                                <input type="text" id="last" name="last">
                            </div>
                            <div class="col-lg-12">
                                <label for="cun-name">Company Name</label>
                                <input type="text" id="cun-name" name="cunname">
                            </div>
                            <div class="col-lg-12">
                                <label for="cun">Country<span>*</span></label>
                                <input type="text" id="cun" name="cun">
                            </div>
                            <div class="col-lg-12">
                                <label for="street">Street Address<span>*</span></label>
                                <input type="text" id="street" class="street-first" name="street">
                        
                            </div>
                            <div class="col-lg-12">
                                <label for="zip">Postcode / ZIP (optional)</label>
                                <input type="text" id="zip" name="zip">
                            </div>
                            <div class="col-lg-12">
                                <label for="town">Town / City<span>*</span></label>
                                <input type="text" id="town" name="town">
                            </div>
                            <div class="col-lg-6">
                                <label for="email">Email Address<span>*</span></label>
                                <input type="text" id="email" name="email">
                            </div>
                            <div class="col-lg-6">
                                <label for="phone">Phone<span>*</span></label>
                                <input type="text" id="phone" name="phone">
                            </div>
                        </div>                   
                  
                       
                    </div>
                    <div class="col-lg-6">
                        <div class="checkout-content">
                            <input type="text" placeholder="Enter Your Coupon Code">
                        </div>
                        <div class="place-order">
                            <h4>Your Order</h4>
                            <div class="order-total">
                                <ul class="order-table">
                                	<li>Product <span>Total</span></li>
                                	 <c:forEach var="map" items="${sessionScope.myCartItems}">
                                		 <li class="fw-normal">${map.value.product.name} x ${map.value.quantity} <span>$${map.value.product.price*map.value.quantity}</span></li>
                                	</c:forEach>  
                                    <li class="fw-normal">Subtotal <span>$${sessionScope.myCartTotal}</span></li>
                                    <li class="total-price">Total <span>$${sessionScope.myCartTotal}</span></li>
                                </ul>
                                <div class="payment-check">
                                    <div class="pc-item">
                                        <label for="pc-check">
                                            Cheque Payment
                                            <input type="checkbox" id="pc-check">
                                            <span class="checkmark"></span>
                                        </label>
                                    </div>
                                    <div class="pc-item">
                                        <label for="pc-paypal">
                                            Paypal
                                            <input type="checkbox" id="pc-paypal">
                                            <span class="checkmark"></span>
                                        </label>
                                    </div>
                                </div>
                                <div class="order-btn">
                                    <button type="submit" class="site-btn place-btn">Place Order</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </section>
    <!-- Shopping Cart Section End -->

		
		</body>
	</html>