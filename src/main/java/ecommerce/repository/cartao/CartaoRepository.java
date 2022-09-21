package ecommerce.repository.cartao;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.model.cartao.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Integer>{
	
}
