<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<META HTTP-EQUIV="Refresh" CONTENT="3;URL=./index.do">
<title>Insert title here</title>
<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>
<style type="text/css">
#loadingimg {
	position: absolute;
	width: 442px;
    height: 384px;
    top:50%;
    left:50%;
    transform: translate(-50%, -50%);
}
</style> 
</head>
<body>
	<img id="loadingimg" style="display:none;" 
	src="/project01/images/img_intro.jpg" alt="">
	
<script> 
  $(document).ready(function () { 
       setTimeout(function() { 
			$("#loadingimg").fadeIn(1500); 
       }); 
  }); 
</script> 
</body>
</html>