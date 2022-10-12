package ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.controller.mapper.ProdutoMapper;
import ecommerce.dto.ProdutoForm;
import ecommerce.model.Produto;
import ecommerce.service.CategoriaService;
import ecommerce.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/produtos")
@Api(tags = "Produto Controller")
public class ProdutoController {
	
	private final ProdutoService service;
	private final CategoriaService categoriaService;
	private final ProdutoMapper mapper;
	
	public ProdutoController(ProdutoService produtoService, CategoriaService categoriaService, ProdutoMapper mapper) {
		this.categoriaService = categoriaService;
		this.service= produtoService;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ApiOperation("Salvar um novo produto")
	private ResponseEntity<Produto> save(@RequestBody ProdutoForm produto) {
		Produto novoProduto = mapper.produtoFormToProduto(produto);
		novoProduto.setCategoria(categoriaService.findById(produto.getCategoriaId()));
		novoProduto = service.save(novoProduto);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
	}
}
