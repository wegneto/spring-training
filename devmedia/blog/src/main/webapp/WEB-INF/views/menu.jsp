<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fieldset sytle="font-family: monospace; font-size: 10pt;">
	<legend>Menu</legend>
	<nav>
		<a href="<c:url value="/"/>">Home</a>
	</nav>
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
		<a href="<c:url value="/postagem/ajax/add"/>">Adicionar Postagem (Ajax)</a>
		<a href="<c:url value="/postagem/list"/>">Listar Postagens</a>
	</nav>
	<nav>
		<a href="<c:url value="/categoria/add"/>">Adicionar Categoria</a>
	</nav>
	<nav>
		<a href="<c:url value="/mock/add"/>">Adicionar Mocks</a>
	</nav>
	<nav>
		<a href="<c:url value="/auth/form"/>">Entrar</a>
		<a href="">Cadastrar-se</a>
		<form action="<c:url value="/logout"/>" method="post">
			<security:csrfInput/>
			<button type="submit">Sair</button>
		</form>
	</nav>
</fieldset>