package in.otp.service;
import in.otp.model.OTP;
import in.otp.util.DatabaseUtils;

public class OTPService {

    public boolean isOTPValid(String phoneNumber, String otp) {
        OTP storedOTP = DatabaseUtils.getOTP(phoneNumber);
        return storedOTP != null && storedOTP.getOtpCode().equals(otp) && storedOTP.getExpiryTime() > System.currentTimeMillis();
    }

    public String resendOTP(String phoneNumber) {
        
        String newOtp = String.valueOf((int) (Math.random() * 10000));
        long expiryTime = System.currentTimeMillis() + 300000; 
        OTP newOTP = new OTP(phoneNumber, newOtp, expiryTime);
        DatabaseUtils.saveOTP(newOTP);

        
        System.out.println("OTP sent to " + phoneNumber + ": " + newOtp);

        return "OTP has been resent successfully!";
    }
}
