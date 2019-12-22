package dev.sirdir.lifecycle;

import java.util.Random;

public abstract class BaseLifeCycleTest {

    int randomValue = new Random().nextInt();


    /**
     * just to check if random number will be the same for:
     * <p>
     * PER_CLASS life cycle (must stay same)
     * <p>
     * PER_CLASS life cycle (must change for each test)
     */
    void logMe() {
        System.out.println("--------------");
        System.out.format("%d %s %d", Thread.currentThread().getId(), this.getClass().getSimpleName(), randomValue);
        System.out.println();
        System.out.println();
    }

}
