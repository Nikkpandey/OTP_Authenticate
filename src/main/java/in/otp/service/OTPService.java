package in.otp.service;

import in.otp.model.OTP;
import in.otp.util.DatabaseUtils;

public class OTPService {

    public boolean isOTPValid(String phoneNumber, String otp) {
        OTP storedOTP = DatabaseUtils.getOTP(phoneNumber);
        return storedOTP != null && storedOTP.getOtpCode().equals(otp) && storedOTP.getExpiryTime() > System.currentTimeMillis();
    }

    public String resendOTP(String phoneNumber) {
        // Generate a new OTP and store it
        String newOtp = String.format("%04d", (int) (Math.random() * 10000)); // Generates a 4-digit OTP
        long expiryTime = System.currentTimeMillis() + 300000; // 5 minutes expiry
        OTP newOTP = new OTP(phoneNumber, newOtp, expiryTime);
        DatabaseUtils.saveOTP(newOTP);
        
        // Simulating sending OTP to the mobile number
        simulateSendOTPToMobile(phoneNumber, newOtp);

        return "New OTP sent to your mobile: " + newOtp;
    }

    private void simulateSendOTPToMobile(String phoneNumber, String otp) {
        // Simulate the action of sending OTP to mobile (can be replaced with actual SMS API logic)
        System.out.println("Simulating sending OTP: " + otp + " to mobile number: " + phoneNumber);
    }
}
