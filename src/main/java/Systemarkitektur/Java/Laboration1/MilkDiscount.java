package Systemarkitektur.Java.Laboration1;

public class MilkDiscount extends BaseDiscount{

    public MilkDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.name().equalsIgnoreCase("milk");
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * 0.05;
    }

    @Override
    protected String generateDescription(Product product) {
        return "5% discount on MILK";
    }
}
