package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class LoginModel {

    private String invalidUsername;
    private String invalidPassword;

    public LoginModel(String filePath) {
        loadFromJson(filePath);
    }

    private void loadFromJson(String filePath) {
        try (InputStream inputStream =
                     getClass().getClassLoader().getResourceAsStream(filePath)) {
            if (inputStream == null) {
                throw new RuntimeException("File not found in resources: " + filePath);
            }
            new ObjectMapper().readerForUpdating(this).readValue(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load LoginModel from: " + filePath, e);
        }
    }

    public String getInvalidUsername() { return invalidUsername; }
    public void setInvalidUsername(String invalidUsername) { this.invalidUsername = invalidUsername; }

    public String getInvalidPassword() { return invalidPassword; }
    public void setInvalidPassword(String invalidPassword) { this.invalidPassword = invalidPassword; }
}