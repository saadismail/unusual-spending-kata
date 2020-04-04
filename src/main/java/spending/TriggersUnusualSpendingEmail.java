package spending;

import java.util.List;

public class TriggersUnusualSpendingEmail {

	public void trigger(long userId) {
		assert(userId>=0);
		List<Payment> lastMonthPayments = FetchesUserPaymentsByMonth.fetch(userId,2020,2);
		List<Payment> currentMonthPayments = FetchesUserPaymentsByMonth.fetch(userId,2020,3);
		List<Payment> unusualPayments = DetectUnusualSpending.detect(lastMonthPayments,currentMonthPayments);
		String emailContent = EmailGenerator.generateUnusualPaymentEmail(userId, unusualPayments);
		EmailSender.send(userId, emailContent);
	}

}
