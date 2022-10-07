<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- link css -->
<link rel="stylesheet"
	href="./assets-all-page/assets-login/css/login.css">

<!-- link icon  -->
<script src="https://kit.fontawesome.com/f2fb0df734.js"
	crossorigin="anonymous"></script>
<title>log seller</title>
</head>
<body>
	<div style="height: 100%;" class="container" id="container">
		<div class="form-container sign-up-container">
			<form action="registerSeller" method="post">
				<h1>Create Account</h1>
				<div class="social-container">
					<a href="#" class="social"><i class="fab fa-facebook-f"></i></a> <a
						href="#" class="social"><i class="fab fa-google-plus-g"></i></a> <a
						href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
				</div>
				<span>or use phone for registration</span> 
				<input type="text" placeholder="Name" name="fullname" />
					 <input type="text" placeholder="user name" name="username"/>
				<input type="password" placeholder="Password" name="password"/> <input type="tel"
					placeholder="Phone" name="phone"/> <input type="text" placeholder="Address" name="address"/>
				<input type="email" placeholder="email" name="email"/>
				<input type="text" placeholder="id card" name="idcard"/>

				<button style="cursor: pointer;" >Sign Up</button>
			</form>
		</div>
		<div class="form-container sign-in-container">
			<form action="logseller">
				<h1>Sign in</h1>
				<div class="social-container">
					<a href="#" class="social"><i class="fab fa-facebook-f"></i></a> <a
						href="#" class="social"><i class="fab fa-google-plus-g"></i></a> <a
						href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
				</div>
				<span>or use your account</span> <input type="text"
					placeholder="user name" name="username"/> <input type="password"
					placeholder="Password" name="password"/> <a href="#">Forgot your password?</a>
				<button style="cursor: pointer;">Sign In</button>
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>Welcome Back!</h1>
					<p>To keep connected with us please login with your personal
						info</p>
					<button style="cursor: pointer;" class="ghost" id="signIn">Sign In</button>
				</div>
				<div class="overlay-panel overlay-right">
					<h1>Hello, Friend!</h1>
					<p>Enter your personal details and start journey with us</p>
					<button style="cursor: pointer;" class="ghost" id="signUp">Sign Up</button>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="./assets-all-page/assets-login/js/login.js"></script>

	
</body>
</html>