package ch.kup.assertions;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.CharSequenceLength.hasLength;

public class HamcrestExampleTest {

    @Test
    void simpleAssertion() {
        var s = "Hello World";
        assertThat(s, startsWith("Hello"));
        assertThat(s, hasLength(11));
    }
}
