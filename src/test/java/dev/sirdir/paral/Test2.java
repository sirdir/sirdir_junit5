package dev.sirdir.paral;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

public class Test2 extends BaseParallel {

    @Execution(ExecutionMode.CONCURRENT)
    @Test
    void test2_1() {
        logMe(this.getClass());
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void test2_2() {
        logMe(this.getClass());
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void test2_3() {
        logMe(this.getClass());
    }
}
