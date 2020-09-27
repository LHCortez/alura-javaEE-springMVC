<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<!-- view do de detalhe do produto -->

<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="${produto.titulo }">

	<article id="livro-css-eficiente">
		<header id="product-highlight" class="clearfix">
			<div id="product-overview" class="container">
				<img width="280px" height="395px"
					src="${produto.sumario}"
					class="product-featured-image" />
				<h1 class="product-title">${produto.titulo }</h1>
				<p class="product-author">
					<span class="product-author-link"> </span>
				</p>
				<p class="book-description">${produto.descricao }</p>
			</div>
		</header>

		<section class="buy-options clearfix">
			<form:form action='${contextPath }carrinho/add' method="post" cssClass="container">
				<input type="hidden" value="${produto.id }" name="produtoId">
				<ul id="variants" class="clearfix">
					<c:forEach items="${produto.precos }" var="preco">
						<li class="buy-option">
							<input type="radio" name="tipoPreco" class="variant-radio" id="tipoPreco"
								value="${preco.tipo }" checked="checked" />
							<label class="variant-label">${preco.tipo }</label>							
							<small class="compare-at-price"> ${preco.valor + 10 } </small>
							<p class="variant-price">${preco.valor }</p>
						</li>
					</c:forEach> 
				</ul>
				<button type="submit" class="submit-image icon-basket-alt"
					title="Compre Agora ${produto.titulo }"></button>
			</form:form>
		</section>

		<div class="container">

			<section class="data product-detail">
				<h2 class="section-title"><fmt:message key="detalhe.dados"/></h2>
				<p>
					<fmt:message key="detalhe.paginas"/>: <span>${produto.paginas}</span>
				</p>
				<p></p>
				<p><fmt:message key="detalhe.data"/>:
					<span>
						<fmt:formatDate value="${produto.dataLancamento.time }" pattern="dd/MM/yyyy" /></span>
				</p>

			</section>
		</div>
	</article>

</tags:pageTemplate>