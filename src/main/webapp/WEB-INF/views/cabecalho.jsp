<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<title>${titulo }-Casa do Código</title>

<c:set var="context" value="${pageContext.request.contextPath}" />

<header id="layout-header">

	<div class="clearfix container">
		<a href="${s:mvcUrl('HC#index').build() }" id="logo"> </a>
		<div id="header-content">
			<nav id="main-nav">

				<ul class="clearfix">
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href="${s:mvcUrl('PC#form').build()}" rel="nofollow">
						<fmt:message key="menu.cadastro_produtos" />
						</a></li>
						<li><a href="${s:mvcUrl('PC#listar').build()}" rel="nofollow">
						<fmt:message key="menu.lista_produtos" />
						</a></li>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<li><a href="${context}/logout" rel="nofollow">Logout</a></li>
					</security:authorize>
					<security:authorize access="!isAuthenticated()">
						<li><a href="${context}/login" rel="nofollow">Login</a></li>
					</security:authorize>
					<li><a href="${context}/carrinho" rel="nofollow"> <s:message
								code="menu.carrinho" arguments="${carrinhoCompras.quantidade}" />
					</a></li>
					<li><a href="?locale=pt" rel="nofollow"> <img
							src="${context}/resources/imagens/flag_brasil.png"
							alt="Português">
					</a></li>
					<li><a href="?locale=en" rel="nofollow"> <img
							src="${context}/resources/imagens/flag_usa.png" alt="English">
					</a></li>
				</ul>
			</nav>
		</div>
	</div>
	

	
</header>

<nav class="categories-nav">
	<ul class="container">
		<li class="category"><a href="${s:mvcUrl('HC#index').build()}">
				<fmt:message key="navegacao.categoria.home" />
		</a></li>
		<li class="category"><a href="${s:mvcUrl('HC#buscarPorCategoria').arg(0, 'agile').build() }">
				<fmt:message key="navegacao.categoria.agile" />
		</a></li>
		<li class="category"><a href="${s:mvcUrl('HC#buscarPorCategoria').arg(0, 'frontend').build() }">
				<fmt:message key="navegacao.categoria.front_end" />
		</a></li>
		<li class="category"><a href="${s:mvcUrl('HC#buscarPorCategoria').arg(0, 'games').build() }">
				<fmt:message key="navegacao.categoria.games" />
		</a></li>
		<li class="category"><a href="${s:mvcUrl('HC#buscarPorCategoria').arg(0, 'java').build() }"> <fmt:message
					key="navegacao.categoria.java" />
		</a></li>
		<li class="category"><a href="${s:mvcUrl('HC#buscarPorCategoria').arg(0, 'mobile').build() }">
				<fmt:message key="navegacao.categoria.mobile" />
		</a></li>
		<li class="category"><a href="${s:mvcUrl('HC#buscarPorCategoria').arg(0, 'outros').build() }"> <fmt:message
					key="navegacao.categoria.outros" />
		</a></li>	
	</ul>


</nav>