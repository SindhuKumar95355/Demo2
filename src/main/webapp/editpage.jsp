<%@page import="Entity_and_DB.Con_DB"%>
<%@page import="DaoClass.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include  file="components/bootstrap.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="components/navbar.jsp" %>

</head>
<body>

<% 	
			int id = Integer.parseInt(request.getParameter("id"));
			Con_DB con = DAO.display_by_id(id);
			
	
%>

	<div class="container-md mt-3 pt-3">
	<form action="editServlet" method="get">
		<table class="table table-borered" style="width: 500px">
			<tbody >
				<tr>
					<td>Enter New Name : <input type="text" name="name" value="<%=con.getName()%>">
					</td>
				</tr>
				<tr >
					<td>Enter New Email : <input type="email" name="email" value="<%=con.getEmail()%>">
					</td>
				</tr>
				<tr>
					<td>Enter New Password : <input type="password" name="pass" value="<%=con.getPassword()%>">
					</td>
				</tr>
				<tr>
					<td>Enter New USN no : <input type="text" name="usn" value="<%=con.getUSN()%>">
					</td>
				</tr>
				<tr>
					<td>Enter New Branch : <input type="text" name="branch" value="<%=con.getBranch()%>">
					</td>
				</tr>
			</tbody>
			
		</table>
		<input type="hidden"  name="id" value="<%= id%>">
		
		<button type="submit" >submit</button>

	</form>
</div>

</body>
</html>