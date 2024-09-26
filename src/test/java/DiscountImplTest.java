import Systemarkitektur.Java.Laboration1.Discount;
import Systemarkitektur.Java.Laboration1.Product;
import Systemarkitektur.Java.Laboration1.VG.DiscountImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiscountImplTest {

    @Test
    public void testApplyDiscountForBook() {
        Discount discount = new DiscountImpl(
                product -> product.price() > 100,
                product -> product.price() * 0.1
        );
        Product book = new Product("Book", 300, 1);
        double discountApplied = discount.apply(book);

        assertEquals(30.0, discountApplied, "Discount for the book should be 10% of 300");
    }

    @Test
    public void testNoDiscountForCheapProduct() {
        Discount discount = new DiscountImpl(
                product -> product.price() > 100,
                product -> product.price() * 0.1
        );
        Product pen = new Product("Pen", 50, 1);
        double discountApplied = discount.apply(pen);
        assertEquals(0.0, discountApplied, "No discount should be applied for a product priced below 100");
    }

    @Test
    public void testApplyDiscountForSmartphone(){
        Discount discount = new DiscountImpl(
                product -> product.name().equals("Smartphone"),
                product -> product.price() * 0.15
        );
        Product smartphone = new Product("Smartphone", 1500,1);
        double discountApplied = discount.apply(smartphone);

        assertEquals(225.0, discountApplied, "Discount for the smartphone should be 15% of 1500");
    }

    @Test
    public void testDescriptionForEligibleDiscount() {
        Discount discount = new DiscountImpl(
                product -> product.price() > 100,
                product -> product.price() * 0.1
        );
        Product book = new Product("Book", 300, 1);
        String description = discount.getDescription(book);

        assertTrue(description.contains("is eligible for a discount"));
    }

    @Test
    public void testDescriptionForNotEligibleDiscount(){
        Discount discount = new DiscountImpl(
                product -> product.price() > 100,
                product -> product.price() * 0.1
        );
        Product pen = new Product("Pen", 50, 1);
        String description = discount.getDescription(pen);

        assertTrue(description.contains("is not eligible for a discount"));
    }

    @Test
    public void testDiscountNotZeroForBook(){
        Discount discount = new DiscountImpl(
                product -> product.price() > 100,
                product -> product.price() * 0.1
        );
        Product book = new Product("Book", 300, 1);
        double discountApplied = discount.apply(book);

        assertNotEquals(0.0, discountApplied);
    }

    @Test
    public void testDiscountNotEqualForCheapProduct() {
        Discount discount = new DiscountImpl(
                product -> product.price() > 100,
                product -> product.price() * 0.1
        );
        Product pen = new Product("Pen", 50, 1);
        double discountApplied = discount.apply(pen);
        assertNotEquals(5.0, discountApplied);
    }
}
