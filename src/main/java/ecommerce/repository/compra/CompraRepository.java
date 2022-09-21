package ecommerce.repository.compra;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.model.compra.Compra;

public interface CompraRepository extends JpaRepository<Compra, Integer>{

}
