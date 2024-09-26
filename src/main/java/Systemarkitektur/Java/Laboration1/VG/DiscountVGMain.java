package Systemarkitektur.Java.Laboration1.VG;

import Systemarkitektur.Java.Laboration1.Discount;
import Systemarkitektur.Java.Laboration1.Product;

public class DiscountVGMain {
    public static void main(String[] args) {

        Discount discount1 = new DiscountImpl(
                product -> product.price() > 100,
                product -> product.price() * 0.1
        );
        Product book = new Product("Book", 300,1);
        System.out.println(book);
        System.out.println(discount1.getDescription(book));
        double bookDiscount = discount1.apply(book);
        System.out.println("You can only pay " + (book.price() - bookDiscount) + " with discount");
        System.out.println("---------------------------");

        Discount discount2 = new DiscountImpl(
                product -> product.name().equals("Smartphone"),
                product -> product.price() * 0.15
        );
        Product smartphone = new Product("Smartphone", 1500,1);
        System.out.println(smartphone);
        System.out.println(discount2.getDescription(smartphone));
        double smartphoneDiscount = discount2.apply(smartphone);
        System.out.println("You can only pay " + (smartphone.price() - smartphoneDiscount) + " with discount");





    }
    }

