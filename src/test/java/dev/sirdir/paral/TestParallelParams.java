package dev.sirdir.paral;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ParameterizedTest
@Execution(ExecutionMode.CONCURRENT)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestParallelParams {
}
