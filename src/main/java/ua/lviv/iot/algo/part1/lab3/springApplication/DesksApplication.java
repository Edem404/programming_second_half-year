package ua.lviv.iot.algo.part1.lab3.springApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "ua.lviv.iot.algo.part1.lab3")
@SpringBootApplication
public class DesksApplication {
    public static void main(String[] args) {
        SpringApplication.run(DesksApplication.class, args);
    }
}
