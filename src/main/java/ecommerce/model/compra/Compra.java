package ecommerce.model.compra;

import java.util.List;

import ecommerce.model.Cliente;
import ecommerce.model.Endereco;
import ecommerce.model.Produto;

public class Compra {
	
	private Integer id;
	private Cliente cliente;
	private Endereco enderecoEntrega;
	private List<Produto> produtos;
	private Double valorFrete;
	private Double valorTotal;
	private FormaPagamento formaPagamento;
	private StatusCompra status;
}
