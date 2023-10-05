<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page isELIgnored="false" %>
<%@include file="components/bootstrap.jsp" %>
</head>
<body>
<%@ include file = "components/navbar.jsp" %>

<% response.setHeader("cache-control", "no-cache, no-store, must-revalidate"); %>

	<h2 class="text text-center">Login</h2>
	<c:if test="${not empty logout }">
		<h3 style="text-align: center;">${logout }</h3>
		<c:remove var="logout"/>
	</c:if>
	
	<div class="container-md">
	<div class="row">
	<div class="col-md-4 offset-md-4">
		<div  class="card">
			<div class="card-body">
			<form action="Loginservlet" >
				<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Enter Name
								</label> <input type="text" name="name" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp" required="required">
							</div>
						<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Enter ID
								</label> <input type="text" name="id" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp" required="required">
							</div>
							
							<button type="submit" class=" btn btn-primary btn-md btn-hover">Login</button>
				</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>