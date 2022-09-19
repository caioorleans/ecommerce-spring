package ecommerce.model.pagamento;

import ecommerce.model.cartao.Cartao;
import ecommerce.model.compra.Compra;

public class PagamentoCredito {
	private Integer id;
	private Compra compra;
	private Cartao cartao;
	private Integer numeroParcelas;
}
