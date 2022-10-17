package ecommerce.service;

import org.springframework.stereotype.Service;

import ecommerce.Exception.ProdutoNotFoundException;
import ecommerce.dto.UpdateProdutoForm;
import ecommerce.model.Produto;
import ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	private final ProdutoRepository repository;
	private final CategoriaService categoriaService;
	
	public ProdutoService(ProdutoRepository repository, CategoriaService categoriaService) {
		this.repository = repository;
		this.categoriaService = categoriaService;
	}
	
	public Produto save(Produto produto) {
		return repository.save(produto);
	}
	
	public Produto update(UpdateProdutoForm produtoForm) {
		Produto produto = findById(produtoForm.getId());
		produto.setNome(produtoForm.getNome());
		produto.setDescricao(produtoForm.getDescricao());
		produto.setImagem(produtoForm.getImagem());
		produto.setPreco(produtoForm.getPreco());
		produto.setCategoria(categoriaService.findById(produtoForm.getCategoriaId()));
		return save(produto);
	}

	public Produto findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ProdutoNotFoundException(id));
	}
	
	public Produto addUnidades(Integer id, Integer quantidade) {
		Produto produto = findById(id);
		produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + quantidade);
		return save(produto);
	}
	
}
