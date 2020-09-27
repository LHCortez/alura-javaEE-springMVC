package br.com.casadocodigo.loja.daos;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Categoria;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Repository
@Transactional
public class ProdutoDAO {

	@PersistenceContext
	private EntityManager manager;

	@CacheEvict(value = "produtosHome", allEntries = true)
	public void gravar(Produto produto) {
		// metodo que possibilitara o produto persistir:
		if (produto.getId() == null)
			manager.persist(produto);
		else
			manager.merge(produto);
	}

	public List<Produto> listar() {
		return manager.createQuery("select distinct(p) from Produto p", Produto.class).getResultList();
	}
	
	public List<Produto> buscaPelaCategoria(Categoria categoria) {	    
		return manager.createQuery("select distinct(p) from Produto p where p.categoria = :categoria",
			Produto.class).setParameter("categoria", categoria).getResultList();
	}

	public Produto find(Integer id) {
		return manager.createQuery("select distinct(p) from Produto p " + "join fetch p.precos precos where p.id = :id",
				Produto.class).setParameter("id", id).getSingleResult();
	}

	public BigDecimal somaPrecosPorTipo(TipoPreco tipoPreco) {
		TypedQuery<BigDecimal> query = manager.createQuery(
				"select sum(preco.valor) from Produto p " + "join p.precos preco where preco.tipo = :tipoPreco",
				BigDecimal.class);
		query.setParameter("tipoPreco", tipoPreco);
		return query.getSingleResult();
	}

	@CacheEvict(value = "produtosHome", allEntries = true)
	public void deletar(Integer id) {
	    Produto produto = find(id);
	    manager.remove(produto);	    
	}
	
	public List<Produto> buscaLancamentos() {
	    return manager.createQuery("SELECT distinct(p) FROM Produto p ORDER BY p.dataLancamento DESC", Produto.class).setMaxResults(4).getResultList();
	}

}
