package ecommerce.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import ecommerce.dto.CategoriaDTO;
import ecommerce.model.Categoria;

@Component
public class CategoriaMapper {

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();
	
	public CategoriaDTO toCategoriaDTO(Categoria categoria) {
		return MODEL_MAPPER.map(categoria, CategoriaDTO.class);
	}
	
	public List<CategoriaDTO> toCategoriaDTOList(List<Categoria> categorias){
		return categorias.stream().map(this::toCategoriaDTO).collect(Collectors.toList());
	}
	
	public Categoria toCategoria(CategoriaDTO categoria) {
		return MODEL_MAPPER.map(categoria, Categoria.class);
	}
	
	public List<Categoria> toCategoriaList(List<CategoriaDTO> categorias){
		return categorias.stream().map(this::toCategoria).collect(Collectors.toList());
	}
}
