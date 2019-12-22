package dev.sirdir.lifecycle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_METHOD)
public class PerMethod extends BaseLifeCycleTest {

    @Test
    void test1() {
        logMe();
    }

    @Test
    void test2() {
        logMe();

    }

    @Test
    void test3() {
        logMe();
    }
}
