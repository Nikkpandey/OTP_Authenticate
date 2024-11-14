package in.otp.api;

import in.otp.service.OTPService;
import in.otp.service.DeviceService;

public class LoginAPI {

    private OTPService otpService;
    private DeviceService deviceService;

    public LoginAPI() {
        this.otpService = new OTPService();
        this.deviceService = new DeviceService();
    }

    public String loginUser(String phoneNumber, String otp, String fingerprint) {
        if (otpService.isOTPValid(phoneNumber, otp)) {
            boolean isDeviceValid = deviceService.verifyFingerprint(phoneNumber, fingerprint);
            if (isDeviceValid) {
                return "Login successful!";
            } else {
                return "Device fingerprint mismatch!";
            }
        } else {
            return "Invalid or expired OTP!";
        }
    }

    public String resendOTP(String phoneNumber) {
        return otpService.resendOTP(phoneNumber);
    }
}
