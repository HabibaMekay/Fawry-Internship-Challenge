import java.util.List;

class ShippingService {
    public void shipProducts(List<Shippable> products) {
        System.out.println("Shipping these: ");
        for (Shippable product : products) {
            System.out.println(product.getName() + " with weight: " + product.getWeight() + "kg");
        }
    }
}