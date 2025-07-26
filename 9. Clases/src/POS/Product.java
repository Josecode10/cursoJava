package POS;

public class Product { // Product objects will be added to Order objects
    //Initialize the class attributes
    private String name;
    private double price;
    private final int productID;
    private static int productCounter;

    // Defining the methods

    // Constructor method
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        // ProductID is assigned with the productCounter
        this.productID = ++Product.productCounter;
    }

    @Override
    public String toString() {
        return "ID: " + this.productID  
        + ", Name: " + this.name    
        + ", Price: USD$" + this.price; 
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}
