<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/common/taglib.jsp" %>
	<c:url var="ImageURL" value="/assets/image" />
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<title>Trang chủ</title>

</head>

<body>
	
	<div id="preloder">
        <div class="loader"></div>
    </div>
	
	<!-- Hero Section Begin -->
    <section class="hero-section">
        <div class="hero-items owl-carousel">
        	
         <c:forEach var="item" items="${adverting.listResult}">	
            <div class="single-hero-items set-bg" data-setbg="${ImageURL}/${item.imageAdvert}.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-5">
                            <span>Bag,kids</span>
                            <h1>Black friday</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
                                incididunt ut labore et dolore</p>
                            <a href="#" class="primary-btn">Shop Now</a>
                        </div>
                    </div>
                    <div class="off-card">
                        <h2>Sale <span>50%</span></h2>
                    </div>
                </div>
            </div>
            </c:forEach>
           
        </div>
    </section>
    <!-- Hero Section End -->


    <!-- Women Banner Section Begin -->
    <section class="women-banner spad" style="margin-top: 50px">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-3">
                    <div class="product-large set-bg" data-setbg="${ImageURL}/women-large.jpg">
                        <h2>Women’s</h2>
                        <a href="#">Discover More</a>
                    </div>
                </div>
                <div class="col-lg-8 offset-lg-1">
                   
              
                    
                    
                     <div class="product-tab" style="padding: 0px">
                        <div class="tab-item" style="display: flex;justify-content: center">
                            <ul class="nav" role="tablist">
                                <li>
                                    <a class="active" data-toggle="tab" href="#tab-1" role="tab">All</a>
                                </li>
                                
                                <c:forEach var="map" items="${category.listResult}">
	                                 <li>
	                                	<a data-toggle="tab" href="#tab-${map.code}" role="tab">${map.name}</a>
	                                </li>        
                                
                                </c:forEach>
     
                            </ul>
                        </div>
                        <div class="tab-item-content">
                            <div class="tab-content">
                                <div class="tab-pane fade-in active" id="tab-1" role="tabpanel">
                                    <div class="product-content">
                                        <div class="row">
                                           		  <div class="product-slider owl-carousel">
                    
						                    <c:forEach var="item" items="${model.listResult}">
						                        <div class="product-item">
						                            <div class="pi-pic">					                            
						                            	<a href="<c:url value='/web/product/${item.id}'/>">
							                                <img src="${ImageURL}/${item.imageProduct}.jpg" alt="" >
						                                </a>
						                              						                                
						                                <div class="sale">Sale</div>
						                                <div class="icon">
						                                    <i class="icon_heart_alt"></i>
						                                </div>
						                                <ul>
						                                    <li class="w-icon active"><a href="#"><i class="icon_bag_alt"></i></a></li>
						                                    <li class="quick-view"><a href="#">+ Quick View</a></li>
						                                    <li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>
						                                </ul>
						                            </div>
						                            <div class="pi-text">
						                                <div class="catagory-name"> 
						                                      <c:forEach var="gen" items="${item.listgender}">
						                                      	${gen.name}
						                                      </c:forEach>            	
						                               
						                                </div>
						                                <a href="#">
						                                    <h5><c:url value="${item.name}"/></h5>	
						                                </a>
						                                <div class="product-price">
						                                   <c:url value="$${item.price}"/>
						                                    <span class="ml-2"><c:url value="$${item.price+2}"/></span>
						                                </div>
						                            </div>
						                        </div>
						                       </c:forEach>
						                                  
						                    </div>
                                        </div>
                                    </div>
                                </div>
                                <c:forEach var="map" items="${category.listResult}">
	                                 <div class="tab-pane fade" id="tab-${map.code}" role="tabpanel">
	                                 		<div class="product-content">
                                        <div class="row">
                                           		  <div class="product-slider owl-carousel">
                    
						                    <c:forEach var="item" items="${model.listResult}">
						                        <div class="product-item">
						                            <div class="pi-pic">					                            
						                            	<a href="<c:url value='/web/product/${item.id}'/>">
							                                <img src="${ImageURL}/${item.imageProduct}.jpg" alt="">
						                                </a>
						                              						                                
						                                <div class="sale">Sale</div>
						                                <div class="icon">
						                                    <i class="icon_heart_alt"></i>
						                                </div>
						                                <ul>
						                                    <li class="w-icon active"><a href="#"><i class="icon_bag_alt"></i></a></li>
						                                    <li class="quick-view"><a href="#">+ Quick View</a></li>
						                                    <li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>
						                                </ul>
						                            </div>
						                            <div class="pi-text">
						                                <div class="catagory-name"> 
						                                      <c:forEach var="gen" items="${item.listgender}">
						                                      	${gen.name}
						                                      </c:forEach>            	
						                               
						                                </div>
						                                <a href="#">
						                                    <h5>Pure Pineapple</h5>
						                                </a>
						                                <div class="product-price">
						                                    $14.00
						                                    <span>$75.00</span>
						                                </div>
						                            </div>
						                        </div>
						                       </c:forEach>
						                                  
						                    </div>
                                        </div>
                                    </div>
	                                 	
	                                 	
	                                 	
	                                 </div>
                                
                                
                                
                                </c:forEach>
                                
                                
                                 <div class="tab-pane fade" id="tab-2" role="tabpanel">
                                 	
                                 </div>
                                <div class="tab-pane fade" id="tab-3" role="tabpanel">
                                    
                                </div>
                                
                                 <div class="tab-pane fade" id="tab-4" role="tabpanel">
                                 	
                                 </div>
                                
                                  <div class="tab-pane fade" id="tab-5" role="tabpanel" >
                                 	
                                 </div>
                                
                            </div>
                        </div>
                    </div>
               
                </div>
            </div>
        </div>
    </section>
    <!-- Women Banner Section End -->
    
    <!-- Man Banner Section Begin -->
    <section class="man-banner spad">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-8">
                    <div class="filter-control">
                        <ul>
                            <li class="active">Clothings</li>
                            <li>HandBag</li>
                            <li>Shoes</li>
                            <li>Accessories</li>
                        </ul>
                    </div>
                    <div class="product-slider owl-carousel">
                    
                    
                       <c:forEach var="item" items="${model1.listResult}">
						                        <div class="product-item">
						                            <div class="pi-pic">					                            
						                            	<a href="<c:url value='/web/product/${item.id}'/>">
							                                <img src="${ImageURL}/${item.imageProduct}.jpg" alt="">
						                                </a>
						                              						                                
						                                <div class="sale">Sale</div>
						                                <div class="icon">
						                                    <i class="icon_heart_alt"></i>
						                                </div>
						                                <ul>
						                                    <li class="w-icon active"><a href="#"><i class="icon_bag_alt"></i></a></li>
						                                    <li class="quick-view"><a href="#">+ Quick View</a></li>
						                                    <li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>
						                                </ul>
						                            </div>
						                            <div class="pi-text">
						                                <div class="catagory-name"> 
						                                      <c:forEach var="gen" items="${item.listgender}">
						                                      	${gen.name}
						                                      </c:forEach>            	
						                               
						                                </div>
						                                <a href="#">
						                                    <h5>Pure Pineapple</h5>
						                                </a>
						                                <div class="product-price">
						                                    $14.00
						                                    <span>$75.00</span>
						                                </div>
						                            </div>
						                        </div>
						                       </c:forEach>
                                            
                    </div>
                </div>
                <div class="col-lg-3 offset-lg-1">
                    <div class="product-large set-bg m-large" data-setbg="${ImageURL}/man-large.jpg">
                        <h2>Men’s</h2>
                        <a href="#">Discover More</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Man Banner Section End -->

    <!-- Instagram Section Begin -->
    <div class="instagram-photo">
        <div class="insta-item set-bg" data-setbg="${ImageURL}/insta-1.jpg">
            <div class="inside-text">
                <i class="ti-instagram"></i>
                <h5><a href="#">colorlib_Collection</a></h5>
            </div>
        </div>
        <div class="insta-item set-bg" data-setbg="${ImageURL}/insta-2.jpg">
            <div class="inside-text">
                <i class="ti-instagram"></i>
                <h5><a href="#">colorlib_Collection</a></h5>
            </div>
        </div>
        <div class="insta-item set-bg" data-setbg="${ImageURL}/insta-3.jpg">
            <div class="inside-text">
                <i class="ti-instagram"></i>
                <h5><a href="#">colorlib_Collection</a></h5>
            </div>
        </div>
        <div class="insta-item set-bg" data-setbg="${ImageURL}/insta-4.jpg">
            <div class="inside-text">
                <i class="ti-instagram"></i>
                <h5><a href="#">colorlib_Collection</a></h5>
            </div>
        </div>
        <div class="insta-item set-bg" data-setbg="${ImageURL}/insta-5.jpg">
            <div class="inside-text">
                <i class="ti-instagram"></i>
                <h5><a href="#">colorlib_Collection</a></h5>
            </div>
        </div>
        <div class="insta-item set-bg" data-setbg="${ImageURL}/insta-6.jpg">
            <div class="inside-text">
                <i class="ti-instagram"></i>
                <h5><a href="#">colorlib_Collection</a></h5>
            </div>
        </div>
    </div>
    <!-- Instagram Section End -->

    <!-- Latest Blog Section Begin -->
    <section class="latest-blog spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <h2>From The Blog</h2>
                    </div>
                </div>
            </div>
            <div class="row">
            <c:forEach var="map" items="${news.listResult}">
                <div class="col-lg-4 col-md-6">
                
                	
                    <div class="single-latest-blog">
                    
                    
                            	<a href="<c:url value='/web/new/${map.id}'/>">
	                                <img src="${ImageURL}/${map.newImage}.jpg" alt="">
                                </a>
                        
                        <div class="latest-text">
                            <div class="tag-list">
                                <div class="tag-item">
                                    <i class="fa fa-calendar-o"></i>
                                    May 4,2019
                                </div>
                                <div class="tag-item">
                                    <i class="fa fa-com ment-o"></i>
                                    5
                                </div>
                            </div>
                            <a href="#">
                                <h4>The Best Street Style From London Fashion Week</h4>
                            </a>
                            <p>Sed quia non numquam modi tempora indunt ut labore et dolore magnam aliquam quaerat </p>
                        </div>
                    </div>
                 
                </div>
                </c:forEach>
               
            </div>
            <div class="benefit-items">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="single-benefit">
                            <div class="sb-icon">
                                <img src="${ImageURL}/icon-1.png" alt="">
                            </div>
                            <div class="sb-text">
                                <h6>Free Shipping</h6>
                                <p>For all order over 99$</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="single-benefit">
                            <div class="sb-icon">
                                <img src="${ImageURL}/icon-2.png" alt="">
                            </div>
                            <div class="sb-text">
                                <h6>Delivery On Time</h6>
                                <p>If good have prolems</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="single-benefit">
                            <div class="sb-icon">
                                <img src="${ImageURL}/icon-3.png" alt="">
                            </div>
                            <div class="sb-text">
                                <h6>Secure Payment</h6>
                                <p>100% secure payment</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Latest Blog Section End -->

   <script type="text/javascript">
   		
   
   
   
   </script>

</body>

</html>