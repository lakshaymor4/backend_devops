package ir.bigz.springboot.fullstack_backend.user;

import ir.bigz.springboot.fullstack_backend.common.UserNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public void newUser(User newUser) {
        userRepository.save(newUser);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserById(User user, Long userId){
        User userById = getUserById(userId);
        userById.setName(user.getName());
        userById.setEmail(user.getEmail());
        userById.setUsername(user.getUsername());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUserById(Long userId) {
        if(!userRepository.existsById(userId)) {
            throw new UserNotFoundException(userId);
        }
        userRepository.deleteById(userId);
    }
}
