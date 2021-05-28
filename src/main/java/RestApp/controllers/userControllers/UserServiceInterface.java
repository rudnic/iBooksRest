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
     * @param user - объект юзера
     * @param id - ID юзера
     * @return - true/false
     */
    boolean updateUserByID(User user, int id);

    /**
     * Удаление юзера по ID
     * @param id - ID юзера
     * @return tru/false
     */
    boolean deleteUserByID(int id);
}
