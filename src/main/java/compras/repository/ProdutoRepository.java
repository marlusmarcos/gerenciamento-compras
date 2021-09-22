package compras.repository;

import java.util.List;

import models.Produto;

public interface ProdutoRepository {
	List<Produto> listar ();
	Produto buscar (int id);
	Produto salvar (Produto produto);
	void remover (int id);
}
