package spending;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class DetectUnusualSpendingTest {

    @Test
    public void detectTest() {
    }

    @Test
    public void filterUnusualPayments() {
        Map<Category,Double> categoryLastMonthAmount = new LinkedHashMap<>();
        categoryLastMonthAmount.put(Category.ENTERTAINMENT,100.0);
        categoryLastMonthAmount.put(Category.GOLF,120.0);
        categoryLastMonthAmount.put(Category.TRAVEL,0.0);

        Map<Category,Double> categoryCurrentMonthAmount = new LinkedHashMap<>();
        categoryCurrentMonthAmount.put(Category.ENTERTAINMENT,253.5);
        categoryCurrentMonthAmount.put(Category.GOLF,10.0);
        categoryCurrentMonthAmount.put(Category.TRAVEL,165.0);

        List<Payment> actualPayments =  DetectUnusualSpending.filterUnusualPayments(categoryLastMonthAmount,categoryCurrentMonthAmount);
        List<Payment> expectedPayments = new ArrayList<>();
        expectedPayments.add(new Payment(253.5,"Total",Category.ENTERTAINMENT));
        expectedPayments.add(new Payment(165.0,"Total",Category.TRAVEL));

        Assert.assertEquals(expectedPayments,actualPayments);
    }

    @Test
    public void getGroupedCategoriesAmount_whenOneGroup() {
        List<Payment> payments =  new ArrayList<>();
        payments.add(new Payment(132.5,"a",Category.ENTERTAINMENT));
        payments.add(new Payment(160.0,"b",Category.GOLF));
        payments.add(new Payment(11.0,"c",Category.ENTERTAINMENT));
        payments.add(new Payment(251.0,"d",Category.TRAVEL));
        Map<Category,Double> actualGroupedCategoriesAmount = DetectUnusualSpending.getGroupedCategoriesAmount(payments);
        Map<Category,Double> expectedGroupedCategoriesAmount = new HashMap<>();
        expectedGroupedCategoriesAmount.put(Category.ENTERTAINMENT,143.5);
        expectedGroupedCategoriesAmount.put(Category.GOLF,160.0);
        expectedGroupedCategoriesAmount.put(Category.TRAVEL,251.0);
        Assert.assertEquals(expectedGroupedCategoriesAmount,actualGroupedCategoriesAmount);
    }

    @Test
    public void getGroupedCategoriesAmount_whenTwoGroups() {
        List<Payment> payments =  new ArrayList<>();
        payments.add(new Payment(122.5,"a",Category.ENTERTAINMENT));
        payments.add(new Payment(160.0,"b",Category.GOLF));
        payments.add(new Payment(11.0,"c",Category.ENTERTAINMENT));
        payments.add(new Payment(24.0,"e",Category.GOLF));
        payments.add(new Payment(251.0,"d",Category.TRAVEL));
        Map<Category,Double> actualGroupedCategoriesAmount = DetectUnusualSpending.getGroupedCategoriesAmount(payments);
        Map<Category,Double> expectedGroupedCategoriesAmount = new HashMap<>();
        expectedGroupedCategoriesAmount.put(Category.ENTERTAINMENT,133.5);
        expectedGroupedCategoriesAmount.put(Category.GOLF,184.0);
        expectedGroupedCategoriesAmount.put(Category.TRAVEL,251.0);
        Assert.assertEquals(expectedGroupedCategoriesAmount,actualGroupedCategoriesAmount);
    }

    @Test
    public void getGroupedCategoriesAmount_whenNoGroup() {
        List<Payment> payments =  new ArrayList<>();
        payments.add(new Payment(122.5,"a",Category.ENTERTAINMENT));
        payments.add(new Payment(160.0,"b",Category.GOLF));
        payments.add(new Payment(251.0,"d",Category.TRAVEL));
        Map<Category,Double> actualGroupedCategoriesAmount = DetectUnusualSpending.getGroupedCategoriesAmount(payments);
        Map<Category,Double> expectedGroupedCategoriesAmount = new HashMap<>();
        expectedGroupedCategoriesAmount.put(Category.ENTERTAINMENT,122.5);
        expectedGroupedCategoriesAmount.put(Category.GOLF,160.0);
        expectedGroupedCategoriesAmount.put(Category.TRAVEL,251.0);
        Assert.assertEquals(expectedGroupedCategoriesAmount,actualGroupedCategoriesAmount);
    }
}