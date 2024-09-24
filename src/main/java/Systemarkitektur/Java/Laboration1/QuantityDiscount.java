package Systemarkitektur.Java.Laboration1;

public class QuantityDiscount extends BaseDiscount{

    public QuantityDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.quantity() > 5;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return 10;
    }

    @Override
    protected String generateDescription(Product product) {
        return "10 kr discount per product for quantities of 5 or more!";
    }
}
