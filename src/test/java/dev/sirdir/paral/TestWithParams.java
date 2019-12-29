package dev.sirdir.paral;

import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestWithParams extends BaseParallel {


    private static Stream<Integer> lol() {
        return Stream.of(1, 2, 3, 4);
    }
    @TestParallelParams
    @MethodSource("lol")
    void test2_3(int i) {
        logMe(this.getClass());
    }
}
