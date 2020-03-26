package ch.kup.messages.hamcrest;

import ch.kup.messages.Message;
import ch.kup.messages.Severity;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static ch.kup.messages.hamcrest.MessageMatcher.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MessageTest {

    @Test
    void test() {
        var messages = Arrays.asList(
                new Message(Severity.INFO, "All ok"),
                new Message(Severity.ERROR, "A problem")
        );

        assertThat(messages, hasItem(is(infoMessage())));
        assertThat(messages, hasItem(messageWithSeverity(Severity.ERROR)));
        assertThat(messages, not(hasItem(messageWithSeverity(Severity.WARN))));
        assertThat(messages, hasItem(messageWithText(containsString("problem"))));
    }

}
