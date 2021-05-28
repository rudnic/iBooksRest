package RestApp.controllers.userControllers;

import RestApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInterface {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean createUser(User user) {
        // запись в БД
        if (user == null) { return false; }
        userRepository.save(user);
        return true;
    }

    @Override
    public List<User> allUsers() {
        // возврат из БД
        return userRepository.findAll();
    }

    @Override
    public User getUserByID(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public boolean updateUserByID(User user, int id) {
        return false;
    }

    @Override
    public boolean deleteUserByID(int id) {
        return false;
    }
}
