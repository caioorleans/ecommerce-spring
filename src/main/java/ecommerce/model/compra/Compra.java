package ecommerce.model.compra;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import ecommerce.model.Cliente;
import ecommerce.model.Endereco;

@Entity
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@Column(nullable = false)
	@ManyToOne
	@JoinColumn(name = "id_endereco")
	private Endereco enderecoEntrega;
	
	@OneToMany(mappedBy = "compra", fetch = FetchType.LAZY)
	private List<ProdutoCompra> produtos;
	
	@Column(nullable = false)
	private Double valorFrete;
	
	@Column(nullable = false)
	private Double valorTotal;
	
	@Column(nullable = false)
	private FormaPagamento formaPagamento;
	
	@Column(nullable = false)
	private StatusCompra status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public List<ProdutoCompra> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoCompra> produtos) {
		this.produtos = produtos;
	}

	public Double getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public StatusCompra getStatus() {
		return status;
	}

	public void setStatus(StatusCompra status) {
		this.status = status;
	}
	
	
}
