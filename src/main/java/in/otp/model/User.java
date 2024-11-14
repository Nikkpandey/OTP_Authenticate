package in.otp.model;

public class User {
    private String phoneNumber;
    private String fingerprint;

    public User(String phoneNumber, String fingerprint) {
        this.phoneNumber = phoneNumber;
        this.fingerprint = fingerprint;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFingerprint() {
        return fingerprint;
    }
}
