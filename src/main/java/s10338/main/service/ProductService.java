package s10338.main.service;

import s10338.main.domain.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByFilter(Map<String, List<String>> filter);

    Product getProductById(String id);

    List<Product> getProductsByManufacturer(String manufacturer);

    void addProduct(Product product);
}
