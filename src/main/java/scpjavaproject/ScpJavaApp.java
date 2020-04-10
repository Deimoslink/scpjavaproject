package scpjavaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ScpJavaApp {

    public static void main(String[] args) {
        SpringApplication.run(ScpJavaApp.class, args);
    }

}
