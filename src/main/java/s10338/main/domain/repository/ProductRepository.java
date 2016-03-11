package s10338.main.domain.repository;

import s10338.main.domain.Product;

import java.util.List;
import java.util.Map;

public interface ProductRepository {

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByFilter(Map<String, List<String>> filter);

    Product getProductById(String productID);
}
