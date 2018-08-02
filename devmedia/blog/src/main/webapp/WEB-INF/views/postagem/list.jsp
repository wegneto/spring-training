<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Postagens</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css" />">
<script type="text/javascript" src="<c:url value="/js/jquery-2.1.4.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/postagem.js" />"></script>
</head>

<body>
	<c:import url="../menu.jsp" />
	<br>
	<fieldset>
		<legend>Lista de Postagens</legend>
		<div>
			<input id="search" type="search" placeholder="Busca por título" value="">
		</div>
		<table class="table">
			<tr>
				<th>Código</th>
				<th>Título</th>
				<th>Permalink</th>
				<th>Data de Postagem</th>
				<th>Autor</th>
				<th>Categorias</th>
				<th>Ação</th>
			</tr>
			<tbody id="tbody">
				<jsp:include page="table-rows.jsp"></jsp:include>
			</tbody>
		</table>
		<div align="center">
			<c:forEach var="p" begin="1" end="${page.totalPages}">
				<c:choose>
					<c:when test="${(p-1) eq page.number }">
						<button id="button_${p}" disabled="disabled" value="${p}">${p}</button>
					</c:when>
					<c:otherwise>
						<button id="button_${p}" value="${p}">${p}</button>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
		
		<div id="info"></div>
		
	</fieldset>
</body>
</html>