package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class RequestLoanModel {

    private String loanAmount;
    private String downPayment;
    private String approvedStatus;
    private String deniedStatus;

    public RequestLoanModel(String filePath) {
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
            throw new RuntimeException("Failed to load RequestLoanModel from: " + filePath, e);
        }
    }

    public String getLoanAmount() { return loanAmount; }
    public void setLoanAmount(String loanAmount) { this.loanAmount = loanAmount; }

    public String getDownPayment() { return downPayment; }
    public void setDownPayment(String downPayment) { this.downPayment = downPayment; }

    public String getApprovedStatus() { return approvedStatus; }
    public void setApprovedStatus(String approvedStatus) { this.approvedStatus = approvedStatus; }

    public String getDeniedStatus() { return deniedStatus; }
    public void setDeniedStatus(String deniedStatus) { this.deniedStatus = deniedStatus; }
}