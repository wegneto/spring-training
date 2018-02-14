<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Lista de Usuários</title>
	<spring:url var="css" value="/static/css/bootstrap.css" />
	<link type="text/css" rel="stylesheet" href="${css}">
</head>
<body>
	<div class="container">
		<h1>Lista de Usuários</h1>
		<hr>
		<div>
			<spring:url value="/user/create" var="create" />
			<a class="btn btn-default" href="${create}">Novo Usuário</a>
		</div>
		<hr>

		<div class="${message == null ? 'panel-default' : 'panel-success'}">

			<div class="panel-heading">
				<span>${message == null ? '&nbsp;' : message}</span>
			</div>

			<table class="table table-striped table-condensed">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOME</th>
						<th>DATA DE NASCIMENTO</th>
						<th>GÊNERO</th>
						<th>AÇÃO</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${users }">
						<tr>
							<td>${user.id }</td>
							<td>${user.name }&nbsp;${user.surname }</td>
							<td><f:parseDate var="date" value="${user.birthday}"
									pattern="yyyy-MM-dd" type="date" /> <f:formatDate
									value="${date}" pattern="dd/MM/yyyy" type="date" /></td>
							<td>${user.gender.description }</td>
							<td><spring:url value="/user/edit/${user.id }" var="edit" />
								<a class="btn btn-info" href="${edit }">Editar</a> <spring:url
									value="/user/remove/${user.id }" var="remove" /> <a
								class="btn btn-danger" href="${remove}">Excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<hr>
		<footer class="footer">
			<p>&copy; wegneto</p>
		</footer>
	</div>
</body>
</html>