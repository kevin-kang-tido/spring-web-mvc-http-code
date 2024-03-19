package co.istad.diresource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiResourceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DiResourceApplication.class, args);

    }
    @Value("${spring.application.name}")
    private  String appName;

    @Value("${server.port}")
    private  Integer appPort;

    @Value("${user.username}")
    private  String username;

    @Value("${user.first-name}")
    private  String myName;



    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>> Spring boot server: ");
        System.out.println("-----------------------------");

        System.out.println(appName);
        System.out.println(appPort);
        System.out.println(username);
        System.out.println(myName);

        System.out.println("-----------------------------");

    }
}
