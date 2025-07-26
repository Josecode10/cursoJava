package POS;

import java.text.DecimalFormat;

public class Order {
    // Initialize the class attributes
    private Product[] products;
    private static final int productMaximum = 10;
    private static int orderCounter;
    private int productCounter;
    private int orderID;

    // Define the methods

    public Order() {
        this.products = new Product[Order.productMaximum];
        this.orderID = ++Order.orderCounter;
    }

    public void addProduct(Product product) {
        // Check how many products the order has already
        if (this.productCounter < Order.productMaximum) { 
            // The order has 9 or less products
            products[this.productCounter++] = product;
        }
        else {
            // The order has 10 products already
            System.out.println("You can not add more products. You've reached the product maximum: " + Order.productMaximum);
        }
    }

    public double calculateTotal() {
        double total = 0; // Variable to add up the prices
        var pattern = "#.##";
        var decimalFormat = new DecimalFormat(pattern);

        // For loop to iterate on the product prices
        for (var i=0; i < this.productCounter; i++) {
            // Adding up the prices by using the getPrice method of Product class
            // Products[i] is equal to the object located on that index
            total += products[i].getPrice();
        }
        // Once the iteration is up the total will be returned
        return total;
    }

    public String toString() {
        return "Order ID: " + this.orderID + ", Total: " + calculateTotal();
    }

    public void showProducts() {
        for(var i=0; i < this.productCounter; i++) {
            // Display product info by using the toSring method of the product class
            System.out.println("Producto " + (i+1) + ": " + products[i].toString());
        }
    }
}
