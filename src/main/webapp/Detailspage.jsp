<%@page import="EntityANDfactory.ENT1"%>
<%@page import="java.util.List"%>
<%@page import="EntityANDfactory.sessionfactory"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Query"%>
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
					
						<h1 class=" text text-center">Add Details</h1>
						
						<c:if test="${ not empty success }"> 
							<h4 class="text text-center text-success">${success }</h4>
							<c:remove var="success"/>
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
										<th>Action</th>
									</tr>
								</thead>
								<% 
		Session s = sessionfactory.factory().openSession();
		Query q =  s.createQuery("from ENT1");
		
		List<ENT1> list = q.list();
		for(ENT1 e : list) 
		{
		%>
								<tbody >
									<tr>
										<td><%= e.getSL_NO() %></td>
										<td><%= e.getID() %></td>
										<td><%= e.getName() %></td>
										<td><%= e.getRole()%></td>
										<td><%= e.getCity()%></td>
										<td><%= e.getJoinedDate()%></td>
										<td><%= e.getWork_Status()%></td>
										<td>  
										<a href="editpage.jsp?ID=<%=e.getID()%>" rel="Null" class="btn btn-sm btn-success m-1" > Update </a>
										<a href="Deletepage?ID=<%=e.getID()%>" rel="Null" class="btn btn-sm btn-danger" > Delete </a>
										</td>
									</tr> 
								</tbody>
		<%}
		s.close();
		%>
							</table>
							<form action="AdminLogout">
								<button class="btn btn-danger btn-hover">Logout</button>
							</form>
						</div>
					</div>
				</div>
			
</body>
</html>