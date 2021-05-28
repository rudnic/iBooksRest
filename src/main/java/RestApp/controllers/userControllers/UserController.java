package RestApp.controllers.userControllers;

import RestApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceInterface userServiceInterface;
    @Autowired
    public UserController(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }

    /**
     * Получить пользователя по его ID GET-запросом
     * URI: /user/{id}
     * id - ID юзера
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable(name = "id") int id) {
        final User user = userServiceInterface.getUserByID(id);
        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Получить список всех юзеров
     */
    @GetMapping(value = "/")
    public List<User> getAllUsers() {
        return userServiceInterface.allUsers();
    }

    /**
     * Создать нового юзера
     * @param user - объект юзера
     */
    @PostMapping("/")
    public void addUser(@RequestBody User user) {
        userServiceInterface.createUser(user);
    }
}
