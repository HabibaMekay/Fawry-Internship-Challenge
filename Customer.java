import java.util.ArrayList;
import java.util.List;
import java.util.Map;


class Customer {
    private Cart myCart;
    private double balance;

    public Customer(double balance) {
        this.myCart = new Cart();
        this.balance = balance;
    }

    public void addItems(Product product, int quantity) throws Exception {
        if (quantity <= 0) {
            throw new Exception("Quantity must be positive");
        }
        if (quantity > product.getQuantity()) {
            throw new Exception("Requested quantity not available for " + product.getName());
        }
        if (product.isExpired()) {
            throw new Exception(product.getName() + " is expired");
        }
        myCart.add(product, quantity);
        product.reduceQuantity(quantity);
    }

    public void checkout() throws Exception {
        if (myCart.getItems().isEmpty()) {
            throw new Exception("Cart is empty");
        }
        double subtotal = myCart.getTotal();
        double shippingFee = 0;
        List<Shippable> shippableItems = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry : myCart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            if (product.isShippable == true) {
                for (int i = 0; i < quantity; i++) {
                    shippableItems.add(product);
                }
                shippingFee += product.getWeight() * quantity * 2.0; 
            }
        }

        double total = subtotal + shippingFee;

        if (balance < total) {
            throw new Exception("Insufficient balance. Required: $" + total + ", Available: $" + balance);
        }

        balance -= total;

        new ShippingService().shipProducts(shippableItems);
        myCart.getItems().clear();
        getReciept(subtotal, shippingFee, total, balance); //call UI basically

    }

     public void getReciept(double subtotal, double shippingFee, double total, double balance) {
        System.out.println("\nCheckout Receipt:");
        System.out.println("#----------------------------------#");
        System.out.println("Order Subtotal: $" + String.format("%.2f", subtotal));
        System.out.println("Shipping Fees: $" + String.format("%.2f", shippingFee));
        System.out.println("Total Paid: $" + String.format("%.2f", total));
        System.out.println("Remaining Balance: $" + String.format("%.2f", balance));
        System.out.println("Come to my shop again by accepting my application!");
    }
}