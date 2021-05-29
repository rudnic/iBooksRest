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
        if (user == null) { return false; }
        userRepository.save(user);
        return true;
    }

    @Override
    public List<User> allUsers() { return userRepository.findAll(); }

    @Override
    public User getUserByID(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public boolean updateUser(int id, User user) {
        User userS = userRepository.findById(id).get();
        userS.setPassword(user.getPassword());
        userS.setEmail(user.getEmail());
        userRepository.save(userS);
        return true;
    }

    @Override
    public boolean deleteUserByID(int id) {
        userRepository.deleteById(id);
        return true;
    }

}
