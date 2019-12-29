package dev.sirdir.paral;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

public class SimpleTest1 extends BaseParallel {

    @TestParallel
    void test1_1() {
        logMe(this.getClass());
    }

    @TestParallel
    void test1_2() {
        logMe(this.getClass());
    }

    @TestParallel
    void test1_3() {
        logMe(this.getClass());
    }
}
