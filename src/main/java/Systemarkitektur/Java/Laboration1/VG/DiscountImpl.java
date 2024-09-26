package Systemarkitektur.Java.Laboration1.VG;

import Systemarkitektur.Java.Laboration1.BaseDiscount;
import Systemarkitektur.Java.Laboration1.Discount;
import Systemarkitektur.Java.Laboration1.Product;

public class DiscountImpl implements Discount {
    private DiscountCondition condition;
    private DiscountCalculator calculator;

    public DiscountImpl(DiscountCondition condition, DiscountCalculator calculator) {
        this.condition = condition;
        this.calculator = calculator;
    }

    @Override
    public double apply(Product product) {
        if (condition.isApplicable(product)) {
            return calculator.calculateDiscount(product);
        }
        return 0;
    }

    @Override
    public String getDescription(Product product) {
        if (condition.isApplicable(product)) {
            return "Product: " + product.name() + " is eligible for a discount. Discount applied: "
                    + calculator.calculateDiscount(product);
        }
        return "Product: " + product.name() + " is not eligible for a discount.";
    }
    }

