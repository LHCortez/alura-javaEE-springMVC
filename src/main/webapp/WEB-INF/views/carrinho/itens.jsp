<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- view do carrinho -->

<c:set var="context" value="${pageContext.request.contextPath}" />

<tags:pageTemplate titulo="Seu carrinho de compras">

	<jsp:attribute name="extraScripts">
		<script>
			console.log("Finalização de compra de ${carrinhoCompras.quantidade} itens");
		</script>
	</jsp:attribute>

	<jsp:body>

		<section class="container middle">
			<h2 id="cart-title"><fmt:message key="carrinho.titulo"/></h2>
			<table id="cart-table">
				<colgroup>
					<col class="item-col" />
					<col class="item-price-col" />
					<col class="item-quantity-col" />
					<col class="line-price-col" />
					<col class="delete-col" />
				</colgroup>
				<thead>
					<tr>
						<th class="cart-img-col"></th>
						<th width="65%">Item</th>
						<th width="10%"><fmt:message key="carrinho.preco"/></th>
						<th width="10%"><fmt:message key="carrinho.quantidade"/></th>
						<th width="10%">Total</th>
						<th width="5%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${carrinhoCompras.itens }" var="item">
						<tr>
							<td class="cart-img-col"><img
									src="${item.produto.sumario}"
									width="71px" height="100px" /></td>
							<td class="item-title">${item.produto.titulo }<br/>(${item.tipoPreco})</td>
							<td class="numeric-cell">${item.preco }</td>
							<td class="numeric-cell">${carrinhoCompras.getQuantidade(item) }</td>
							<td class="numeric-cell">${carrinhoCompras.getTotal(item) }</td>
							<td class="remove-item">
								<form:form
									action="${s:mvcUrl('CCC#remover').arg(0, item.produto.id).arg(1,item.tipoPreco).build() }"
									method="POST">
									<input type="image" src="${context }/resources/imagens/excluir.png"
										alt="Excluir" title="Excluir" />
								</form:form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4">
						<form:form servletRelativeAction="/pagamento/finalizar" method="post">
							<input type="submit" class="checkout" name="checkout"
									id="checkout" value="<fmt:message key="carrinho.finalizar"/>" />
						</form:form>
						</td>
						<td class="numeric-cell">${carrinhoCompras.total }</td>
						<td></td>
					</tr>
				</tfoot>
			</table>

			<h2><fmt:message key="carrinho.lancamentos"/></h2>
			<ul id="collection" class="related-books">
			<c:forEach items="${lancamentos}" var="lancamento">
				<li class="col-left"><a href="${s:mvcUrl('PC#detalhe').arg(0, lancamento.id).build()} " class="block clearfix book-suggest"
						data-book="${lancamento.titulo }"> <img width="113px"
							height="160px"
							src="${lancamento.sumario}"
							alt="${lancamento.titulo }"/>
				</a></li>
				</c:forEach>
			</ul>
			<h2>
				<a href="${s:mvcUrl('HC#index').build() }"><fmt:message key="carrinho.todos"/></a>
			</h2>

		</section>

	</jsp:body>

</tags:pageTemplate>