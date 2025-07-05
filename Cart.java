
import java.util.HashMap;
import java.util.Map;

class Cart {
    private Map<Product, Integer> allProducts;

    public Cart() {
        this.allProducts = new HashMap<>();
    }

    public void add(Product product, int quantity) {
        allProducts.merge(product, quantity, Integer::sum);
    }

    public Map<Product, Integer> getItems() {
        return allProducts;
    }

    public double getTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : allProducts.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}