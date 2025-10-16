package se.ju23.typespeeder.service;

import se.ju23.typespeeder.data.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserService() {
        this(new UserRepository());
    }

    public boolean registerUser(String username, String password) {
        if (userRepository.findByUsername(username) != null) {
            return false; // redan registrerad
        }
        User user = new User(username, password);
        userRepository.save(user);
        return true;
    }

    public boolean loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return false;
        }
        return user.checkPassword(password);
    }
}
