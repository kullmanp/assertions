package ch.kup.messages;

public class Message {
    private Severity severity;
    private String text;

    public Message(Severity severity, String text) {
        this.severity = severity;
        this.text = text;
    }

    public Severity getSeverity() {
        return severity;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "severity=" + severity +
                ", text='" + text + '\'' +
                '}';
    }
}
