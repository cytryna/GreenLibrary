package s10338.main.domain.repository;

import s10338.main.domain.Product;

import java.util.List;

public interface ProductRepository {

	List <Product> getAllProducts();
	
	Product getProductById(String productID);
}
