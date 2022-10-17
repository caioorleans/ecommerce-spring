package ecommerce.controller.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import ecommerce.dto.NewProdutoForm;
import ecommerce.model.Produto;

@Component
public class ProdutoMapper {
	private static final ModelMapper MODEL_MAPPER = new ModelMapper();
	
	public Produto newProdutoFormToProduto(NewProdutoForm form) {
		return MODEL_MAPPER.map(form, Produto.class);
	}
}
