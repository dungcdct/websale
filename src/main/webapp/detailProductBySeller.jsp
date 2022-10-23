<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css">
<link rel="stylesheet"
	href="./assets-all-page/assets-detail-product/detailcss.css">
<title>detail product</title>
</head>
<body>
	<div class="pd-wrap">
		<div class="container">
			<div class="heading-section">
				<h2>Product Details</h2>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div id="slider" class="owl-carousel product-slider">
						<div class="item">
							<img
								src="./upload/product/${requestScope.loadProduct.getNameimgOrVideo()}" />
						</div>
						<div class="item">
							<img src="https://scontent.fhan5-3.fna.fbcdn.net/v/t1.6435-9/160272578_817263438878953_4617699401484560687_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=174925&_nc_ohc=TcY38JW47icAX8fSj0a&_nc_ht=scontent.fhan5-3.fna&oh=00_AT8TwvXmTHXPEVDUQAZjoXAm8F5EJDHx06VgDd5SA5gSxA&oe=63796866" />
						</div>
						<div class="item">
							<img
								src="https://scontent.fhan5-3.fna.fbcdn.net/v/t1.6435-9/160272578_817263438878953_4617699401484560687_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=174925&_nc_ohc=TcY38JW47icAX8fSj0a&_nc_ht=scontent.fhan5-3.fna&oh=00_AT8TwvXmTHXPEVDUQAZjoXAm8F5EJDHx06VgDd5SA5gSxA&oe=63796866" />
						</div>
						<div class="item">
							<img src="https://scontent.fhan5-3.fna.fbcdn.net/v/t1.6435-9/160272578_817263438878953_4617699401484560687_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=174925&_nc_ohc=TcY38JW47icAX8fSj0a&_nc_ht=scontent.fhan5-3.fna&oh=00_AT8TwvXmTHXPEVDUQAZjoXAm8F5EJDHx06VgDd5SA5gSxA&oe=63796866" />
						</div>
						<div class="item">
							<img
								src="https://scontent.fhan5-3.fna.fbcdn.net/v/t1.6435-9/160272578_817263438878953_4617699401484560687_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=174925&_nc_ohc=TcY38JW47icAX8fSj0a&_nc_ht=scontent.fhan5-3.fna&oh=00_AT8TwvXmTHXPEVDUQAZjoXAm8F5EJDHx06VgDd5SA5gSxA&oe=63796866" />
						</div>
						<div class="item">
							<img src="https://scontent.fhan5-3.fna.fbcdn.net/v/t1.6435-9/160272578_817263438878953_4617699401484560687_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=174925&_nc_ohc=TcY38JW47icAX8fSj0a&_nc_ht=scontent.fhan5-3.fna&oh=00_AT8TwvXmTHXPEVDUQAZjoXAm8F5EJDHx06VgDd5SA5gSxA&oe=63796866" />
						</div>
						<div class="item">
							<img
								src="https://scontent.fhan5-3.fna.fbcdn.net/v/t1.6435-9/160272578_817263438878953_4617699401484560687_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=174925&_nc_ohc=TcY38JW47icAX8fSj0a&_nc_ht=scontent.fhan5-3.fna&oh=00_AT8TwvXmTHXPEVDUQAZjoXAm8F5EJDHx06VgDd5SA5gSxA&oe=63796866" />
						</div>
					</div>
					
				</div>
				<div class="col-md-6">
					<div class="product-dtl">
						<div class="product-info">
							<div class="product-name">${requestScope.loadProduct.getNameproduct()}</div>
							<div class="reviews-counter">
								
								<a href="#">3 Reviews</a>
							</div>
							<div class="product-price-discount">
								<span>$${requestScope.loadProduct.getPrice()}</span><span class="line-through">$29.00</span>
							</div>
						</div>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
							sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua. Ut enim ad minim veniam, quis nostrud exercitation
							ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>

						<a href="#" class="round-black-btn">Home</a> <a href="#"
							class="round-black-btn">Delete</a> <a href="#"
							class="round-black-btn">Update</a>

					</div>
				</div>
			</div>
			<div class="product-info-tabs">
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item"><a class="nav-link active"
						id="description-tab" data-toggle="tab" href="#description"
						role="tab" aria-controls="description" aria-selected="true">Description</a>
					</li>
					
				</ul>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="description"
						role="tabpanel" aria-labelledby="description-tab">${requestScope.loadProduct.getDescribe()}</div>
					
				</div>
			</div>

		
		</div>
	</div>
	
	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity=" sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script type="text/javascript"
		src="./assets-all-page/assets-detail-product/detail.js"></script>
</body>
</html>