package Systemarkitektur.Java.Laboration1;

public abstract class BaseDiscount implements Discount{

    protected Discount nextDiscount;

    public BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    @Override
    public String getDescription(Product product) {
        if(isApplicable(product)){
            return generateDescription(product);
        } else if (nextDiscount != null) {
            return nextDiscount.getDescription(product);
        }
        return "No discount";
    }

    @Override
    public double apply(Product product) {
        if(isApplicable(product)){
            double discountAmount = calculateDiscount(product);
            return discountAmount;
        }else if (nextDiscount != null) {
            return nextDiscount.apply(product);
        }
        return 0;
    }

    protected abstract boolean isApplicable(Product product);
    protected abstract double calculateDiscount(Product product);
    protected abstract String generateDescription(Product product);
}
