package com.minton.springbootdemo2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringbootDemo2ApplicationTests {

    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        System.out.println("hello springboot!");
        System.out.println(applicationContext);
    }
}
