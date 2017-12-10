package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class testCaseTest {
    @Test
    void factorial() throws Exception {
        assertEquals(120, new testCase().factorial(5));
    }

    @Test
    void fibonacci() throws Exception {
        assertEquals(21, new testCase().fibonacci(9));
    }

}