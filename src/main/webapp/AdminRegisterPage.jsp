<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Register page</title>
<%@include file="components/bootstrap.jsp"%>

</head>
<body>

<%@ include file="components/navbar.jsp"%>


	<div class="container">
		<div class="row p-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">

						<h1 class="text-center text-success">Enter Details For Admin Registaration</h1>
						<form action="AdminRegisterServlet" method="post">

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Name
								</label> <input type="text" name="name" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp" required="required">
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email
								</label> <input type="text" name="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp" required="required">
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Password
								</label> <input type="text" name="pass" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp" required="required">
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