package org.polycham.litnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.neo4j.repository.config.EnableReactiveNeo4jRepositories;


@SpringBootApplication(scanBasePackages = "controllers")
@EnableReactiveNeo4jRepositories(basePackages = "model")
@Import(AppConfig.class)
public class LitnetApp {
    public static void main(String[] args) {
        SpringApplication.run(LitnetApp.class, args);
    }

}

