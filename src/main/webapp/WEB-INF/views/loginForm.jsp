<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livro de Java, Android, iPhone, Ruby, PHP e muito mais -
	Casa do Código</title>
<c:url value="/resources/css" var="cssPath" />
<link rel="stylesheet" href="${cssPath}/bootstrap.min.css">
<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css">
</head>
<body>
	
	<div class="container">
		<h1>Login da Casa do Código</h1>
		<form:form servletRelativeAction="/login" method="POST">
			<div class="form-group">
				<label>E-mail</label>
				<input name="username" type="text" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Senha</label>
				<input name ="password" type="password" class="form-control" />
			</div>
			<button type="submit" class="btn btn-primary">Logar</button>
			<br/>
			<br/>
			Utilize o usuário abaixo para testar o CRUD, :). <br/><br/>
			- Email: admin@casadocodigo.com.br <br/>
			- Senha: 123456 <br/>
		</form:form>
	</div>
</body>
</html>