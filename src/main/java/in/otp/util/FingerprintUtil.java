package in.otp.util;

import java.util.HashMap;
import java.util.Map;

public class FingerprintUtil {

    private static Map<String, String> fingerprintDatabase = new HashMap<>();

    public static String getStoredFingerprint(String phoneNumber) {
        return fingerprintDatabase.get(phoneNumber);
    }

    public static void saveFingerprint(String phoneNumber, String fingerprint) {
        fingerprintDatabase.put(phoneNumber, fingerprint);
    }
}
