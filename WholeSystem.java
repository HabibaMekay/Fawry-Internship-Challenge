import java.time.LocalDate;

public class WholeSystem {
    public static void main(String[] args) {

        System.out.println("Test Case 1: Successful Normal Checkout");
        try {
            Product cheese = new RealProduct("Cheese", 5.99, 10, 0.5, true, true, LocalDate.of(2025, 12, 31));
            Product tv = new RealProduct("TV", 299.99, 5, 15.0, false, true, null); 
 
            Customer customer = new Customer(500.0);

            customer.addItems(cheese, 2);    
            customer.addItems(tv, 1);        
            customer.checkout();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();

        System.out.println("Test Case 2: Empty Cart Error");
        try {
            Customer emptyCartCustomer = new Customer(500.0);
            emptyCartCustomer.checkout(); 
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();

  
        System.out.println("Test Case 3: Insufficient Balance Error");
        try {
            Product cheeseLow = new RealProduct("Cheese", 5.99, 10, 0.5, true, true, LocalDate.of(2025, 12, 31));
            Product tvLow = new RealProduct("TV", 299.99, 5, 15.0, false, true, null);
            Customer lowBalanceCustomer = new Customer(300.0); 

            lowBalanceCustomer.addItems(cheeseLow, 2);
            lowBalanceCustomer.addItems(tvLow, 1);
            lowBalanceCustomer.checkout(); 
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();


   
        System.out.println("Test Case 4: Expired Product Error");
        try {
            Product expiredCheese = new RealProduct("Cheese", 5.99, 10, 0.5, true, true, LocalDate.of(2025, 6, 1)); 
            Customer customer = new Customer(500.0);

            customer.addItems(expiredCheese, 2);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();


        System.out.println("Test Case 5: Out-of-Stock Error");
        try {
            Product limitedTV = new RealProduct("Limited TV", 299.99, 1, 15.0, false, true, null); 
            Customer customer = new Customer(500.0);

            customer.addItems(limitedTV, 2); 
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();


        System.out.println("Test Case 6: Cart Clearing Verification");
        try {
            Product cheeseClear = new RealProduct("Cheese", 5.99, 10, 0.5, true, true, LocalDate.of(2025, 12, 31));
            Customer customer = new Customer(500.0);

            customer.addItems(cheeseClear, 2);
            customer.checkout(); 
            customer.checkout(); 
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}