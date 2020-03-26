package ch.kup.messages.assertj;

import ch.kup.messages.Message;
import ch.kup.messages.Severity;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageTest {

    @Test
    void test() {
        var messages = Arrays.asList(
                new Message(Severity.INFO, "All ok"),
                new Message(Severity.ERROR, "A problem")
        );

        assertThat(messages).extracting(Message::getSeverity)
                .contains(Severity.INFO)
                .contains(Severity.ERROR)
                .doesNotContain(Severity.WARN);
        assertThat(messages).filteredOn(m -> m.getText().contains("problem"))
                .isNotEmpty();
    }

}
