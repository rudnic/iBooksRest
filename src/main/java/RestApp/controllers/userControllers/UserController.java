package RestApp.controllers.userControllers;

import RestApp.models.User;
import com.fasterxml.jackson.databind.ser.std.RawSerializer;
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
     * URI: /users/{id}
     * Method: GET
     * @param id - id юзера
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
     * URI: /users/
     * Method: GET
     */
    @GetMapping(value = "/")
    public List<User> getAllUsers() {
        return userServiceInterface.allUsers();
    }

    /**
     * Создать нового юзера
     * URI: /users/
     * Method: POST
     * @param user - объект юзера
     */
    @PostMapping("/")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userServiceInterface.createUser(user), HttpStatus.OK);
    }

    /**
     * Удалить юзера по его ID
     * URI: /users/{id}
     * Method: DELETE
     * @param id - id юзера
     */
    @DeleteMapping(value = "/{id}/")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "id") int id) {
        return new ResponseEntity<>(userServiceInterface.deleteUserByID(id), HttpStatus.OK);
    }

    /**
     * Обновить информацию о юзере
     * URI: /users/
     * Method: PUT
     * @param id - id юзера
     * @param user - юзер с новыми полями
     */
    @PutMapping(value = "/{id}/")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable(name = "id") int id) {
        return new ResponseEntity<>(userServiceInterface.updateUser(id, user), HttpStatus.OK);
    }

}
