package POS;

public class PosTest {
    public static void main(String[] args) {
        // Create products
        var hat = new Product("Hat", 10.5);
        var shirt = new Product("Shirt", 12.99);
        var pants = new Product("Pants", 20.99);
        var socks = new Product("Sock", 8.99);
        var skirt = new Product("Skirt", 30.99);
        var dress = new Product("Dress", 45.55);
        var blouse = new Product("Blouse", 60.99);
        var hoodie = new Product("Hoodie", 99.99);
        var jacket = new Product("Jacket", 200.99);
        var shorts = new Product("Shorts", 17.99);
        var overall = new Product("Overall", 150.99);

        // Create an order
        var order1 = new Order();

        // Add products to the order
        order1.addProduct(hat);
        order1.addProduct(shirt);
        order1.addProduct(blouse);

        // Show orden information
        System.out.println("\n" + order1.toString() + "\n");
        order1.showProducts();

        // create another order
        var order2 = new Order();

        // Add products to the order
        order2.addProduct(dress);
        order2.addProduct(overall);
        order2.addProduct(hoodie);

        // show order information
        System.out.println("\n" + order2.toString() + "\n");
        order2.showProducts();
    
    }

}
