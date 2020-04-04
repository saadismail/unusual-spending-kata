package spending;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FetchesUserPaymentsByMonth {

    private static final Payment[] month2 = new Payment[] { new Payment(150.0, "a", Category.ENTERTAINMENT) };
    private static final Payment[] month3 = new Payment[] { new Payment(230.0, "b", Category.ENTERTAINMENT) };

    static public List<Payment> fetch(long userId, int year, int month){
        if (month == 2) {
            return Arrays.asList(month2);
        } else {
            return Arrays.asList(month3);
        }
    }
}
