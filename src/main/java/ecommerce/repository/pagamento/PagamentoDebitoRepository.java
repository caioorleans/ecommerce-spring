package ecommerce.repository.pagamento;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.model.pagamento.PagamentoDebito;

public interface PagamentoDebitoRepository extends JpaRepository<PagamentoDebito, Integer>{

}
