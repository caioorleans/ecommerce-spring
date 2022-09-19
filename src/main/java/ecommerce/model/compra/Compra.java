package ecommerce.model.compra;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ecommerce.model.Cliente;
import ecommerce.model.Endereco;
import ecommerce.model.Produto;

@Entity
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private Cliente cliente;
	
	@Column(nullable = false)
	private Endereco enderecoEntrega;
	
	
	private List<Produto> produtos;
	
	@Column(nullable = false)
	private Double valorFrete;
	
	@Column(nullable = false)
	private Double valorTotal;
	
	@Column(nullable = false)
	private FormaPagamento formaPagamento;
	
	@Column(nullable = false)
	private StatusCompra status;
}
