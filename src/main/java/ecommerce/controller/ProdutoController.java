package ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.controller.mapper.ProdutoMapper;
import ecommerce.dto.NewProdutoForm;
import ecommerce.dto.UpdateProdutoForm;
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
	public ResponseEntity<Produto> save(@RequestBody NewProdutoForm produto) {
		Produto novoProduto = mapper.newProdutoFormToProduto(produto);
		novoProduto.setCategoria(categoriaService.findById(produto.getCategoriaId()));
		novoProduto = service.save(novoProduto);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
	}
	
	@PutMapping
	@ApiOperation("Atualizar informações do produto")
	public ResponseEntity<Produto> update(@RequestBody UpdateProdutoForm produtoForm){
		Produto produto = service.update(produtoForm);
		return ResponseEntity.ok(produto);
	}
	
	@PatchMapping
	@ApiOperation("Adicionar unidades de produto ao estoque")
	public ResponseEntity<Produto> addUnidadeProduto(@RequestBody Integer idProduto, Integer quantidade){
		Produto produto = service.addUnidades(idProduto, quantidade);
		return ResponseEntity.ok(produto);
	}
	
	@GetMapping
	@ApiOperation("Encontra um produto pelo Id")
	public ResponseEntity<Produto> findById(Integer id){
		Produto produto = service.findById(id);
		return ResponseEntity.ok(produto);
	}
}
