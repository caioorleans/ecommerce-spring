package ecommerce.model.compra;

import javax.persistence.Entity;

import ecommerce.model.Produto;

@Entity
public class ProdutoCompra {
	private Integer id;
	private Produto produto;
	private Double valor;
	private Integer quantidade;
}
