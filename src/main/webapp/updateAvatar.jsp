<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div style="display: flex; justify-content: space-around;">

		<div style="height: 400px; width: 50%;">
			<img style="height: 400px; width: 50%;" alt="" src="./upload/avatar/${sessionScope.nameavatar}">
		</div>

		<div>
			<form action="updateAvatar" method="post" enctype="multipart/form-data">
				<input id="imgInp" style="font-size: 30px;" type="file"
					accept="image/*" name="avatar" placeholder="choose avatar"><br>
				<img style="height: 300px; width: 300px;" id="blah" src="#"
					alt="your image" /><br>
				<button style="font-size: 40px; margin-top: 40px;">update
					avatar</button>
			</form>
		</div>
	</div>

	<script type="text/javascript">
  imgInp.onchange = evt => {
	  const [file] = imgInp.files
	  if (file) {
	    blah.src = URL.createObjectURL(file)
	  }
	}
  </script>
</body>
</html>