package dev.sirdir.paral;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@TestInstance(Lifecycle.PER_CLASS)
/*
test classes that use the Lifecycle.PER_CLASS mode,
test methods in such test classes are only executed concurrently
if the @Execution(CONCURRENT) annotation is present on the test class or method.
 */
//@Execution(ExecutionMode.CONCURRENT)
public abstract class BaseParallel {

    public Map<String, Long> methodMap = new ConcurrentHashMap<>();
    public Map<String, Long> cycleMethodMap = new ConcurrentHashMap<>();
    public static AtomicInteger counterBA = new AtomicInteger(0);
    public static AtomicInteger counterBE = new AtomicInteger(0);
    public static AtomicInteger counterAA = new AtomicInteger(0);
    public static AtomicInteger counterAE = new AtomicInteger(0);

    public static final long start = System.nanoTime();

    @BeforeAll
    public void setUp() {
        counterBA.incrementAndGet();
        logMe("setUp_"+ counterBA.get());
    }

    @BeforeEach
    public void beforeEach() {
        counterBE.incrementAndGet();
        logMe("beforeEach_" + counterBE.get());
    }

    @AfterEach
    public void afterEach() {
        counterAE.incrementAndGet();
        logMe("afterEach_"+ counterAE.get());
    }

    @AfterAll
    public void tearDown() {
        counterAA.incrementAndGet();
        logMe("tearDown_" + counterAA.get());
        methodMap.forEach((k, v) -> {System.out.print(k); System.out.print(" = ");System.out.println(v);});
        cycleMethodMap.forEach((k, v) -> {System.out.print(k); System.out.print(" = ");System.out.println(v);});
        System.out.format("counterBA=%d", counterBA.get());
        System.out.println();
        System.out.format("counterBE=%d", counterBE.get());
        System.out.println();
        System.out.format("counterAE=%d", counterAE.get());
        System.out.println();
        System.out.format("counterAA=%d", counterAA.get());
//        System.out.println(cycleMethodMap);
    }
//
//    void logMe(Class<? extends BaseParallel> xca) {
//        System.out.println("--------------");
//        System.out.format("%d %s, %s %d", Thread.currentThread().getId(), xca.getSimpleName(), Thread.currentThread().getStackTrace()[2].getMethodName(), System.nanoTime());
//        System.out.println();
//        System.out.println();
//    }
//
//    static void logMe(String methodName) {
//        System.out.println("--------------");
//        System.out.format("%d %s %d", Thread.currentThread().getId(), methodName, System.nanoTime());
//        System.out.println();
//        System.out.println();
//    }

    void logMe(Class<? extends BaseParallel> xca) {
        System.out.println(Thread.currentThread().getStackTrace()[2].getMethodName() + " delta " + (System.nanoTime() - start) + " " + Thread.currentThread().getId());
        methodMap.put(Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getId());
    }

    void logMe(String methodName) {
        cycleMethodMap.put(methodName, Thread.currentThread().getId());
    }
}
