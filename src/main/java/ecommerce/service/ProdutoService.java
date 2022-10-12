package ecommerce.service;

import org.springframework.stereotype.Service;

import ecommerce.model.Produto;
import ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	private final ProdutoRepository repository;
	
	public ProdutoService(ProdutoRepository repository) {
		this.repository = repository;
	}
	
	public Produto save(Produto produto) {
		return repository.save(produto);
	}

}
