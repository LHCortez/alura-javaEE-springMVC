package br.com.casadocodigo.loja.controllers;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.daos.UsuarioDAO;
import br.com.casadocodigo.loja.models.Categoria;
import br.com.casadocodigo.loja.models.Preco;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.TipoPreco;
import br.com.casadocodigo.loja.models.Usuario;

@Controller
public class HomeController {

	@Autowired
	private ProdutoDAO produtoDao;
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@RequestMapping("/")
	@Cacheable(value="produtosHome")
	public ModelAndView index() {
		List<Produto> produtos = produtoDao.listar();
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("produtos", produtos);
		return modelAndView;
	}
	
	@RequestMapping(value="/buscar/{categoriaString}", method=RequestMethod.GET)
	public ModelAndView buscarPorCategoria(@PathVariable String categoriaString) {
	    
	    	Categoria categoriaEnum = Categoria.valueOf(categoriaString.toUpperCase());
		List<Produto> produtos = produtoDao.buscaPelaCategoria(categoriaEnum);	
		ModelAndView modelAndView = new ModelAndView("busca");
		modelAndView.addObject("produtos", produtos);
		modelAndView.addObject("nome", categoriaString.substring(0, 1).toUpperCase() + categoriaString.substring(1));
		return modelAndView;
	}
	
