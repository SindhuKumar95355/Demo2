<%@page import="EntityANDfactory.sessionfactory"%>
<%@page import="org.hibernate.Session"%>
<%@page import="EntityANDfactory.ENT1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="components/bootstrap.jsp"%>
</head>
<body>
	<%@ include file="components/navbar.jsp"%>

<% 
	int id = Integer.parseInt( request.getParameter("ID"));
	Session s = sessionfactory.factory().openSession();
		s.beginTransaction();
		
	ENT1 en = s.load(ENT1.class, id);
	
	s.getTransaction().commit();
	
%>  

<div class="container">
		<div class="row p-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">

						<h1 class="text-center text-success">Edit the Details</h1>
						<form action="Editservlet" method="get">

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Update Name
								</label> 
								<input type="text" name="name" value="<%=en.getName() %>" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp" >
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Update Role
								</label> <input type="text" name="role" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp" value="<%= en.getRole()%>">
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label"> Update City
								</label> <input type="text" name="city" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp" value="<%= en.getCity()%>">
							</div>
							<div class="form-group">
								<label for="inputState" class="form-label">Update work Status</label>
								<select id="inputState" class="form-select" name="status">
									
									<% if(en.getWork_Status().equals("pending")){ %>
									<option value="pending">pending</option>
									<option value="completed">completed</option>
									<%} 
									else
									{%>
									<option value="completed">completed</option>
									<option value="pending">pending</option>
									<%} %>
								</select>
							</div>
								
								<input type="hidden" value="<%=en.getID()%>" name="id">

							<div class="text-center">
								<button type="submit" class="btn btn-primary m-3">Update</button>
							</div>
						</form>
			<%s.close(); 
			%>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>