package ecommerce.model;

import java.util.List;

import ecommerce.model.cartao.Cartao;

public class Cliente {

	private Integer id;
	private String email;
	private String senha;
	private String nome;
	private List<Endereco> enderecos;
	private List<Cartao> cartoes;
}
