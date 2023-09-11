<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp Page</title>
<%@include file="components/bootstrap.jsp"%></head>
<body>
	<%@include file="components/navbar.jsp"%>

<div class="container-md mt-3 pt-3">
	<form action="registerServlet" method="get">
		<table class="table table-borered" style="width: 400px">
			<tbody >
				<tr>
					<td>Enter Name : <input type="text" name="name">
					</td>
				</tr>
				<tr >
					<td>Enter Email : <input type="email" name="email">
					</td>
				</tr>
				<tr>
					<td>Enter Password : <input type="password" name="pass">
					</td>
				</tr>
				<tr>
					<td>Enter USN no : <input type="text" name="usn">
					</td>
				</tr>
				<tr>
					<td>Enter Branch : <input type="text" name="branch">
					</td>
				</tr>
			</tbody>
			
		</table>
		<p> <input type="submit"  class="btn btn-outline-success "> </p>

	</form>
</div>

</body>
</html>