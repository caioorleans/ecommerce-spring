package ecommerce.repository.pagamento;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.model.pagamento.PagamentoCredito;

public interface PagamentoCreditoRepository extends JpaRepository<PagamentoCredito, Integer>{
	
}
