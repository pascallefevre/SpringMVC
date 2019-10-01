<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/titletag.jsp"></jsp:include>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js">
  </script>
</head>
<body>
<div class="formulaire">
	<!-- row -->
	<div class="row">
		<div class = "col-sm-4"><p>Connected as "${name}"</p></div>
		<div class = "col-sm-1"></div>
		<div class = "col-sm-5">
		<p>page 1: home </p>
		</div>
		<div class = "col-sm-2"><a href="login" >login</a></div>
	</div>
</div>
</body>
</html>