<%@page import="Entity_and_DB.Con_DB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>
<%@include file="components/bootstrap.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
	<%@include file="components/navbar.jsp"%>

	<%
	Con_DB con = (Con_DB) session.getAttribute("object");
	%>
	
	<c:if test="${not empty success }">
	   <h3 class="text-center"> <i>${success } </i> </h3>
		<c:remove var="success"/>
	</c:if>
	
	<c:if test="${not empty fail }">
		<p>${fail }</p>
		<c:remove var="fail"/>
	</c:if>
	
	<div class="container-md text-center pt-5">
		<div class="row">
			<div class="col-md-8 offset-md-4">
				<div class=" table table-bordered table-hover table-striped table-info">

					<table >
						<thead>
							<tr>
								<th>Sl_no</th>
								<th>Name</th>
								<th>Email</th>
								<th>Password</th>
								<th>USN</th>
								<th>Branch</th>
								<th>Edit</th>
							</tr>
						</thead>

						<tbody>
							<tr>

								<td><%=con.getId()%></td>
								<td> <%= con.getName() %></td>
								<td><%=con.getEmail()%></td>
								<td><%=con.getPassword()%></td>
								<td><%=con.getUSN()%></td>
								<td><%=con.getBranch()%></td>
								<td><a href="editpage.jsp?id=<%=con.getId()%>">Edit</a></td>

							</tr>
						</tbody>
					</table>

				</div>
			</div>
		</div>


	</div>

</body>
</html>