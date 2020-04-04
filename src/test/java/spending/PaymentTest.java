package spending;

import org.junit.Assert;
import org.junit.Test;

public class PaymentTest {

    @Test
    public void testCategory() {
        Payment payment = new Payment("", Category.Entertainment, 0.00d);
        Assert.assertEquals(Category.Entertainment, payment.category);

    }
}
