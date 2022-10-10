package ecommerce.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CategoriaNotFoundException extends RuntimeException{
	public CategoriaNotFoundException(Integer id) {
		super("Categoria not found! Id: " + id);
	}
}
