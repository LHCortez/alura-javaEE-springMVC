package br.com.casadocodigo.loja.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.controllers.HomeController;

@EnableWebMvc
@ComponentScan(basePackageClasses = { HomeController.class })
public class AppWebConfiguration {

	
	//método responsável por indicar em qual diretório estão as views:
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		//define o local:
		resolver.setPrefix("/WEB-INF/views/");
		
		//define a extensão das views:
		resolver.setSuffix(".jsp");
		
		return resolver;
	}

}
