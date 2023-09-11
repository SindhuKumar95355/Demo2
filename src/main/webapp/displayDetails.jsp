<%@page import="DaoClass.DAO"%>
<%@page import="Entity_and_DB.Con_DB"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All students details</title>
<%@include file="components/bootstrap.jsp"%>
<%@page isELIgnored="false" %>

</head>
<body>
<%@include file="components/navbar.jsp"%>

	<h3 class="text-center"> All Student Details</h3>
	
	<% 
		String mesg = (String)session.getAttribute("success");
		if(mesg.equals("success"))
		{
	%>
		<h3 class="text-center text-success"> <%=mesg %></h3>
	<%
		session.removeAttribute("success");
	
		} %>
	
		<!-- <div class="container">
		<div class="row">
		<div class="col-md-6 offset-md-3"> -->
		
			<table class="table table-bordered table-striped table-hover text-center color-white container-md w-50">
						<thead class="bg-success text-white">
							<tr>
								<th>Sl_no</th>
								<th>Name</th>
								<th>Email</th>
								<th>Password</th>
								<th>USN</th>
								<th>Branch</th>
								<th>Action</th>
							</tr>
						</thead>
						
						<% List<Con_DB> list = DAO.displayAll();
							for(Con_DB con : list)
							{
	
						%>
						<tbody>
							<tr>

								<td><%=con.getId()%></td>
								<td><%=con.getName()%></td>
								<td><%=con.getEmail()%></td>
								<td><%=con.getPassword()%></td>
								<td><%=con.getUSN()%></td>
								<td><%=con.getBranch()%></td>
								<td><a href="editpage.jsp?id=<%=con.getId()%>" class="btn btn-outline-primary btn-sm">Edit</a>
									<a href="delete?id=<%=con.getId() %>" class="btn btn-outline-danger btn-sm">Delete</a>
								</td>

							</tr>
						</tbody>
						<%} %>
					</table>
		
	<!-- 	</div>
		</div>
		</div> -->
</body>
</html>