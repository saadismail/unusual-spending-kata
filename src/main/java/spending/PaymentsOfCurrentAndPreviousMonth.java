package spending;

import java.util.List;

public class PaymentsOfCurrentAndPreviousMonth {

    List<Payment> currentMonth;
    List<Payment> previousMonth;

    public void setCurrentMonth(List<Payment> currentMonth) {
        this.currentMonth = currentMonth;
    }

    public void setPreviousMonth(List<Payment> previousMonth) {
        this.previousMonth = previousMonth;
    }

    public int getPreviousMonthTotal() {
        return previousMonth.stream().mapToInt(Payment::getPrice).sum();
    }

    public int getCurrentMonthTotal() {
        return currentMonth.stream().mapToInt(Payment::getPrice).sum();
    }
}
