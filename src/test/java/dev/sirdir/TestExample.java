package dev.sirdir;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class TestExample {

    @ParameterizedTest
    @ValueSource(strings = "Hello world")
    void helloWorld(String textExpected) {
        String helloWorldActual = "Hello world";
        assertEquals(textExpected, helloWorldActual);
    }

    @Test
    void assumeFails() {
        assumeTrue(false);
        assumeTrue(true);
    }

    @Test
    void assumePass() {
        assumeTrue(true);
    }

    @Test
    void assumePassButTestFails() {
        assumeTrue(true);
        assert 1 > 2 : "some old fashion java assertion fail";
    }

    @Test
    @Disabled
    void someDisabledTestToSeeItInReport() {
        //ignored
    }

    @Test
    @Disabled("nice feature, but not working with gradle, https://github.com/gradle/gradle/issues/4605")
    void reportSingleValue(TestReporter testReporter) {
        testReporter.publishEntry("xuy");
        Map<String, String> map = new HashMap<>();
        map.put("xuy", "xuy");
        testReporter.publishEntry(map);
    }
}
