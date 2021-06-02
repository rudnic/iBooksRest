package RestApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        // TODO: Попробовать прописать апи для показа авторов книг
        // TODO: Тесты: вроде всё работает
        // TODO: попробовать внедрить пользовательские посты
    }
}

