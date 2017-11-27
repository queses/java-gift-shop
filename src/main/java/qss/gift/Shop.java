package qss.gift;

import lombok.Getter;
import qss.gift.products.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {
    // Каталог продуктов:
    @Getter private HashMap<String, List<Product>> catalog;

    public Shop() {
        this.catalog = new HashMap<>();
    }

    public void addProduct(Product product) {
//        this.products.add(product);
        String category = product.getCategoryName();
        if (!this.catalog.containsKey(category)) {
            this.catalog.put(category, new ArrayList<>());
        }
        this.catalog.get(category).add(product);
    }

    public List<Product> getProducts(Integer categoryNum) {
        String categoryKey = catalog.keySet().toArray()[categoryNum].toString();
        return getProducts(categoryKey);
    }

    public List<Product> getProducts(String category) {
        return catalog.get(category);
    }
}
