package spending;

import sun.jvm.hotspot.utilities.Assert;

import java.util.List;

public class TriggersUnusualSpendingEmail {

	public void trigger(long userId) {
		// TODO: This is the entry point. Start with a test of this class
		assert(userId>=0);
		List<Payment> lastMonthPayments = FetchesUserPaymentsByMonth.fetch(userId,2020,2);
		List<Payment> currentMonthPayments = FetchesUserPaymentsByMonth.fetch(userId,2020,3);
		List<Payment> unusualPayments = DetectUnusualSpendings.detect(lastMonthPayments,currentMonthPayments);
		String emailContent = EmailGenerator.generateUnusualPaymentEmail(unusualPayments);
		EmailSender.send(emailContent);
	}

}
