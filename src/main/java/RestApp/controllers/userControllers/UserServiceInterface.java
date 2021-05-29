package RestApp.controllers.userControllers;

import RestApp.models.User;

import java.util.List;

public interface UserServiceInterface {
    /**
     * Создание нового юзера
     * @param user - объект-пользователь
     */
    boolean createUser(User user);

    /**
     * Возвращение списка всех юзеров
     * @return список юзеров
     */
    List<User> allUsers();

    /**
     * Возвращение юзера по его ID
     * @param id - ID юзера
     * @return - объект юзера
     */
    User getUserByID(int id);

    /**
     * Обновление данных пользователя по ID
     * @param id - id юзера
     * @param user - объект юзера
     * @return - true/false
     */
    boolean updateUser(int id, User user);

    /**
     * Удаление юзера по ID
     * @param id - ID юзера
     * @return tru/false
     */
    boolean deleteUserByID(int id);

}
