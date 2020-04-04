package spending;

public class TriggersUnusualSpendingEmail {

	private final PaymentService paymentService;
	private final EmailGateway emailGateway;

	public TriggersUnusualSpendingEmail(PaymentService paymentService, EmailGateway emailGateway) {
		this.paymentService = paymentService;
		this.emailGateway = emailGateway;
	}

	public void trigger(long userId) {
		PaymentsWithOverspending paymentsWithOverspending = this.paymentService.getPaymentsWithOverspending(userId);
		emailGateway.sendEmail(paymentsWithOverspending);
	}

}
