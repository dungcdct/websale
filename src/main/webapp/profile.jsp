<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./assets-all-page/assets-profile/profile.css">
</head>
<body>
    
   <!-- this is the markup. you can change the details (your own name, your own avatar etc.) but don’t change the basic structure! -->

<aside class="profile-card">
    <div class="mask-shadow"></div>
    <header>
  
      <!-- here’s the avatar -->
      <a href="updateAvatar.jsp" title="change avatar">
        <img src="./upload/avatar/${sessionScope.nameavatar}" style="size: 200px;">
      </a>
  
      <!-- the fullname , get method full from user requested from server profileuser.java-->
      <h1>${sessionScope.loadInforUser.getFullname()}</h1>
  
      <!-- and role or location -->
      <h2>developer</h2>
  
    </header>
  
    <!-- bit of a bio; who are you? -->
    <div class="profile-bio">
  		<!-- email -->
  		<p style="color:red; border-top: 0.5px solid #a5a5a5;">Email:</p>
  		<h2>${sessionScope.loadInforUser.getEmail()}</h2>
  		
  		<!-- address -->
  		<p style="color:red; border-top: 0.5px solid #a5a5a5;">Address :</p>
      	<p>${sessionScope.loadInforUser.getAddress() }</p>
      	
      	<!-- phone -->
      	<p style="color:red; border-top: 0.5px solid #a5a5a5;">Phone :</p>
      	<p>${sessionScope.loadInforUser.getPhone() }</p>
  
    </div>
  
    <!-- some social links to show off -->
    <ul class="profile-social-links">
  
      <!-- twitter - el clásico  -->
      <li>
        <a href="/registion-jsp-servlet/logout">
          <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/210284/social-twitter.svg">
        </a>
      </li>
  
      <!-- envato – use this one to link to your marketplace profile -->
      <li>
        <a href="https://envato.com">
          <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/210284/social-envato.svg">
        </a>
      </li>
  
      <!-- codepen - your codepen profile-->
      <li>
        <a href="https://codepen.io/tutsplus">
          <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/210284/social-codepen.svg">
        </a>
      </li>
  
      <!-- add or remove social profiles as you see fit -->
  
    </ul>
  
  </aside>
  <!-- that’s all folks! -->
</body>
</html>






