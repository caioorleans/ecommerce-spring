package ecommerce.model.cartao;

import java.time.LocalDateTime;

public class Cartao {
	
	private Integer id;
	private Long numero;
	private String titular;
	private LocalDateTime validade;
	private String cvv;
	private TipoCartao tipo;
}
