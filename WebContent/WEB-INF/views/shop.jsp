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
<table>
	<thead>
		<tr>
		<th>id</th>
		<th>produit</th>
		<th>prix</th>
		<th>add</th>
		<th>rm</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${inventaire}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.price}</td>
				
				<td><a href = "<c:url value="/cart/add/${p.id}" />">+</a></td>
				<td><a href = "<c:url value="/cart/rm/${p.id}" />">-</a></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<th colspan="3"> See my cart: </th>
		<th><a href="<c:url value="/cart/show" />">myCart</a></th>
	</tfoot>
</table>
</body>
</html>





