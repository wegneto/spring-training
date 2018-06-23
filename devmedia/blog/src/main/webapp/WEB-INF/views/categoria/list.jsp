<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Categorias</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css" />" >
</head>

<body>
	<c:import url="../menu.jsp" />
	<br>
	<fieldset>
		<legend>Lista de Categorias</legend>
		<table class="table">
			<tr>
				<th>Código</th>
				<th>Descrição</th>
				<th>Permalink</th>
				<th>Ação</th>
			</tr>
			<c:forEach var="categoria" items="${categorias}" varStatus="i">
				<tr bgcolor='${i.count % 2 != 0 ? '#f1f1f1' : 'white'}'>
					<td>
						${categoria.id}
					</td>
					<td>${categoria.descricao}</td>
					<td>${categoria.permalink}</td>
					<td>
						<c:url var="update" value="/categoria/update/${categoria.id}" />
						<a href="${update}" title="Editar">&#9445</a>
						<c:url var="delete" value="/categoria/delete/${categoria.id}" />
						<a href="${delete}" title="Excluir">&#9447</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
</body>
</html>