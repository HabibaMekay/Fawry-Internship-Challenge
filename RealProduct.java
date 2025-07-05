//implements abstract of the product

import java.time.LocalDate;


class RealProduct extends Product {
    private LocalDate expiryDate;
    public RealProduct(String name, double price, int quantity, double weight, boolean isExpirable, boolean isShippable, LocalDate expiryDate) throws Exception {
        super(name, price, quantity, weight, isExpirable, isShippable);

        this.expiryDate = isExpirable ? expiryDate : null;
    }

    @Override
    public boolean isExpired() {
        return isExpirable && expiryDate != null && LocalDate.now().isAfter(expiryDate);
    }
}
