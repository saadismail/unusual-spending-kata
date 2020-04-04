package spending;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MonthPaymentTest {

    @Test
    public void testMonthlyPayment() {
        List<Payment> payments = Arrays.asList(
                new Payment("xyz", Category.Entertainment, 0.03d),
                new Payment("abc", Category.Entertainment, 0.01d)
        );
        MonthPayment junePayment = new MonthPayment(payments);

        Assert.assertEquals(0.04d,junePayment.getPaymentCategory(Category.Entertainment), 0.0001d);

    }

}
