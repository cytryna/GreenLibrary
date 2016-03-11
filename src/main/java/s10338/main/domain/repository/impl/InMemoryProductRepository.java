package s10338.main.domain.repository.impl;

import org.springframework.stereotype.Repository;
import s10338.main.domain.Product;
import s10338.main.domain.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private List<Product> listOfProducts = new ArrayList<Product>();

    public InMemoryProductRepository() {
        Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
        iphone.setDescription("Apple iPhone 5s, smartfon z 4-calowym ekranem o rozdzielczo�ci 640�1136 i 8-megapikselowym aparatem");
        iphone.setCategory("smartfon");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(1000);

        Product laptop_dell = new Product("P1235", "Dell Inspiron", new BigDecimal(700));
        laptop_dell.setDescription("Dell Inspiron, 14-calowy laptop (czarny) z procesorami Intel Core 3. generacji");
        laptop_dell.setCategory("laptop");
        laptop_dell.setManufacturer("Dell");
        laptop_dell.setUnitsInStock(1000);

        Product tablet_Nexus = new Product("P1236", "Nexus 7", new BigDecimal(300));
        tablet_Nexus.setDescription("Google Nexus 7 jest najl�ejszym 7-calowym tabletem z 4-rdzeniowym procesorem Qualcomm Snapdragon� S4 Pro");
        tablet_Nexus.setCategory("tablet");
        tablet_Nexus.setManufacturer("Google");
        tablet_Nexus.setUnitsInStock(1000);

        listOfProducts.add(iphone);
        listOfProducts.add(laptop_dell);
        listOfProducts.add(tablet_Nexus);

    }

    public List<Product> getAllProducts() {
        return listOfProducts;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return listOfProducts.stream().filter(product -> product.getCategory().equals(category)).collect(Collectors.toList());
    }

    public Product getProductById(String productId) {
        Product productById = null;

        for (Product product : listOfProducts) {
            if (product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
                productById = product;
                break;
            }
        }

        if (productById == null) {
            throw new IllegalArgumentException("Brak produktu o wskazanym id: " + productId);
        }

        return productById;
    }
}
