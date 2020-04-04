package spending;

public class PaymentsWithOverspending {
    int totalAmount;

    public PaymentsWithOverspending(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentsWithOverspending that = (PaymentsWithOverspending) o;

        return totalAmount == that.totalAmount;
    }

    @Override
    public int hashCode() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
