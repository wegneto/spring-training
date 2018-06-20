<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Postagens</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css" />" >
</head>

<body>
	<c:import url="../menu.jsp" />
	<br>
	<fieldset>
		<legend>Lista de Postagens</legend>
		<table class="table">
			<tr>
				<th>Código</th>
				<th>Título</th>
				<th>Permalink</th>
				<th>Data de Postagem</th>
				<th>Autor</th>
				<th>Ação</th>
			</tr>
			<c:forEach var="postagem" items="${postagens}" varStatus="i">
				<tr bgcolor='${i.count % 2 != 0 ? '#f1f1f1' : 'white'}'>
					<td>
						${postagem.id}
					</td>
					<td>${postagem.titulo}</td>
					<td>${postagem.permalink}</td>
					<td>${postagem.dataPostagem}</td>
					<td>${postagem.autor.nome}</td>
					<td>
						<c:url var="update" value="/postagem/update/${postagem.id}" />
						<a href="${update}" title="Editar">&#9445</a>
						<a href="#" title="Excluir">&#9447</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
</body>
</html>