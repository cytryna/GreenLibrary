package s10338.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import s10338.domain.Product;
import s10338.domain.repository.ProductRepository;
import s10338.service.ProductService;

import java.util.List;
import java.util.Map;

/**
 * Created by rwichrowski on 07.03.16.
 */
@Service
public class ProductServiseImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.getProductsByCategory(category);
    }

    @Override
    public List<Product> getProductsByFilter(Map<String, List<String>> filter) {
        return productRepository.getProductsByFilter(filter);
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.getProductById(id);
    }

    @Override
    public List<Product> getProductsByManufacturer(String manufacturer) {
        return productRepository.getProductsByManufacturer(manufacturer);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }
}
