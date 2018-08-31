<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fieldset sytle="font-family: monospace; font-size: 10pt;">
	<legend>Menu</legend>
	<nav>
		<a href="<c:url value="/"/>">Home</a>
	</nav>
	<nav>
		<security:authorize access="hasAnyAuthority('ADMIN', 'AUTOR', 'LEITOR')">
			<a href="<c:url value="/usuario/perfil/${logado.id }"/>">Perfil do Usuário</a>
		</security:authorize>
		<security:authorize access="hasAuthority('ADMIN')">
			<a href="<c:url value="/usuario/list"/>">Listar Usuários</a>
		</security:authorize>
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
		<security:authorize access="hasAnyAuthority('ADMIN', 'AUTOR')">
			<a href="<c:url value="/categoria/add"/>">Adicionar Categoria</a>
		</security:authorize>
	</nav>
	<nav>
		<a href="<c:url value="/mock/add"/>">Adicionar Mocks</a>
	</nav>
	<nav class="login">
		<c:if test="${logado == null }">
			<a href="<c:url value="/auth/form"/>">Entrar</a>
			<a href="<c:url value="/usuario/add"/>">Cadastrar-se</a>
		</c:if>
		<security:authorize access="hasAnyAuthority('ADMIN', 'AUTOR', 'LEITOR')">
			<form action="<c:url value="/logout"/>" method="post">
				<security:csrfInput/>
				<button type="submit">Sair</button>
			</form>
		</security:authorize>
	</nav>
</fieldset>