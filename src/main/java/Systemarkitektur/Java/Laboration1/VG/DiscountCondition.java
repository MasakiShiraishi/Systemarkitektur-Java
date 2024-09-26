package Systemarkitektur.Java.Laboration1.VG;

import Systemarkitektur.Java.Laboration1.Product;

public interface DiscountCondition {
    boolean isApplicable(Product product);
}
