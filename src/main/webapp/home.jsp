<%@page import="entity.user"%>
<%@page import="model.DAO"%>
<%@page import="entity.product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%! List<product> listproduct = new ArrayList<product>(); 
boolean result = false;
String category = "";
boolean checkcategory = false;
%>
<%
	listproduct = DAO.loadProductInMain();
	if(listproduct != null){
		result = true;
	}
	
	if(session != null){
		
		
		category =(String) session.getAttribute("category");
		if(category != null && category.equals("seller")){
			checkcategory = true;
		}
	}
	
%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>shop</title>
<!-- Bootstrap core CSS -->
<link href="./assets-all-page/assets-home/css/bootstrap.css"
	rel="stylesheet">
<!-- Fontawesome core CSS -->
<link href="./assets-all-page/assets-home/css/font-awesome.min.css"
	rel="stylesheet">
<!--GOOGLE FONT -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet" type="text/css">
<!--Slide Show Css -->
<link href="./assets-all-page/assets-home/ItemSlider/css/main-style.css"
	rel="stylesheet">
<!-- custom CSS here -->
<link href="./assets-all-page/assets-home/css/style.css"
	rel="stylesheet">
</head>

<body style="">
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><strong>DIGI</strong> Shop</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">


				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Track Order</a></li>

					<!-- if user log  -->
					<c:if test="${sessionScope.username != null}">
						<c:if test="${sessionScope.loadInforUser.getCategory().equals('user')}">
							<li><a href="/websport/logout">logout</a></li>
							<li><a href="/websport/profileUser">profile</a></li>
						</c:if>
						
	  					<c:if test="<%=checkcategory %>">
	  						<li><a href="homeSeller.jsp">move to home seller</a></li>
	  					</c:if>
					</c:if>

					<!-- if user logouted -->
					<c:if test="${sessionScope.username == null}">
						<li><a href="login.jsp">Login</a></li>
						 <li><a href="loginSeller.jsp">login seller</a></li>
					</c:if>
					
					
					

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">24x7 Support <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#"><strong>Call: </strong>+09-456-567-890</a></li>
							<li><a href="#"><strong>Mail: </strong>info@yourdomain.com</a></li>
							<li class="divider"></li>
							<li><a href="#"><strong>Address: </strong>
									<div>
										234, New york Street,<br> Just Location, USA
									</div> </a></li>
						</ul></li>
					<c:if test="${sessionScope.username != null}">
						<c:if test="${sessionScope.loadInforUser.getCategory().equals('user')}">
					
							<li
								style="background-image: url('./upload/avatar/${sessionScope.nameavatar}'); 
								background-size: cover;
								    background-position: center;
								    background-repeat: no-repeat;
								    border-radius: 26px;
								    padding: 10px 10px;">
								<a href="profile.jsp"> </a>
		
							</li>
					
					         <li style="margin-left:10px">
							<p style="color: #fff;">xin chào</p>
							<p style="color: red; font-size: 15px; margin-top:-5px;">${sessionScope.lastname}</p>
							</li>
						</c:if>
					</c:if>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" placeholder="Enter Keyword Here ..."
							class="form-control">
					</div>
					&nbsp;
					<button type="submit" class="btn btn-primary">Search</button>
				</form>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div class="well well-lg offer-box text-center">


					Today's Offer : &nbsp; <span class="glyphicon glyphicon-cog"></span>&nbsp;40
					% off on purchase of $ 2,000 and above till 24 dec !


				</div>
				<div class="main box-border">
					<div id="mi-slider" class="mi-slider">
						<ul class="mi-current">

						
							<li><a href="#"> <img
									src="./assets-all-page/assets-home/ItemSlider/images/1.webp"
									alt="img01">
									<h4>ADIDAS</h4>
							</a></li>
							<li><a href="#"> <img
									src="./assets-all-page/assets-home/ItemSlider/images/2.webp"
									alt="img02">
									<h4>NIKE</h4>
							</a></li>
							<li><a href="#"> <img
									src="./assets-all-page/assets-home/ItemSlider/images/3.png"
									alt="img03">
									<h4>BALANCE</h4>
							</a></li>
							<li><a href="#"> <img
									src="./assets-all-page/assets-home/ItemSlider/images/4.png"
									alt="img04">
									<h4>SNEAKERS</h4>
							</a></li>
						</ul>
						<ul>
							<li><a href="#"> <img
									src="./assets-all-page/assets-home/ItemSlider/images/5.jpg"
									alt="img05">
									<h4>Belts</h4>
							</a></li>
							<li><a href="#"> <img
									src="./assets-all-page/assets-home/ItemSlider/images/6.jpg"
									alt="img06">
									<h4>Hats &amp; Caps</h4>
							</a></li>
							<li><a href="#"> <img
									src="./assets-all-page/assets-home/ItemSlider/images/7.jpg"
									alt="img07">
									<h4>Sunglasses</h4>
							</a></li>
							<li><a href="#"> <img
									src="./assets-all-page/assets-home/ItemSlider/images/8.jpg"
									alt="img08">
									<h4>Scarves</h4>
							</a></li>
						</ul>
						<ul>
							<li><a href="#"> <img
									src="./assets-all-page/assets-home/ItemSlider/images/9.jpg"
									alt="img09">
									<h4>Casual</h4>
							</a></li>
							<li><a href="#"> <img
									src="./assets-all-page/assets-home/ItemSlider/images/10.jpg"
									alt="img10">
									<h4>Luxury</h4>
							</a></li>
							<li><a href="#"> <img
									src="./assets-all-page/assets-home/ItemSlider/images/11.jpg"
									alt="img11">
									<h4>Sport</h4>
							</a></li>
						</ul>
						<ul>
							<li><a href="#"> <img
									src="./assets-all-page/assets-home/ItemSlider/images/12.jpg"
									alt="img12">
									<h4>Carry-Ons</h4>
							</a></li>
							<li><a href="#"> <img
									src="./assets-all-page/assets-home/ItemSlider/images/13.jpg"
									alt="img13">
									<h4>Duffel Bags</h4>
							</a></li>
							<li><a href="#"> <img
									src="./assets-all-page/assets-home/ItemSlider/images/14.jpg"
									alt="img14">
									<h4>Laptop Bags</h4>
							</a></li>
							<li><a href="#"> <img
									src="./assets-all-page/assets-home/ItemSlider/images/15.jpg"
									alt="img15">
									<h4>Briefcases</h4>
							</a></li>
						</ul>
						<nav>
							<a href="#" class="mi-selected">Shoes</a> <a href="#">Accessories</a>
							<a href="#">Watches</a> <a href="#">Bags</a>
						</nav>
					</div>

				</div>
				<br>
			</div>
			<!-- /.col -->

			<div class="col-md-3 text-center">
				<div class=" col-md-12 col-sm-6 col-xs-6">
					<div class="offer-text">30% off here</div>
					<div class="thumbnail product-box">
						<img src="./assets-all-page/assets-home/img/dummyimg.png" alt="">
						<div class="caption">
							<h3>
								<a href="#">Samsung Galaxy </a>
							</h3>
							<p>
								<a href="#">Ptional dismiss button </a>
							</p>
						</div>
					</div>
				</div>
				<div class=" col-md-12 col-sm-6 col-xs-6">
					<div class="offer-text2">30% off here</div>
					<div class="thumbnail product-box">
						<img src="./assets-all-page/assets-home/img/dummyimg.png" alt="">
						<div class="caption">
							<h3>
								<a href="#">Samsung Galaxy </a>
							</h3>
							<p>
								<a href="#">Ptional dismiss button </a>
							</p>
						</div>
					</div>
				</div>
			</div>
			<!-- /.col -->
		</div>
		
			<div>
			<!-- /.col -->
			<div class="col-md-9">
				<div>
					<ol class="breadcrumb">
						<li><a href="#">Home</a></li>
						<li class="active">Electronics</li>
					</ol>
				</div>
				
				
				<!-- /.div -->
				<div class="row">
					<div class="btn-group alg-right-pad">
						<button type="button" class="btn btn-default">
							<strong>1235 </strong>items
						</button>
						<div class="btn-group">
							<button type="button" class="btn btn-danger dropdown-toggle"
								data-toggle="dropdown">
								Sort Products &nbsp; <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="#">By Price Low</a></li>
								<li class="divider"></li>
								<li><a href="#">By Price High</a></li>
								<li class="divider"></li>
								<li><a href="#">By Popularity</a></li>
								<li class="divider"></li>
								<li><a href="#">By Reviews</a></li>
							</ul>
						</div>
					</div>
				</div>
				
				
				
				<!-- product -->
				
				<!-- check fetch data in db is succes -->
				<c:if test="<%=result%>">
						<div style="width:100%; display:flex; justify-content: space-around; flex-wrap: wrap;">
						<c:forEach var="product" items="<%=listproduct%>">
							<div style="width: 33%;" class="col-md-4 text-center col-sm-6 col-xs-6">
								<div sty class="thumbnail product-box">
									<img src="./upload/product/${product.getNameimgOrVideo()}" alt="">
									<div class="caption">
										<h3>
											<a href="#">${product.getNameproduct().substring(0, 30)}</a>
										</h3>
										<p>
											Price : <strong>$ 3,45,900</strong>
										</p>
										
										<p>
											<a href="#" class="btn btn-success" role="button">Add To
												Cart</a> <a href="/websport/detailProductUser?id=${product.getIdproduct()}" class="btn btn-primary" role="button">See
												Details</a>
										</p>
									</div>
								</div>
							</div>
						</c:forEach>
							</div>
					</c:if>
					
					
				</div>
				<!-- /.row -->
				<div  class="row">
					<ul class="p	agination alg-right-pad">
						<li><a href="#">«</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">»</a></li>
					</ul>
				</div>
				<!-- /.row -->
				
				
				
				</div>
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->
	<div class="col-md-12 download-app-box text-center">

		<span class="glyphicon glyphicon-download-alt"></span>Download Our
		Android App and Get 10% additional Off on all Products . <a href="#"
			class="btn btn-danger btn-lg">DOWNLOAD NOW</a>

	</div>

	<!--Footer -->
	<div class="col-md-12 footer-box">


		<div class="row small-box ">
			<strong>Mobiles :</strong> <a href="#">samsung</a> | <a href="#">Sony</a>
			| <a href="#">Microx</a> | <a href="#">samsung</a> | <a href="#">Sony</a>
			| <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a>
			| <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a>
			| <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a>
			| <a href="#">Microx</a> | <a href="#">samsung</a> | <a href="#">Sony</a>
			| <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a>
			| <a href="#">Microx</a> | view all items

		</div>
		<div class="row small-box ">
			<strong>Laptops :</strong> <a href="#">samsung</a> | <a href="#">Sony</a>
			| <a href="#">Microx Laptops</a> | <a href="#">samsung</a> | <a
				href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a>
			| <a href="#">Sony Laptops</a> | <a href="#">Microx</a> |<a href="#">samsung</a>
			| <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a>
			| <a href="#">Sony</a> | <a href="#">Microx</a> | <a href="#">samsung</a>
			| <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a>
			| <a href="#">Sony</a> | <a href="#">Microx</a> | view all items
		</div>
		<div class="row small-box ">
			<strong>Tablets : </strong><a href="#">samsung</a> | <a href="#">Sony
				Tablets</a> | <a href="#">Microx</a> | <a href="#">samsung </a>| <a
				href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a>
			| <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung
				Tablets</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung
				Tablets</a> | <a href="#">Sony</a> | <a href="#">Microx</a> | <a
				href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a>
			|<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx
				Tablets</a> | view all items

		</div>
		<div class="row small-box pad-botom ">
			<strong>Computers :</strong> <a href="#">samsung</a> | <a href="#">Sony</a>
			| <a href="#">Microx</a> | <a href="#">samsung Computers</a> | <a
				href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a>
			| <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a>
			| <a href="#">Sony</a> | <a href="#">Microx Computers</a> |<a
				href="#">samsung Computers</a> | <a href="#">Sony</a> | <a href="#">Microx</a>
			| <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx
				Computers</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a
				href="#">Microx</a> | view all items

		</div>
		<div class="row">
			<div class="col-md-4">
				<strong>Send a Quick Query </strong>
				<hr>
				<form>
					<div class="row">
						<div class="col-md-6 col-sm-6">
							<div class="form-group">
								<input type="text" class="form-control" required="required"
									placeholder="Name">
							</div>
						</div>
						<div class="col-md-6 col-sm-6">
							<div class="form-group">
								<input type="text" class="form-control" required="required"
									placeholder="Email address">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 col-sm-12">
							<div class="form-group">
								<textarea name="message" id="message" required="required"
									class="form-control" rows="3" placeholder="Message"></textarea>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary">Submit
									Request</button>
							</div>
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-4">
				<strong>Our Location</strong>
				<hr>
				<p>
					234, New york Street,<br> Just Location, USA<br> Call:
					+09-456-567-890<br> Email: info@yourdomain.com<br>
				</p>

				2014 www.yourdomain.com | All Right Reserved
			</div>
			<div class="col-md-4 social-box">
				<strong>We are Social </strong>
				<hr>
				<a href="#"><i class="fa fa-facebook-square fa-3x "></i></a> <a
					href="#"><i class="fa fa-twitter-square fa-3x "></i></a> <a
					href="#"><i class="fa fa-google-plus-square fa-3x c"></i></a> <a
					href="#"><i class="fa fa-linkedin-square fa-3x "></i></a> <a
					href="#"><i class="fa fa-pinterest-square fa-3x "></i></a>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Curabitur nec nisl odio. Mauris vehicula at nunc id posuere.
					Curabitur nec nisl odio. Mauris vehicula at nunc id posuere.</p>
			</div>
		</div>
		<hr>
	</div>
	<!-- /.col -->
	<div class="col-md-12 end-box ">© 2014 | &nbsp; All Rights
		Reserved | &nbsp; www.yourdomain.com | &nbsp; 24x7 support | &nbsp;
		Email us: info@yourdomain.com</div>
	<!-- /.col -->
	<!--Footer end -->
	<!--Core JavaScript file  -->
	<script src="./assets-all-page/assets-home/js/jquery-1.10.2.js"></script>
	<!--bootstrap JavaScript file  -->
	<script src="./assets-all-page/assets-home/js/bootstrap.js"></script>
	<!--Slider JavaScript file  -->
	<script
		src="./assets-all-page/assets-home/ItemSlider/js/modernizr.custom.63321.js"></script>
	<script
		src="./assets-all-page/assets-home/ItemSlider/js/jquery.catslider.js"></script>
	<script>
		$(function() {

			$('#mi-slider').catslider();

		});
	</script>


</body>
</html>