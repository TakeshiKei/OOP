public class EmailMessage extends Message {
    public EmailMessage(ILogin login, String sender, String receiver, String content) {
        super(login, sender, receiver, content);
    }
    @Override
    public void send(String username, String password) {
        if(login.authenticate(username, password)){
            System.out.println("Email sent from " + sender + " to " + receiver + ": " + content);
        }else{
            System.out.println("Email authentication failed for user: " + username);
        }
    }
}
