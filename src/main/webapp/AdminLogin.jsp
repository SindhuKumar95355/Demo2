<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="WebServlets.AdminLogout"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin login</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@include file="components/bootstrap.jsp" %>
</head>
<body>
<%@ include file = "components/navbar.jsp" %>

		<h2 class="text text-center">Admin Login</h2>
		
	<%-- 	<c:if test="${ not empty Logout }"> 
			<h4>${Logout }</h4>
			<c:remove var="Logout"/>
		</c:if>
		
		<h2 class="text text-center">Login</h2>
	<c:if test="${not empty logout }">
		<h3 style="text-align: center;">${logout }</h3>
		<c:remove var="logout"/>
	</c:if> --%>
	
	<%  Object as = session.getAttribute("obj");
		System.out.println(as);
	
	if(as != null)
	{
	%>
	<h4 class="text text-center text-success">${obj}</h4>
	<%
	session.removeAttribute("obj");
	}
	%>
	
	<div class="container-md">
	<div class="row">
	<div class="col-md-4 offset-md-4">
		<div  class="card">
			<div class="card-body">
			<form action="AdminLoginServlet" >
				<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Enter email
								</label> <input type="email" name="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp" required="required">
							</div>
						<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Enter password
								</label> <input type="password" name="pass" class="form-control"
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