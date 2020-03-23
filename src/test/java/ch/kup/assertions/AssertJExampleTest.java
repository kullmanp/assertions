package ch.kup.assertions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExampleTest {

    @Test
    void simpleAssertion() {
        var s = "Hello World";
        assertThat(s).startsWith("Hello");
    }

}
