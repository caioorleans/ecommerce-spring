package ecommerce.repository.pagamento;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.model.pagamento.PagamentoBoleto;

public interface PagamentoBoletoRepository extends JpaRepository<PagamentoBoleto, Integer>{

}
