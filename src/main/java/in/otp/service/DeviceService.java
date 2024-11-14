package in.otp.service;
import in.otp.util.FingerprintUtil;

public class DeviceService {

    public boolean verifyFingerprint(String phoneNumber, String fingerprint) {
        String storedFingerprint = FingerprintUtil.getStoredFingerprint(phoneNumber);
        return storedFingerprint != null && storedFingerprint.equals(fingerprint);
    }

    
    public void saveFingerprint(String phoneNumber, String fingerprint) {
        FingerprintUtil.saveFingerprint(phoneNumber, fingerprint);
    }
}
