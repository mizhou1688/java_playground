package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Write test cases for this below code
 */
class Product {
    private String name;
    private double price;
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}
class ShoppingCart {
    private List<Product> items;
    public ShoppingCart() {
        items = new ArrayList < > ();
    }
    public void addItem(Product product) { // No delete item method
        items.add(product);
    }
    public List<Product> getItems() {
        return items;
    }
    public double calculateTotal() {
        double total = 0;
        for (Product item: items) {
            total += item.getPrice();
        }
        return total;
    }
}
class DiscountManager {
    public double applyDiscount(ShoppingCart cart, double discountRate) {
        double total = cart.calculateTotal();
        return total * (1 - discountRate);
    }
}
public class Main2 {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 1000); // price negtive, name is "", null (need check and throw exception)
        Product product2 = new Product("Mouse", 20);
        ShoppingCart cart = new ShoppingCart(); // List should be parameterized in the class
        cart.addItem(product1);
        cart.addItem(product2);
        DiscountManager discountManager = new DiscountManager();
        double discountedPrice = discountManager.applyDiscount(cart, 0.1); // null, empty cart, discount is 0, 1, negtive
        System.out.println("Discounted price: " + discountedPrice);
    }
}