	@Transactional
	@ResponseBody
	@RequestMapping("/url-magica-maluca-oajksfbvad6584i57j54f9684nvi658efnoewfmnvowefnoeijn")
	public String urlMagicaMaluca() throws ParseException {
	    Usuario usuario = new Usuario(); 
	    usuario.setNome("Admin");
	    usuario.setEmail("admin@casadocodigo.com.br");
	    usuario.setSenha("$2a$10$lt7pS7Kxxe5JfP.vjLNSyOXP11eHgh7RoPxo5fvvbMCZkCUss2DGu");
	    usuario.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));
	    usuarioDao.gravar(usuario);
	    
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    
	    Produto produto = new Produto();
	    produto.setTitulo("Datas e horas");
	    produto.setDescricao("Conceitos fundamentais e as APIs do Java");
	    produto.setPaginas(130);
	    cal.setTime(sdf.parse("01/01/2020"));
	    produto.setDataLancamento(cal);
	    List<Preco> precos = new ArrayList<Preco>(); 
	    precos.add(new Preco(new BigDecimal(40), TipoPreco.EBOOK));
	    precos.add(new Preco(new BigDecimal(30), TipoPreco.IMPRESSO));
	    precos.add(new Preco(new BigDecimal(50), TipoPreco.COMBO));
	    produto.setPrecos(precos);
	    produto.setSumario("https://cdn.shopify.com/s/files/1/0155/7645/products/p_1fe74e94-82e9-413f-9d3d-c2d473da9861_large.jpg?v=1553198246");
	    produto.setCategoria(Categoria.JAVA);
	    produtoDao.gravar(produto);
	    
	    Produto produto2 = new Produto();
	    produto2.setTitulo("Spock Framework");
	    produto2.setDescricao("Testes automatizados para Java, Android e REST");
	    produto2.setPaginas(90);
	    cal.setTime(sdf.parse("01/01/2019"));
	    produto2.setDataLancamento(cal);
	    List<Preco> precos2 = new ArrayList<Preco>(); 
	    precos2.add(new Preco(new BigDecimal(20), TipoPreco.EBOOK));
	    precos2.add(new Preco(new BigDecimal(35), TipoPreco.IMPRESSO));
	    precos2.add(new Preco(new BigDecimal(50), TipoPreco.COMBO));
	    produto2.setPrecos(precos2);
	    produto2.setSumario("https://cdn.shopify.com/s/files/1/0155/7645/products/p_8dc5d79c-7651-4ce9-876e-c8875e75470a_large.jpg?v=1565991315");
	    produto2.setCategoria(Categoria.JAVA);
	    produtoDao.gravar(produto2);
	    
	    Produto produto3 = new Produto();
	    produto3.setTitulo("Agile");
	    produto3.setDescricao("Desenvolvimento de software com entregas frequentes e foco no valor de negócio");
	    produto3.setPaginas(180);
	    cal.setTime(sdf.parse("01/05/2019"));
	    produto3.setDataLancamento(cal);
	    List<Preco> precos3 = new ArrayList<Preco>(); 
	    precos3.add(new Preco(new BigDecimal(50), TipoPreco.EBOOK));
	    precos3.add(new Preco(new BigDecimal(55), TipoPreco.IMPRESSO));
	    precos3.add(new Preco(new BigDecimal(60), TipoPreco.COMBO));
	    produto3.setPrecos(precos3);
	    produto3.setSumario("https://cdn.shopify.com/s/files/1/0155/7645/products/agile-featured_large.png?v=1411485880");
	    produto3.setCategoria(Categoria.AGILE);
	    produtoDao.gravar(produto3);
	    
	    Produto produto4 = new Produto();
	    produto4.setTitulo("Scrum");
	    produto4.setDescricao("Gestão ágil para projetos de sucesso");
	    produto4.setPaginas(132);
	    cal.setTime(sdf.parse("01/05/2017"));
	    produto4.setDataLancamento(cal);
	    List<Preco> precos4 = new ArrayList<Preco>(); 
	    precos4.add(new Preco(new BigDecimal(100), TipoPreco.EBOOK));
	    precos4.add(new Preco(new BigDecimal(120), TipoPreco.IMPRESSO));
	    precos4.add(new Preco(new BigDecimal(130), TipoPreco.COMBO));
	    produto4.setPrecos(precos4);
	    produto4.setSumario("https://cdn.shopify.com/s/files/1/0155/7645/products/cover_large.jpeg?v=1465238631");
	    produto4.setCategoria(Categoria.AGILE);
	    produtoDao.gravar(produto4);
	    
	    Produto produto5 = new Produto();
	    produto5.setTitulo("Front-end com Vue.js");
	    produto5.setDescricao("Da teoria à prática sem complicações");
	    produto5.setPaginas(250);
	    cal.setTime(sdf.parse("01/09/2020"));
	    produto5.setDataLancamento(cal);
	    List<Preco> precos5 = new ArrayList<Preco>(); 
	    precos5.add(new Preco(new BigDecimal(100), TipoPreco.EBOOK));
	    precos5.add(new Preco(new BigDecimal(120), TipoPreco.IMPRESSO));
	    precos5.add(new Preco(new BigDecimal(130), TipoPreco.COMBO));
	    produto5.setPrecos(precos5);
	    produto5.setSumario("https://cdn.shopify.com/s/files/1/0155/7645/products/Amazon-Front-end-com-Vue-js_large.jpg?v=1511489591");
	    produto5.setCategoria(Categoria.FRONTEND);
	    produtoDao.gravar(produto5);
	    
	    Produto produto6 = new Produto();
	    produto6.setTitulo("Coletânea Front-end");
	    produto6.setDescricao("Uma antologia da comunidade front-end brasileira");
	    produto6.setPaginas(193);
	    cal.setTime(sdf.parse("22/04/2020"));
	    produto6.setDataLancamento(cal);
	    List<Preco> precos6 = new ArrayList<Preco>(); 
	    precos6.add(new Preco(new BigDecimal(10), TipoPreco.EBOOK));
	    precos6.add(new Preco(new BigDecimal(30), TipoPreco.IMPRESSO));
	    precos6.add(new Preco(new BigDecimal(40), TipoPreco.COMBO));
	    produto6.setPrecos(precos6);
	    produto6.setSumario("https://cdn.shopify.com/s/files/1/0155/7645/products/coletanea-front-end-featured_large.png?v=1411487157");
	    produto6.setCategoria(Categoria.FRONTEND);
	    produtoDao.gravar(produto6);
	    
	    Produto produto7 = new Produto();
	    produto7.setTitulo("Jogos 2D com Stencyl");
	    produto7.setDescricao("Crie jogos completos sem códigos de programação");
	    produto7.setPaginas(72);
	    cal.setTime(sdf.parse("13/02/2020"));
	    produto7.setDataLancamento(cal);
	    List<Preco> precos7 = new ArrayList<Preco>(); 
	    precos7.add(new Preco(new BigDecimal(22), TipoPreco.EBOOK));
	    precos7.add(new Preco(new BigDecimal(40), TipoPreco.IMPRESSO));
	    precos7.add(new Preco(new BigDecimal(90), TipoPreco.COMBO));
	    produto7.setPrecos(precos7);
	    produto7.setSumario("https://cdn.shopify.com/s/files/1/0155/7645/products/p_e3935e38-118f-406e-abdf-395acfcac7c1_large.jpg?v=1577997570");
	    produto7.setCategoria(Categoria.GAMES);
	    produtoDao.gravar(produto7);
	    
	    Produto produto8 = new Produto();
	    produto8.setTitulo("Lean Game Development");
	    produto8.setDescricao("Desenvolvimento enxuto de jogos");
	    produto8.setPaginas(300);
	    cal.setTime(sdf.parse("22/02/2020"));
	    produto8.setDataLancamento(cal);
	    List<Preco> precos8 = new ArrayList<Preco>(); 
	    precos8.add(new Preco(new BigDecimal(20), TipoPreco.EBOOK));
	    precos8.add(new Preco(new BigDecimal(30), TipoPreco.IMPRESSO));
	    precos8.add(new Preco(new BigDecimal(35), TipoPreco.COMBO));
	    produto8.setPrecos(precos8);
	    produto8.setSumario("https://cdn.shopify.com/s/files/1/0155/7645/products/AMlqJB2HHf2DrJmOv7CcDavslB_Bn28__SmqTx0Ry9I_large.jpg?v=1492115019");
	    produto8.setCategoria(Categoria.GAMES);
	    produtoDao.gravar(produto8);
	    
	    Produto produto9 = new Produto();
	    produto9.setTitulo("Kotlin com Android");
	    produto9.setDescricao("Crie aplicativos de maneira fácil e divertida");
	    produto9.setPaginas(222);
	    cal.setTime(sdf.parse("02/05/2017"));
	    produto9.setDataLancamento(cal);
	    List<Preco> precos9 = new ArrayList<Preco>(); 
	    precos9.add(new Preco(new BigDecimal(50), TipoPreco.EBOOK));
	    precos9.add(new Preco(new BigDecimal(55), TipoPreco.IMPRESSO));
	    precos9.add(new Preco(new BigDecimal(70), TipoPreco.COMBO));
	    produto9.setPrecos(precos9);
	    produto9.setSumario("https://cdn.shopify.com/s/files/1/0155/7645/products/p_4d784e4f-769e-4f00-82d9-c1c81628055a_large.jpg?v=1532117965");
	    produto9.setCategoria(Categoria.MOBILE);
	    produtoDao.gravar(produto9);
	    
	    Produto produto10 = new Produto();
	    produto10.setTitulo("Android");
	    produto10.setDescricao("Como automatizar a distribuição de apps");
	    produto10.setPaginas(230);
	    cal.setTime(sdf.parse("03/04/2019"));
	    produto10.setDataLancamento(cal);
	    List<Preco> precos10 = new ArrayList<Preco>(); 
	    precos10.add(new Preco(new BigDecimal(20), TipoPreco.EBOOK));
	    precos10.add(new Preco(new BigDecimal(30), TipoPreco.IMPRESSO));
	    precos10.add(new Preco(new BigDecimal(35), TipoPreco.COMBO));
	    produto10.setPrecos(precos10);
	    produto10.setSumario("https://cdn.shopify.com/s/files/1/0155/7645/products/33JmvoJMSmMmf2E7Qns5gMEO7R7PjA1GmyHAQP4RFj0_large.jpg?v=1475188090");
	    produto10.setCategoria(Categoria.MOBILE);
	    produtoDao.gravar(produto10);
	    
	    Produto produto11 = new Produto();
	    produto11.setTitulo("Flutter Framework");
	    produto11.setDescricao("Desenvolva aplicações móveis no Dart Side!");
	    produto11.setPaginas(240);
	    cal.setTime(sdf.parse("02/10/2018"));
	    produto11.setDataLancamento(cal);
	    List<Preco> precos11 = new ArrayList<Preco>(); 
	    precos11.add(new Preco(new BigDecimal(23), TipoPreco.EBOOK));
	    precos11.add(new Preco(new BigDecimal(32), TipoPreco.IMPRESSO));
	    precos11.add(new Preco(new BigDecimal(45), TipoPreco.COMBO));
	    produto11.setPrecos(precos11);
	    produto11.setSumario("https://cdn.shopify.com/s/files/1/0155/7645/products/Amazon-Flutter_large.jpg?v=1595010670");
	    produto11.setCategoria(Categoria.OUTROS);
	    produtoDao.gravar(produto11);
	    
	    Produto produto12 = new Produto();
	    produto12.setTitulo("Trilhas Python");
	    produto12.setDescricao("Programação multiparadigma e desenvolvimento Web com Flask");
	    produto12.setPaginas(250);
	    cal.setTime(sdf.parse("02/09/2020"));
	    produto12.setDataLancamento(cal);
	    List<Preco> precos12 = new ArrayList<Preco>(); 
	    precos12.add(new Preco(new BigDecimal(20), TipoPreco.EBOOK));
	    precos12.add(new Preco(new BigDecimal(30), TipoPreco.IMPRESSO));
	    precos12.add(new Preco(new BigDecimal(35), TipoPreco.COMBO));
	    produto12.setPrecos(precos12);
	    produto12.setSumario("https://cdn.shopify.com/s/files/1/0155/7645/products/psAMwwTIQZZygm3u5NRBJg6olDKQERUGv7qX9EcPe78_large.jpg?v=1529696678");
	    produto12.setCategoria(Categoria.OUTROS);
	    produtoDao.gravar(produto12);
	    
	    Produto produto13 = new Produto();
	    produto13.setTitulo("Java 9");
	    produto13.setDescricao("Interativo, reativo e modularizado");
	    produto13.setPaginas(250);
	    cal.setTime(sdf.parse("08/09/2020"));
	    produto13.setDataLancamento(cal);
	    List<Preco> precos13 = new ArrayList<Preco>(); 
	    precos13.add(new Preco(new BigDecimal(33), TipoPreco.EBOOK));
	    precos13.add(new Preco(new BigDecimal(42), TipoPreco.IMPRESSO));
	    precos13.add(new Preco(new BigDecimal(50), TipoPreco.COMBO));
	    produto13.setPrecos(precos13);
	    produto13.setSumario("https://cdn.shopify.com/s/files/1/0155/7645/products/Amazon-Java-9_large.png?v=1506020938");
	    produto13.setCategoria(Categoria.JAVA);
	    produtoDao.gravar(produto13);
	    
	    Produto produto14 = new Produto();
	    produto14.setTitulo("Spring Boot");
	    produto14.setDescricao("Acelere o desenvolvimento de microsserviços");
	    produto14.setPaginas(220);
	    cal.setTime(sdf.parse("05/09/2020"));
	    produto14.setDataLancamento(cal);
	    List<Preco> precos14 = new ArrayList<Preco>(); 
	    precos14.add(new Preco(new BigDecimal(33), TipoPreco.EBOOK));
	    precos14.add(new Preco(new BigDecimal(42), TipoPreco.IMPRESSO));
	    precos14.add(new Preco(new BigDecimal(50), TipoPreco.COMBO));
	    produto14.setPrecos(precos14);
	    produto14.setSumario("https://cdn.shopify.com/s/files/1/0155/7645/products/7aXPAWM4TObeQ4OOv3mUY-mrVzqf23Ty6enIslrhXvM_large.jpg?v=1501874081");
	    produto14.setCategoria(Categoria.JAVA);
	    produtoDao.gravar(produto14);
	    	
	    return "Url Mágica executada";
	}
}
