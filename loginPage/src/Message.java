public abstract class Message {
    protected ILogin login;
    protected String sender;
    protected String receiver;
    protected String content;

    public Message(ILogin login, String sender, String receiver, String content) {
        this.login = login;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    public abstract void send(String username, String password);
}