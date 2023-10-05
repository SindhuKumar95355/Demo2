<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD Page</title>
<%@include file="components/bootstrap.jsp"%>
</head>
<body>
	<%@ include file="components/navbar.jsp"%>
	
	
	<div class="container">
		<div class="row p-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">

						<h1 class="text-center text-success">Enter Details</h1>
						<form action="AddServlet" method="post">

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Name
								</label> <input type="text" name="name" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Role
								</label> <input type="text" name="role" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">City
								</label> <input type="text" name="city" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="inputState" class="form-label"> work Status</label>
								<select id="inputState" class="form-select" name="status">
									<option selected>---select---</option>
									<option value="pending">pending</option>
									<option value="completed">Completed</option>
								</select>
							</div>
							
							<div class="text-center">
								<button type="submit" class="btn btn-primary m-3">ADD</button>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>




</body>
</html>