package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Categoria;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import br.com.casadocodigo.loja.validation.ProdutoValidation;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoDAO produtoDao;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProdutoValidation());
	}

	// o ModelAndView, além de carregar a página, permite enviar objetos para a
	// view:

	@RequestMapping("/form")
	public ModelAndView form(Produto produto) {
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());
		modelAndView.addObject("categorias", Categoria.values());
		return modelAndView;
	}
	
	@RequestMapping(value="/{id}/form", method=RequestMethod.GET)
	public ModelAndView update(@PathVariable Integer id, Model model) {
		Produto produto = produtoDao.find(id);
		model.addAttribute("produto", produto);
		return form(produto);
	}

	@RequestMapping(method = RequestMethod.POST, name="cadastraProduto", value="/cadastraProduto")
	public ModelAndView gravar(@Valid Produto produto, BindingResult result) {
		if (result.hasErrors()) {
			return form(produto);
		}
		produtoDao.gravar(produto);
		return new ModelAndView("redirect:/produtos");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		List<Produto> produtos = produtoDao.listar();
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject("produtos", produtos);

		return modelAndView;
	}

	@RequestMapping("/detalhe/{id}")
	public ModelAndView detalhe(@PathVariable("id") Integer id) {

		ModelAndView modelAndView = new ModelAndView("produtos/detalhe");
		Produto produto = produtoDao.find(id);
		modelAndView.addObject("produto", produto);

		return modelAndView;
	}
	
	@RequestMapping(value="/deletar", method=RequestMethod.POST)
	public ModelAndView deletar (Integer id) {
	    produtoDao.deletar(id);
	    return new ModelAndView("redirect:/produtos");
	}

}
