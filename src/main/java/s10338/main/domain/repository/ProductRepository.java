package s10338.main.domain.repository;

import s10338.main.domain.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    Product getProductById(String productID);
}
