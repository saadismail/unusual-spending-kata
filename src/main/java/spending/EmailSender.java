package spending;

public class EmailSender {
    public static void send(long userId, String emailContent) {
        System.out.println("Email sent to " + userId);
        System.out.println("Email Content:\n" + emailContent);
    }
}
