abstract class Product implements Shippable {
    protected String name;
    protected double price;
    protected double weight;
    protected int quantity;
    protected boolean isExpirable;
    protected boolean isShippable;

    public Product(String name, double price, int quantity, double weight, boolean isExpirable, boolean isShippable) throws Exception {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isExpirable = isExpirable;
        this.isShippable = isShippable;
        this.weight = isShippable ? weight : 0.0;
        if (isShippable && weight <= 0) {
            throw new Exception("Weight must be positive");
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public abstract boolean isExpired();
}