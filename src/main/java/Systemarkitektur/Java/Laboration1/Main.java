package Systemarkitektur.Java.Laboration1;

public class Main {
    public static void main(String[] args) {

        Product pc = new Product("PC", 6000, 1);
        Product milk = new Product("Milk", 20, 1);
        Product apple = new Product("Apple", 15, 10);
        Product bread = new Product("Bread", 25, 5);
        Product orange = new Product("Orange", 20, 12);
        Product cheese = new Product("Cheese", 50, 2);

        Discount fridayDiscount = new FridayDiscount(null);
        Discount milkDiscount = new MilkDiscount(fridayDiscount);
        Discount quantityDiscount = new QuantityDiscount(milkDiscount);
        Product[] products = {pc, milk, apple, bread, orange, cheese};

        for (Product product : products) {
            System.out.println("---------------------------");
            System.out.println("Product: " + product);
            System.out.println("Discount applied: " + quantityDiscount.apply(product));
            System.out.println("Discount description: " + quantityDiscount.getDescription(product));
            System.out.println("---------------------------");
        }
    }
}