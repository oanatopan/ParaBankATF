package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class FindTransactionsModel {

    private String activityPeriod;
    private String transactionType;
    private String expectedTitle;

    public FindTransactionsModel(String filePath) {
        loadFromJson(filePath);
    }

    private void loadFromJson(String filePath) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            if (inputStream == null) {
                throw new RuntimeException("File not found in resources: " + filePath);
            }
            new ObjectMapper().readerForUpdating(this).readValue(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load FindTransactionsModel from: " + filePath, e);
        }
    }

    public String getActivityPeriod() {
        return activityPeriod;
    }

    public void setActivityPeriod(String activityPeriod) {
        this.activityPeriod = activityPeriod;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getExpectedTitle() {
        return expectedTitle;
    }

    public void setExpectedTitle(String expectedTitle) {
        this.expectedTitle = expectedTitle;
    }
}