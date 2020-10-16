package co.uk.netpod.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
     //   System.setProperty("spring.application.name", "mongo-docker-service");
        SpringApplication.run(Application.class, args);
    }
}
