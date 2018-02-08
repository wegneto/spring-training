<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Usuário</title>
</head>
<body>
	<div class="container">
		<h1>Cadastro de Usuários</h1>
		<hr>
		<div>
			<spring:url value="/user/" var="home" />
			<a class="btn btn-default" href="${home}">Home</a>
		</div>
		<hr>
		<div>
			<spring:url value="${usuario.id == null ? '/user/save' : '/user/update' }" var="save" />
			<form:form modelAttribute="usuario" action="${save }" method="post">
				<form:hidden path="id" />
				<div class="form-group">
					<label for="name">Nome: </label>
					<form:input path="name" class="form-control" />
				</div>
				<div class="form-group">
					<label for="surname">Sobrenome: </label>
					<form:input path="surname" class="form-control" />
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Confirmar</button>
				</div>
			</form:form>
		</div>
		<hr>
		<footer class="footer">
			<p>&copy; 2018 wegneto</p>
		</footer>
	</div>
</body>
</html>