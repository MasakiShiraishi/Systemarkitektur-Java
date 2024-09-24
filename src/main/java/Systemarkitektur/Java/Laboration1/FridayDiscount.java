package Systemarkitektur.Java.Laboration1;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class FridayDiscount extends BaseDiscount {

    public FridayDiscount(BaseDiscount nextDiscount) {
        super(nextDiscount);
    }
    @Override
    protected boolean isApplicable(Product product) {
        return LocalDate.now().getDayOfWeek() == DayOfWeek.FRIDAY;
    }

    @Override
    protected String generateDescription(Product product) {
        return "10% discount for FRIDAY!";
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price()*0.10;
    }


}
