package in.otp.service;

import in.otp.model.User;
import in.otp.repository.UserRepository;

import java.util.Optional;

public class UserService {

    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public boolean createAccount(User user) {
        return userRepository.save(user.getPhoneNumber(), user.getFingerprint());
    }

    public String getUserDetails(String phoneNumber) {
        Optional<String> fingerprint = userRepository.findByPhoneNumber(phoneNumber);
        if (fingerprint.isPresent()) {
            return "User details: Phone: " + phoneNumber + ", Fingerprint: " + fingerprint.get();
        }
        return "User not found!";
    }
}
