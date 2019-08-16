<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<title>Trunk is the best</title>
</head>
<body>
	<form style="float: right" method="POST" action="index">
		<input name="logout" type="submit" class="btn btn-link"
			value="log out">
	</form>
	<div class="jumbotron" style="background-color: #FFFFFF">
		<c:forEach var="item" items="${postList}">
			<div class="card w-75">
				<div class="card-body">
					<h5 class="card-title">${item.postTitle}</h5>
					<p class="card-text">${item.postContent}...</p>
					<form style="float: left" method="POST" action="post">
						<input type="submit" class="btn btn-outline-primary"
							value="Detail"> <input type="hidden" name="postId"
							value="${item.postId}">
					</form>
					<form style="float: right" method="POST" action="deletePost">
						<input type="submit" class="btn btn-outline-danger" value="Delete">
						<input type="hidden" name="postId" value="${item.postId}">
					</form>
				</div>
			</div>
		</c:forEach>
		<form style="float: center" method="POST" action="addPost">
			<input type="submit" name="add" class="btn btn-outline-success"
				value="add">
		</form>
	</div>
</body>
</html>