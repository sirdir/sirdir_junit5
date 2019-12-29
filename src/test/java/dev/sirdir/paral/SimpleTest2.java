package dev.sirdir.paral;

public class SimpleTest2 extends BaseParallel {

    @TestParallel
    void test2_1() {
        logMe(this.getClass());
    }

    @TestParallel
    void test2_2() {
        logMe(this.getClass());
    }

    @TestParallel
    void test2_3() {
        logMe(this.getClass());
    }
}
