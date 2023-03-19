package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertEquals("unit test", "unit test");
        Assertions.assertEquals(5, 5);
        System.out.println("UNIT TESTS OK");
    }

}
