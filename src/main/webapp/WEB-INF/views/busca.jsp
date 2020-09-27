<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Livros de Java, Android, iOS, Mobile e muito mais...">

	<section id="index-section" class="container middle">
	
		<h1 class="cdc-call"><fmt:message key="home.chamada" /></h1>
		
		<p style="text-align: center; font-weigth: bold;"> 			
			<c:if test="${nome != null}"> <fmt:message key="buscar.livros" />: ${nome} </c:if>
		</p>
		
		<ul class="clearfix book-collection">
			<c:forEach items="${produtos }" var="produto">
				<li><a href="${s:mvcUrl('PC#detalhe').arg(0, produto.id).build() }" class="block clearfix">
						<h2 class="product-title">${produto.titulo }</h2> 
						<img width="143" height="202" src="${produto.sumario}"
							alt="${produto.titulo }" title="${produto.titulo }" /> 
						<small class="buy-button">Compre</small>
					</a></li>
			</c:forEach>
		</ul>

		<h2 class="cdc-call"><fmt:message key="home.diferenciais" /></h2>
		<ul id="cdc-diferenciais" class="clearfix">
			<li class="col-left">
				<h3><fmt:message key="home.drm" /></h3>
				<p>
					<span class="sprite" id="sprite-drm"></span> 
					<fmt:message key="home.drm.descricao" />
				</p>
			</li>
			<li class="col-right">
				<h3><fmt:message key="home.autores" /></h3>
				<p>
					<span class="sprite" id="sprite-renome"></span> 
					<fmt:message key="home.autores.descricao" />
				</p>
			</li>
			<li class="col-left">
				<h3><fmt:message key="home.atualizacoes" /></h3>
				<p>
					<span class="sprite" id="sprite-atualizacoes"></span> 
					<fmt:message key="home.atualizacoes.descricao" />
				</p>
			</li>
			<li class="col-right">
				<h3><fmt:message key="home.curadoria" /></h3>
				<p>
					<span class="sprite" id="sprite-caelum"></span> 
					<fmt:message key="home.curadoria.descricao" />
				</p>
			</li>
		</ul>
		
	</section>

</tags:pageTemplate>