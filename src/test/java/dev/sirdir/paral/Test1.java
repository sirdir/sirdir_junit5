package dev.sirdir.paral;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

public class Test1 extends BaseParallel {

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void test1_1() {
        logMe(this.getClass());
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void test1_2() {
        logMe(this.getClass());
    }

    @Execution(ExecutionMode.CONCURRENT)
    @Test
    void test1_3() {
        logMe(this.getClass());
    }
}
