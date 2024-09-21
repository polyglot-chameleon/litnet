package org.polycham.litnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = { "controllers", "db", "db.model" })
@Import(AppConfig.class)
public class LitnetApp {
    public static void main(String[] args) {
        SpringApplication.run(LitnetApp.class, args);
    }
}
