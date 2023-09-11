<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display page</title>
<%@include file="components/bootstrap.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<%@include file="components/navbar.jsp"%>
	
	<c:if test="${not empty success }">
		<p>${success }</p>
		<c:remove var="success"/>
	</c:if>
	
	<c:if test="${not empty fail }">
		<p>${fail }</p>
		<c:remove var="fail"/>
	</c:if>

	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-head">
						<h3 class="text-center">Login If Existing User</h3>
					</div>
					<div class="card-body mb-3">
						<form action="loginServlet" method="post">
							<div class="mb-3">
								<label for="exampleInputEmail1" class="from-label">Enter
									Email <input type="email" name="email">
								</label>
							</div>
							<div class="mb-3">
								<label>Enter Password <input type="password" name="pass">
								</label>
							</div>
							<div class="mb-3">
								<button class="btn btn-success btn-md ">submit</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>