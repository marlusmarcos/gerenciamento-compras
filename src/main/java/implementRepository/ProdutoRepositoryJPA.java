package implementRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;

import compras.repository.ProdutoRepository;
import models.Produto;

public class ProdutoRepositoryJPA implements ProdutoRepository{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Produto> listar() {
		return manager.createQuery("from * produtos", Produto.class).getResultList();
	}

	@Override
	public Produto buscar(int id) {
		return manager.find(Produto.class, id);
	}

	@Transactional
	@Override
	public Produto salvar(Produto produto) {
		return manager.merge(produto);
	}

	@Override
	public void remover(int id) {
		Produto produto = buscar(id);
		if (produto == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(produto);
	}

}
