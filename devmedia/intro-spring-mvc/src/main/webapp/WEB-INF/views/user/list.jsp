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

		<div class="panel-default">

			<div class="panel-heading">
				<span>${message == null ? '&nbsp;' : message}</span>
			</div>

			<table class="table table-striped table-condensed">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOME</th>
						<th>AÇÃO</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="usuario" items="${usuarios }">
						<tr>
							<td>${usuario.id }</td>
							<td>${usuario.name }&nbsp;${usuario.surname }</td>
							<td><spring:url value="/user/edit/${usuario.id }" var="edit" />
								<a class="btn btn-info" href="${edit }">Editar</a> <spring:url
									value="/user/remove/${usuario.id }" var="remove" /> <a
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