<%@page import="EntityANDfactory.ENT1"%>
<%@page import="EntityANDfactory.sessionfactory"%>
<%@page import="org.hibernate.Session"%>
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

	<div class="container-md">
		<div class="row">
			<div class="col-md-6 offset-md-3">
					
						<h1 class=" text text-center ">Details page</h1>
						
							<c:if test="${not empty success1 }">
							<h3 class=" text-center text-success">${success1 }</h3>
							<c:remove var="success1"/>
							</c:if>
							
							<c:if test="${not empty fail }">
							<h3 class="text text-center text-warning">${fail }</h3>
							<c:remove var="fail"/>
							</c:if>
						
							<table class="  table table-bordered container ">
								<thead class="  table-success">
									<tr >
										<th>SL NO</th>
										<th>ID</th>
										<th>Name</th>
										<th>Role</th>
										<th> City </th>
										<th>Joined Date</th>								
										<th>Work Status</th>
									</tr>
								</thead>
								<% 
		/* Session s = sessionfactory.factory().openSession();
		s.beginTransaction(); */
		ENT1 e = (ENT1)session.getAttribute("success");
		
		%>
								<tbody class="text text-center">
									<tr>
									
										<td><%= e.getSL_NO() %></td>
										<td><%= e.getID() %></td>
										<td><%= e.getName() %></td>
										<td><%= e.getRole()%></td>
										<td><%= e.getCity()%></td>
										<td><%= e.getJoinedDate()%></td>
										<td><%= e.getWork_Status()%></td>
										
									</tr> 
								</tbody>
		<%
		/* s.getTransaction().commit();
		s.close(); */
		%>
							</table>
							<form action="EmployeeLogout">
							<button class="btn btn-danger btn-hover btn-sm">Logout</button>
							</form>
						</div>
					</div>
				</div>
</body>
</html>