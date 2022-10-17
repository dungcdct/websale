<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add product</title>
</head>
<body>
	<form action="addproduct" method="post" enctype="multipart/form-data">

			<input style="padding: 5px;margin-top:20px;" type="text" placeholder="name" name="name" required=""><br>
			 
			<input style="padding: 5px;margin-top:20px;" type="text" placeholder="price" name="price"
			required=""><br>
			
			<p><label for="w3review">Mô Tả Sản Phẩm</label></p>
			<textarea id="w3review" style="padding: 5px;" name="describe" rows="10" cols="50"></textarea><br>
			 
			<input style="padding: 5px;margin-top:20px;" type="file" id="imgInp"
			accept="image/*,video/*" name="introduceProduct"><br>
			
			 <img style="height: 300px; width: 300px;" id="blah"
			alt="image or video to introduce product" src="#"><br>
			 
			 <input style="padding: 5px;margin-top:20px;" type="submit" value="Add product"><br>
	</form>

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