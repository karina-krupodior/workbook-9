package dao;
import model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDao implements ProductDao {
    private List<Product> products = new ArrayList<>();

    public SimpleProductDao() {
        products.add(new Product(1, "Laptop", "Electronics", 1200.0));
        products.add(new Product(2, "Phone", "Electronics", 800.0));
        products.add(new Product(3, "Book", "Education", 20.0));
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}
