
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<c:url value="/resources/css" var="cssPath" />

<link rel="stylesheet" href="${cssPath}/bootstrap.min.css">

<script src="resources/js/bootstrap.min.js">
	
</script>
<style type="text/css">
body {
	padding-top: 60px;
}
</style>

<title>Livros de Programação - Casa do Código</title>
</head>

<body>

	<nav class="navbar fixed-top navbar-expand-xl navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false">
					<span class="navbar-toggler-icon"></span>
				</button>
				<a class="navbar-brand" href="${s:mvcUrl('HC#index').build() }">Casa do Código</a>
			</div>

			<div class="collapse navbar-collapse" id="navbarText">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link" href="${s:mvcUrl('PC#listar').build() }">Lista de Produtos</a></li>
					<li class="nav-item"><a class="nav-link" href="${s:mvcUrl('PC#form').build() }">Cadastro de Produtos</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li class="nav-item"><a href="#"> <security:authentication property="principal" var="usuario" /> Usuário: ${usuario.username }
					</a></li>
					 <li class="nav-item">
    				 <a href="<c:url value="/logout" />">Sair</a></span>
 					</li>
				</ul>
				
			</div>
			<!-- /.navbar-collapse -->
		</div>
	</nav>


	<div class="container">
		<h1>Lista de Produtos</h1>

		<div>${sucesso}</div>
		<div>${falha}</div>

		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Título</th>
				<th>Descrição</th>
				<th>Páginas</th>
			</tr>

			<c:forEach items="${produtos}" var="produto">
				<tr>
					<td><a href="${s:mvcUrl('PC#detalhe').arg(0,produto.id).build()}"> ${produto.titulo} </a></td>
					<td>${produto.descricao}</td>
					<td>${produto.paginas}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>

</html>