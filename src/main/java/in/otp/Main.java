package in.otp;

import in.otp.api.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static RegisterAPI registerAPI;
    private static LoginAPI loginAPI;
    private static UserAPI userAPI;
    
    public static void main(String[] args) {
        registerAPI = new RegisterAPI();
        loginAPI = new LoginAPI();
        userAPI = new UserAPI();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("\nSelect an option:");
                System.out.println("1. Register a new account");
                System.out.println("2. Login using OTP");
                System.out.println("3. Resend OTP");
                System.out.println("4. Get current user details");
                System.out.println("5. Exit");

                String choice = reader.readLine().trim();

                switch (choice) {
                    case "1":
                        registerAccount(reader);
                        break;
                    case "2":
                        loginUser(reader);
                        break;
                    case "3":
                        resendOTP(reader);
                        break;
                    case "4":
                        getUserDetails(reader);
                        break;
                    case "5":
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice! Please select again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void registerAccount(BufferedReader reader) throws Exception {
        System.out.println("Enter mobile number:");
        String phoneNumber = reader.readLine().trim();

        System.out.println("Enter device fingerprint:");
        String fingerprint = reader.readLine().trim();

        String response = registerAPI.registerUser(phoneNumber, fingerprint);
        System.out.println(response);
    }

    private static void loginUser(BufferedReader reader) throws Exception {
        System.out.println("Enter mobile number:");
        String phoneNumber = reader.readLine().trim();

        System.out.println("Enter OTP:");
        String otp = reader.readLine().trim();

        System.out.println("Enter device fingerprint:");
        String fingerprint = reader.readLine().trim();

        String response = loginAPI.loginUser(phoneNumber, otp, fingerprint);
        System.out.println(response);
    }

    private static void resendOTP(BufferedReader reader) throws Exception {
        System.out.println("Enter mobile number to resend OTP:");
        String phoneNumber = reader.readLine().trim();

        String response = loginAPI.resendOTP(phoneNumber);
        System.out.println(response);
    }

    private static void getUserDetails(BufferedReader reader) throws Exception {
        System.out.println("Enter mobile number to fetch user details:");
        String phoneNumber = reader.readLine().trim();

        String response = userAPI.getUserDetails(phoneNumber);
        System.out.println(response);
    }
}
