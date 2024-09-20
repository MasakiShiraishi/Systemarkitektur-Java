package Systemarkitektur.Java.Laboration1;

public interface Discount {
    double apply(Product product);
    String getDescription(Product product);
}
