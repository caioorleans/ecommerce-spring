package ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.controller.mapper.CategoriaMapper;
import ecommerce.dto.CategoriaDTO;
import ecommerce.model.Categoria;
import ecommerce.service.CategoriaService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("categorias")
@Api(tags = "Categoria Controller")
public class CategoriaController {
	
	private final CategoriaService service;
	private final CategoriaMapper categoriaMapper;
	
	public CategoriaController(CategoriaService categoriaService, CategoriaMapper categoriaMapper) {
		this.service = categoriaService;
		this.categoriaMapper = categoriaMapper;
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> getAllCategorias(){
		List<Categoria> categorias  = service.findAll();
		return ResponseEntity.ok(categoriaMapper.toCategoriaDTOList(categorias));
	}
	
	@PostMapping
	public ResponseEntity<CategoriaDTO> save(@RequestBody String descricao){
		Categoria categoria = new Categoria();
		categoria.setDescricao(descricao);
		Categoria novaCategoria = service.save(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaMapper.toCategoriaDTO(novaCategoria));
	}
	
	@PutMapping
	public ResponseEntity<CategoriaDTO> update(@RequestBody CategoriaDTO categoria){
		Categoria novaCategoria = categoriaMapper.toCategoria(categoria);
		service.findById(novaCategoria.getId());
		return ResponseEntity.ok(categoriaMapper.toCategoriaDTO(service.save(novaCategoria)));
	}
	
}
