package in.otp.model;

public class OTP {
    private String phoneNumber;
    private String otpCode;
    private long expiryTime;

    public OTP(String phoneNumber, String otpCode, long expiryTime) {
        this.phoneNumber = phoneNumber;
        this.otpCode = otpCode;
        this.expiryTime = expiryTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getOtpCode() {
        return otpCode;
    }

    public long getExpiryTime() {
        return expiryTime;
    }
}
