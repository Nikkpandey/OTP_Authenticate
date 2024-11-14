package in.otp.service;

import in.otp.model.User;
import in.otp.repository.UserRepository;
import java.util.Optional;

public class UserService {

    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    // Correct the save method call to pass the entire User object
    public boolean createAccount(User user) {
        return userRepository.save(user);  // Pass the entire user object
    }

    public String getUserDetails(String phoneNumber) {
        Optional<String> fingerprint = userRepository.findByPhoneNumber(phoneNumber);
        if (fingerprint.isPresent()) {
            return "User details: Phone: " + phoneNumber + ", Fingerprint: " + fingerprint.get();
        }
        return "User not found!";
    }
}
