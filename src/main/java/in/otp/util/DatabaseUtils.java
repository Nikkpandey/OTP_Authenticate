package in.otp.util;

import in.otp.model.User;
import in.otp.model.OTP;

import java.util.HashMap;
import java.util.Map;

public class DatabaseUtils {

    private static Map<String, User> userDatabase = new HashMap<>();
    private static Map<String, OTP> otpDatabase = new HashMap<>();

    public static boolean saveUser(User user) {
        userDatabase.put(user.getPhoneNumber(), user);
        return true;
    }

    public static User getUser(String phoneNumber) {
        return userDatabase.get(phoneNumber);
    }

    public static void saveOTP(OTP otp) {
        otpDatabase.put(otp.getPhoneNumber(), otp);
    }

    public static OTP getOTP(String phoneNumber) {
        return otpDatabase.get(phoneNumber);
    }
}
