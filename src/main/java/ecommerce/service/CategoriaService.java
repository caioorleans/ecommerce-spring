package ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ecommerce.Exception.CategoriaNotFoundException;
import ecommerce.model.Categoria;
import ecommerce.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	private final CategoriaRepository repository;
	
	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.repository = categoriaRepository;
	}
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Categoria save(Categoria categoria) {
		return repository.save(categoria);
	}
	
	public Categoria findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new CategoriaNotFoundException(id));
	}
}
