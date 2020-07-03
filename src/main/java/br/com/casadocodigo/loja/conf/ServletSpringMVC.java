package br.com.casadocodigo.loja.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//classe de configurações do servlet

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	
	//configuração que define o controller
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class [] {AppWebConfiguration.class};
	}

	
	//servlet mapeará as requisições a partir da raiz do nosso projeto (/)
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
