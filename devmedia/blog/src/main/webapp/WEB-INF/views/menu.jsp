<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fieldset sytle="font-family: monospace; font-size: 10pt;">
	<legend>Menu</legend>
	<nav>
		<a href="<c:url value="/usuario/add"/>">Adicionar Usuário</a>
		<a href="<c:url value="/usuario/list"/>">Listar Usuários</a>
	</nav>
	<nav>
		<a href="<c:url value="/autor/add"/>">Adicionar Autor</a>
		<a href="<c:url value="/autor/list"/>">Listar Autores</a>
	</nav>
	<nav>
		<a href="<c:url value="/postagem/add"/>">Adicionar Postagem</a>
		<a href="<c:url value="/postagem/list"/>">Listar Postagens</a>
	</nav>
</fieldset>