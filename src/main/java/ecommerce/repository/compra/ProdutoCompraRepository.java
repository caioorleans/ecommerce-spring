package ecommerce.repository.compra;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.model.compra.ProdutoCompra;

public interface ProdutoCompraRepository extends JpaRepository<ProdutoCompra, Integer>{

}
