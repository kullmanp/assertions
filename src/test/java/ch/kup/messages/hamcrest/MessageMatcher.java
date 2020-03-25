package ch.kup.messages.hamcrest;

import ch.kup.messages.Message;
import ch.kup.messages.Severity;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.Matchers.is;

public class MessageMatcher extends TypeSafeMatcher<Message> {
    private Matcher<Severity> severityMatcher;
    private Matcher<String> textMatcher;

    public MessageMatcher(Matcher<Severity> severityMatcher, Matcher<String> textMatcher) {
        this.severityMatcher = severityMatcher != null ? severityMatcher : any(Severity.class);
        this.textMatcher = textMatcher != null ? textMatcher : any(String.class);
    }

    @Override
    protected boolean matchesSafely(Message message) {
        return severityMatcher.matches(message.getSeverity()) &&
                textMatcher.matches(message.getText());
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("message with severity ")
                .appendDescriptionOf(severityMatcher)
                .appendText(" and text ")
                .appendDescriptionOf(textMatcher);
    }

    public static MessageMatcher infoMessage() {
        return messageWithSeverity(Severity.INFO);
    }

    public static MessageMatcher messageWithSeverity(Severity severity) {
        return new MessageMatcher(is(severity), null);
    }

    public static MessageMatcher messageWithText(Matcher<String> textMatcher) {
        return new MessageMatcher(null, textMatcher);
    }

}
