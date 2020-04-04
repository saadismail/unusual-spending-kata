package spending;

import org.junit.Test;

public class TriggersUnusualPaymentEmailTest {

    @Test
    public void triggerTest() {
        TriggersUnusualSpendingEmail triggersUnusualSpendingEmail = new TriggersUnusualSpendingEmail();
        triggersUnusualSpendingEmail.trigger(123);
    }



}
