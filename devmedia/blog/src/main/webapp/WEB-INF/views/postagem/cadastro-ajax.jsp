<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Postagem</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css" />">
</head>
<body>
	<c:import url="../menu.jsp" />
	<br>
	<c:url var="save" value="/postagem/ajax/save"/>
	<form id="save-ajax" action="${save}" method="post">
		<fieldset>
			<legend>Cadastro de Postagem</legend>
			<div class="campo">
				<label for="titulo">Título</label><br>
				<input name="titulo" type="text" required="true" />
			</div>
			<div class="campo">
				<label for="texto">Texto</label><br>
				<textarea name="texto" cols="50" rows="10" required="true" />
			</div>
			<div class="campo">
				<label for="categorias">Categorias</label><br>
				<select name="categorias" multiple>
					<c:forEach var="c" items="${categorias}">
						<option value="${c.id}">${c.descricao }</option>					
					</c:forEach>
				</select>
			</div>
			<div class="campo">
				<input type="submit" value="Salvar">
				<input type="reset" value="Limpar">
			</div>
		</fieldset>
	</form>
	<div id="info">
	</div>
</body>
</html>