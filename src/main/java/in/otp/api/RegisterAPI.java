package in.otp.api;

import in.otp.model.User;
import in.otp.service.DeviceService;
import in.otp.service.UserService;

public class RegisterAPI {

    private UserService userService;
    private DeviceService deviceService;

    public RegisterAPI() {
        this.userService = new UserService();
        this.deviceService = new DeviceService();
    }

    public String registerUser(String phoneNumber, String fingerprint) {
        User newUser = new User(phoneNumber, fingerprint);
        boolean isRegistered = userService.createAccount(newUser);
        if (isRegistered) {
            
            deviceService.saveFingerprint(phoneNumber, fingerprint);
            return "Account created successfully!";
        } else {
            return "Failed to create account. User might already exist.";
        }
    }
}
