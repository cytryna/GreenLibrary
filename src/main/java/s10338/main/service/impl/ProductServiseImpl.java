package s10338.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import s10338.main.domain.Product;
import s10338.main.domain.repository.ProductRepository;
import s10338.main.service.ProductService;

import java.util.List;

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
}
