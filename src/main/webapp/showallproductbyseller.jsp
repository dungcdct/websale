<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@page import="model.DAO"%>
<%@page import="entity.product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%!List<product> listproduct = new ArrayList<product>();
	boolean result = false;%>
<%
listproduct = (List<product>) request.getAttribute("productofseller");
if (listproduct != null) {
	result = true;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="./assets-all-page/assets-home/css/style.css"
	rel="stylesheet">

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
<title>show all product</title>
</head>
<body>
	<div style="width: 100%; display: flex; justify-content: space-between;flex-wrap: nowrap;">
		<c:if test="<%=result%>">
			<c:forEach var="product" items="<%=listproduct%>">
					<div class="col-md-4 text-center col-sm-6 col-xs-6">
						<div class="thumbnail product-box">
							<img src="./upload/product/${product.getNameimgOrVideo()}" alt="">
							<div class="caption">
								<h3>
									<a href="#">${product.getNameproduct()}</a>
								</h3>
								<p>
									Price : <strong>$ 3,45,900</strong>
								</p>
								<p>
									<a href="#">Ptional dismiss button </a>
								</p>
								<p>Ptional dismiss button in tional dismiss button in</p>
								<p>
									<a href="/deleteproductbyseller?id=${product.getIdproduct()}" class="btn btn-success" role="button">delete</a> 
									<a href="#" class="btn btn-primary" role="button">See
										Details</a>
								</p>
							</div>
						</div>
					</div>
			</c:forEach>
		</c:if>
	</div>
	<div style="margin-top: 50px; text-align: center; margin-bottom: 100px;">
		<a style="font-size:20px; color:red;" href="homeSeller.jsp">Home</a>
	</div>
</body>
</html>