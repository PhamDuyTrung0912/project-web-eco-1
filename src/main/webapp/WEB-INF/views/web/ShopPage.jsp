<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ include file="/common/taglib.jsp" %>
	<c:url var="ImageURL" value="/assets/image" />
	<c:url var="ProductURL" value="/web/product" />
	<c:url var="loadMore" value="/api/loadmore" />
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
                        <a href="#"><i class="fa fa-home"></i> Home</a>
                        <span>Shop</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Section Begin -->

    <!-- Product Shop Section Begin -->
    <section class="product-shop spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-8 order-2 order-lg-1 produts-sidebar-filter">
                    <div class="filter-widget">
                        <h4 class="fw-title">Categories</h4>
                        <ul class="filter-catagories">
                            <li><a href="#">Men</a></li>
                            <li><a href="#">Women</a></li>
                            <li><a href="#">Kids</a></li>
                        </ul>
                    </div>
                    
                    <div class="filter-widget">
                        <h4 class="fw-title">Price</h4>
                        <div class="filter-range-wrap">
                            <div class="range-slider">
                                <div class="price-input">
                                    <input type="text" id="minamount">
                                    <input type="text" id="maxamount">
                                </div>
                            </div>
                            <div class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
                                data-min="33" data-max="98">
                                <div class="ui-slider-range ui-corner-all ui-widget-header"></div>
                                <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                            </div>
                        </div>
                        <a href="#" class="filter-btn">Filter</a>
                    </div>
                  
                    
                    <div class="filter-widget">
                        <h4 class="fw-title">Tags</h4>
                        <div class="fw-tags">
                            <a href="#">Towel</a>
                            <a href="#">Shoes</a>
                            <a href="#">Coat</a>
                            <a href="#">Dresses</a>
                            <a href="#">Trousers</a>
                            <a href="#">Men's hats</a>
                            <a href="#">Backpack</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-9 order-1 order-lg-2">
                    <div class="product-show-option">
                        <div class="row">
                            <div class="col-lg-7 col-md-7">
                                <div class="select-option">
                                    <select class="sorting">
                                        <option value="">Default Sorting</option>
                                    </select>
                                    <select class="p-show">
                                        <option value="">Show:</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-5 col-md-5 text-right">
                                <p>Show 01- 09 Of 36 Product</p>
                            </div>
                        </div>
                    </div>
                    <div class="product-list">
                        <div class="row">
                        
                         <c:forEach var="map" items="${model.listResult}">
                            <div class="col-lg-4 col-sm-6">                                             
                                <div class="product-item">
                                    <div class="pi-pic">
                                    
                                 	  <a href="<c:url value='/web/product/${map.id}'/>">
	                                <img src="${ImageURL}/${map.imageProduct}.jpg" alt="">
                             		   </a>   
                                        
                                        <div class="sale pp-sale">Sale</div>
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
                                        <div class="catagory-name">Towel</div>
                                        <a href="#">
                                            <h5>Pure Pineapple</h5>
                                        </a>
                                        <div class="product-price">
                                            $14.00
                                            <span>$35.00</span>
                                        </div>
                                    </div>
                                </div>
                            </div>  
                           </c:forEach>                  
                        </div>
                    </div>
                    <div class="loading-more">
                        <i class="icon_loading"></i>
                        <a href="" id="btnLoadmore">
                            Loading More
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Product Shop Section End -->
	
	
	<script type="text/javascript">
		
	var count=0;
		$('#btnLoadmore').click(function(e){
			e.preventDefault();
			data={};
			count+=1;
			data['count']=count+"";
			
			console.log(data);
			
			FetchDataLoadMore(data);
			
			
		})
		
		function FetchDataLoadMore(data){
			$.ajax({
				url:'${loadMore}',
				type:'POST',
				contentType:'application/json',
				data:JSON.stringify(data),
				dataType:'json',
				success: function(rs){
						
						var load=$('.product-list .row');
						var url=$(location).attr('href').split('btl',1)[0];
						console.log(url);
						$.each(rs,function(index,value){
							
							var image=value.imageProduct;
							var id=value.id;
							var temp='${ImageURL}';
							var temp1='${ProductURL}';
							var src=url+temp.slice(1)+'/'+image+'.jpg';
							var href=url+temp1.slice(1)+'/'+id;
							
							
					var html='<div class="col-lg-4 col-sm-6">'
								+'<div class="product-item">'
									+'<div class="pi-pic">'
									+'<a href="'+href+'">'
                           				 +'<img src="'+src+'" alt="">'
                           				 +'</a>'
                         				   +'<div class="sale pp-sale">Sale</div>'
                          					  +'<div class="icon">'
                          					  +'<i class="icon_heart_alt"></i>'
                           					 +'</div>'
                          				  +'<ul>'
                          				  +  '<li class="w-icon active"><a href="#"><i class="icon_bag_alt"></i></a></li>'
                         			 	  +  '<li class="quick-view"><a href="#">+ Quick View</a></li>'
                           				  +  '<li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>'
                            			  +'</ul>'
                            		+'</div>'
                            		+'<div class="pi-text">'
                                    +'<div class="catagory-name">Towel</div>'
                                   + '<a href="#">'
                                       + '<h5>Pure Pineapple</h5>'
                                   +'</a>'
                                    +'<div class="product-price">'
                                      +  '$14.00  '
                                       + '<span>$35.00</span>'
                                    +'</div>'
                               + '</div>'
								+'</div>'
							+'</div>'
							
							
							;
								
							
							
							
						
							
							load.append(html);
							console.log(src);
                    
						});
					
					
				},
				error: function(err){
					console.log(err);
					
				}	
			})
		}
		
		
		
		
				
	
	</script>


</body>
</html>