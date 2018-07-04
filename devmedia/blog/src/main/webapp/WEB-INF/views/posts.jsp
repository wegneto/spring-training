<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/css/style.css" />">
</head>
<body>
	<fieldset class="header">
		<h1>Blog do Curso de Spring-Data JPA</h1>
	</fieldset>

	<c:import url="menu.jsp" />
	<br>

	<fieldset>
		<c:forEach var="p" items="${postagens}">
			<div>
				<div>
					<h2>${p.titulo}</h2>
					<p>
						Autor: <a href="<c:url value="/autor/${p.autor.nome }" />"
							title="${p.autor.nome }">${p.autor.nome }</a> | Data:
						<fmt:parseDate var="date" value="${p.dataPostagem}" pattern="yyyy-MM-dd'T'HH:mm:ss" />
						<fmt:formatDate value="${date}" type="both" />
					</p>
				</div>
				<div>
					<p>
						<c:forTokens var="resumo" items="${p.texto}" delims=" " begin="0"
							end="60">
							${resumo }
						</c:forTokens>
						...
					</p>
				</div>
				<div>
					<p>
						<c:forEach var="c" items="${p.categorias}">
							<a href="<c:url value="/categoria/${c.permalink}" />"
								title="${c.descricao}">| ${c.descricao}</a>
						</c:forEach>
					</p>
				</div>
			</div>
		</c:forEach>
	</fieldset>
</body>
</html>