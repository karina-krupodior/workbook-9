package dao;


import model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDao implements ProductDao {

    private List<Product> products = new ArrayList<>();
    private int nextId = 1;

    public SimpleProductDao() {
        products.add(new Product(nextId++, "Milk", "Dairy", 2.5));
        products.add(new Product(nextId++, "Bread", "Bakery", 1.0));
    }

    @Override
    public void add(Product product) {
        product.setId(nextId++);
        products.add(product);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}
