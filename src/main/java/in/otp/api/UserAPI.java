package in.otp.api;

import in.otp.service.UserService;

public class UserAPI {

    private UserService userService;

    public UserAPI() {
        this.userService = new UserService();
    }

    public String getUserDetails(String phoneNumber) {
        return userService.getUserDetails(phoneNumber);
    }
}
