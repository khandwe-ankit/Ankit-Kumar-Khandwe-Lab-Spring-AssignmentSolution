<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Access denied</title>
</head>
<body>
<div class = "m-3">
<a  href="/studentManagement/students/list">Back to Student Records</a>
</div>

<div class= "d-flex justify-content-center mt-5">
	<h1>HTTP Status 403 - Access denied</h1>
	</div>
	<h2 class="mt-5 mx-3">${msg}</h2>
	
	<hr>
		
	
</body>
</html>