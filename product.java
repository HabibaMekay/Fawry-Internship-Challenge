abstract class Product {
    protected String name;
    protected double price;
    protected double weight = 0;
    protected int quantity;
    protected boolean isExpirable;
    protected boolean isShippable;
    

    public Product(String name, double price, int quantity, int weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
 
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

    public void decreaseQuantity(int amount) {
        this.quantity -= amount;
    }


    public abstract boolean isExpired();
}

class Cart{
    List<Product> allProducts;
    void add(Product product){
        allProducts.add(product);
    }
}


class Customer{
    Cart myCart;
    void addItems(Product product, int quantity){
        if(product.getQuantity<= quantity){
            myCart.add(product);
        }
    }
    void checkout(){

    }
}