package ecommerce.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProdutoNotFoundException extends RuntimeException{

	public ProdutoNotFoundException(Integer id) {
		super("Produto not found. Id: "+ id);
	}
}
