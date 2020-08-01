<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/common/taglib.jsp" %>
	<c:url var="ImageURL" value="/assets/image" />
	<c:url var="DecURL" value="/web/cart/dec	" />
	
	<html>
		<head>
		<meta charset="UTF-8">
		<title>Shopping Cart</title>
		</head>
		<body>
	

  

    <!-- Breadcrumb Section Begin -->
    <div class="breacrumb-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text product-more">
                        <a href="./home.html"><i class="fa fa-home"></i> Home</a>
                        <a href="./shop.html">Shop</a>
                        <span>Shopping Cart</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Section Begin -->

    <!-- Shopping Cart Section Begin -->
    <section class="shopping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="cart-table">
                        <table>
                            <thead>
                                <tr>
                                    <th>Image</th>
                                    <th class="p-name">Product Name</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th><i class="ti-close"></i></th>
                                </tr>
                            </thead>
                            
                            <tbody>
                            <c:forEach var="map" items="${sessionScope.myCartItems}">
                                <tr>
                                    <td class="cart-pic first-row"><img src="${ImageURL}/${map.value.product.imageProduct}.jpg" alt="" width="150px"></td>
                                    <td class="cart-title first-row">
                                        <h5>Pure Pineapple</h5>
                                    </td>
                                    <td class="p-price first-row" id="priceitem" >$${map.value.product.price}</td>
                                    <td class="qua-col first-row">
                                        <div class="quantity">
                                            <div class="pro-qty">
                                            	<input type="hidden" id="productID" value="${map.value.product.id}" />
                                            	<a style="border: none; background: white; z-index: 2" class="dec qtybtn" href="<c:url value="/web/cart/dec/${map.value.product.id}" />">-</a>
                                                <input type="text" value="${map.value.quantity}" class="qtt">
                                               <a style="border: none; background: white;" class="inc qtybtn" href="<c:url value="/web/cart/inc/${map.value.product.id}" />">+</a>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="total-price first-row" id="totalitem">$${map.value.product.price*map.value.quantity}</td>
                                    <td class="close-td first-row"><a href="<c:url value="/web/remove/${map.value.product.id}" />"><i class="ti-close"></i></a></td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="cart-buttons">
                                <a href="#" class="primary-btn continue-shop">Continue shopping</a>
                                <a href="#" class="primary-btn up-cart">Update cart</a>
                            </div>
                            <div class="discount-coupon">
                                <h6>Discount Codes</h6>
                                <form action="#" class="coupon-form">
                                    <input type="text" placeholder="Enter your codes">
                                    <button type="submit" class="site-btn coupon-btn">Apply</button>
                                </form>
                            </div>	
                        </div>
                        <div class="col-lg-4 offset-lg-4">
                            <div class="proceed-checkout">
                                <ul>
                                    <li class="subtotal">Subtotal <span>$${sessionScope.myCartTotal}</span></li>
                                    <li class="cart-total">Total <span>$${sessionScope.myCartTotal}</span></li>
                                </ul>
                                <a href="<c:url value="/web/checkout"/>" class="proceed-btn">PROCEED TO CHECK OUT</a>
                            </div>
                        </div>
                       
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shopping Cart Section End -->
		
		<script type="text/javascript">
			
			


		 
		
		</script>
		
		</body>
	</html>