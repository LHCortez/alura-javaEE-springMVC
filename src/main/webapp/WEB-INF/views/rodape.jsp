<footer id="layout-footer">
    <div class="clearfix container">
        <nav class="breadcrumbs" itemprop="breadcrumb"
            xmlns:v="http://rdf.data-vocabulary.org/#"> 
        </nav>
        <div id="collections-footer">
            <p class="footer-title"><fmt:message key="rodape.colecoes"/></p>
            <ul class="footer-text-links">
                <li>
                    <a href="${s:mvcUrl('HC#buscarPorCategoria').arg(0, 'java').build() }">
                        <fmt:message key="navegacao.categoria.java" />
                    </a>
                </li>
                <li>
                    <a href="${s:mvcUrl('HC#buscarPorCategoria').arg(0, 'mobile').build() }">
                        <fmt:message key="navegacao.categoria.mobile" />
                    </a>
                </li>
                <li>
                    <a href="${s:mvcUrl('HC#buscarPorCategoria').arg(0, 'games').build() }">
                        <fmt:message key="navegacao.categoria.games" />
                    </a>
                </li>
                <li>
                    <a href="${s:mvcUrl('HC#buscarPorCategoria').arg(0, 'frontend').build() }">
                        <fmt:message key="navegacao.categoria.front_end" />
                    </a>
                </li>
            </ul>
            <p class="footer-title"><fmt:message key="rodape.outros"/></p>
            <ul class="footer-text-links">
                <li>
                    <a href="${s:mvcUrl('HC#buscarPorCategoria').arg(0, 'agile').build() }">
                        <fmt:message key="navegacao.categoria.agile" />
                    </a>
                </li>
                <li>
                    <a href="${s:mvcUrl('HC#buscarPorCategoria').arg(0, 'outros').build() }">
                        <fmt:message key="navegacao.categoria.outros" />
                    </a>
                </li>
            </ul>
        </div>
        <div id="social-footer">
            <p class="footer-title"><fmt:message key="rodape.links.casadocodigo"/></p>
            <ul class="footer-text-links">
                <li>
                    <a href="https://www.casadocodigo.com.br/" target="_blank" rel="nofollow">
                       <fmt:message key="rodape.links.verdade"/>
                    </a>
                </li>
                <li>
                    <a href="https://www.caelum.com.br" target="_blank" rel="nofollow">
                        Caelum 
                    </a>
                </li>
                <li>
                    <a href="http://www.alura.com.br" 
                            rel="nofollow"  target="_blank">
                        Alura
                    </a>
                </li>
            </ul>
             <p class="footer-title"><fmt:message key="rodape.links.luiz"/></p>
            <ul class="footer-text-links">
                <li>
                    <a href="https://lhcortez.github.io/portfolio/" target="_blank" rel="nofollow">
                       Portfolio
                    </a>
                </li>
                <li>
                    <a href="https://github.com/LHCortez" target="_blank" rel="nofollow">
                        GitHub
                    </a>
                </li>
                <li>
                    <a href="https://www.linkedin.com/in/luizhcortez/" 
                            rel="nofollow"  target="_blank">
                        LinkedIn
                    </a>
                </li>
            </ul>
        </div>
        <div id="newsletter-footer">

            <ul class="footer-payments">
                <li>
                    <img class="accepts-paypal" src="${context }/resources/imagens/paypal.png" border="0" alt="Paypal"/>
                </li>
                <li>
                    <img class="accepts-pagseguro" src="${context }/resources/imagens/pagseguro.png" border="0" alt="PagSeguro"/>
                </li>
            </ul>
        </div>
    </div>
</footer>