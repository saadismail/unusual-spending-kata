package spending;

import org.junit.Test;

public class TriggersUnusualSpendingEmailTest {

    @Test
    public void triggerTest() {

    }

    @Test(expected = AssertionError.class)
    public void triggerTestNegativeUserId(){
        TriggersUnusualSpendingEmail triggersUnusualSpendingEmail = new TriggersUnusualSpendingEmail();
        triggersUnusualSpendingEmail.trigger(-1);
    }



}
