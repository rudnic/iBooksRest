package RestApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

// TODO: необходимо придумать способ связывания книг и авторов (idea: Передавать в RequestBody Map<Author, Book>
