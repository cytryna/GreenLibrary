package s10338.main.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import s10338.main.domain.Product;
import s10338.main.domain.repository.ProductRepository;
import s10338.main.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductRepository productRepository;

    public void processOrder(String productId, long quantity) {
        Product productById = productRepository.getProductById(productId);

        if (productById.getUnitsInStock() < quantity) {
            throw new IllegalArgumentException("Zbyt ma�o towaru. Obecna liczba sztuk w magazynie " + productById.getUnitsInStock());
        }

        productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
    }
}
