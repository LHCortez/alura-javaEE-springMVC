package br.com.casadocodigo.loja.conf;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//classe de configurações do servlet

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SecurityConfiguration.class, AppWebConfiguration.class, JPAConfiguration.class};
	}

	// configuração que define o controller
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {};
	}

	// servlet mapeará as requisições a partir da raiz do nosso projeto (/)
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	// define qual é o encoding da aplicação, através de um filtro:
	@Override
	protected Filter[] getServletFilters() {
	    CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
	    encodingFilter.setEncoding("UTF-8");

	    return new Filter[] {encodingFilter, new OpenEntityManagerInViewFilter()};
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement(""));
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	    super.onStartup(servletContext);
	    servletContext.addListener(RequestContextListener.class);
	    servletContext.setInitParameter("spring.profiles.active", "dev");
	}
	
}
