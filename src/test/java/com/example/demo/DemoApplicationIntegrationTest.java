package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class DemoApplicationIntegrationTest {

    @Autowired
    private HelloController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
        String response = controller.hello();
        assertThat(response).isEqualTo("Hello, World!");
    }
}
