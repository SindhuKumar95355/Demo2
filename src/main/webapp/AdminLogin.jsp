<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<%@include file="components/bootstrap.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
<%@page isELIgnored="false" %>
	<%@include file="components/navbar.jsp"%>

		<h3 class="text-center pt-2"> Admin login</h3>
		
		<c:if test="${ not empty success }">
			<h5 class="text-center"> ${  success }</h5>
			<c:remove var="success"/>
		</c:if>
		
		<c:if test="${ not empty fail }">
			<h5 class="text-center"> ${  fail }</h5>
			<c:remove var="fail"/>
		</c:if>
<div class="container-md">

<div class="row">
<div class="col-md-6 offset-md-3">

<form action="AdminServlet" method="post">
	<table class="mt-5 table table-bordered text-center" >
	
	<thead>
	 	<tr> 
	 		<th> Enter the User ID : <input type="text" name="id" style="margin-left: 50px"></th>
	 	</tr>
	 	<tr>
	 		<th> Enter the User Password : <input type="password" name="pass"></th>
	 	</tr>
	 	
	</thead>
	
	</table>
	<input type="submit" class="btn btn-outline-primary btn-sm">
	</form>
	</div>
</div>
</div>
</body>
</html>