package in.otp.repository;

import in.otp.config.AppConfig;
import in.otp.model.User;

import java.sql.*;
import java.util.Optional;

public class UserRepository {

    
    public boolean save(User user) {
        String query = "INSERT INTO users (phone_number, fingerprint) VALUES (?, ?)";
        try (Connection connection = AppConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getPhoneNumber());
            stmt.setString(2, user.getFingerprint());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;  
        } catch (SQLException e) {
            System.err.println("Error saving user: " + e.getMessage());
        }
        return false;  
    }

    public Optional<String> findByPhoneNumber(String phoneNumber) {
        String query = "SELECT fingerprint FROM users WHERE phone_number = ?";
        try (Connection connection = AppConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, phoneNumber);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(rs.getString("fingerprint"));
            }
        } catch (SQLException e) {
            System.err.println("Error finding user: " + e.getMessage());
        }
        return Optional.empty();  
    }
}
