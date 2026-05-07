package dataBase;

import io.qameta.allure.Attachment;
import modelObject.BillPayModel;
import modelObject.RegisterModel;
import modelObject.RequestLoanModel;
import utils.LogUtility;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseQueries {

    private final DataBaseConnection dataBaseConnection;

    public DataBaseQueries() {
        dataBaseConnection = new DataBaseConnection();
    }

    public RegisterModel getRegisterData() {
        RegisterModel registerModel = new RegisterModel();
        String query = "SELECT * FROM register_data WHERE id = 1";
        try (PreparedStatement statement = dataBaseConnection.getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                registerModel.setFirstName(resultSet.getString("first_name"));
                registerModel.setLastName(resultSet.getString("last_name"));
                registerModel.setAddress(resultSet.getString("address"));
                registerModel.setCity(resultSet.getString("city"));
                registerModel.setState(resultSet.getString("state"));
                registerModel.setZipCode(resultSet.getString("zip_code"));
                registerModel.setPhone(resultSet.getString("phone"));
                registerModel.setSsn(resultSet.getString("ssn"));
                registerModel.setPassword(resultSet.getString("password"));
                LogUtility.infoLog("The user register data loaded from database: "
                        + registerModel.getFirstName() + " " + registerModel.getLastName());
                attachRegisterData(registerModel);
            }
        } catch (SQLException e) {
            LogUtility.errorLog("Database error on getRegisterData: " + e.getMessage());
        }
        return registerModel;
    }

    @Attachment(value = "Register Data from DB", type = "text/html")
    public String attachRegisterData(RegisterModel model) {
        return "<table border='1' cellpadding='5' cellspacing='0'>" +
                "<tr><th>Field</th><th>Value</th></tr>" +
                "<tr><td>First Name</td><td>" + model.getFirstName() + "</td></tr>" +
                "<tr><td>Last Name</td><td>" + model.getLastName() + "</td></tr>" +
                "<tr><td>Address</td><td>" + model.getAddress() + "</td></tr>" +
                "<tr><td>City</td><td>" + model.getCity() + "</td></tr>" +
                "<tr><td>State</td><td>" + model.getState() + "</td></tr>" +
                "<tr><td>Zip Code</td><td>" + model.getZipCode() + "</td></tr>" +
                "<tr><td>Phone</td><td>" + model.getPhone() + "</td></tr>" +
                "</table>";
    }

    public BillPayModel getBillPayData() {
        BillPayModel billPayModel = new BillPayModel();
        String query = "SELECT * FROM bill_pay_data WHERE id = 1";
        try (PreparedStatement statement = dataBaseConnection.getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                billPayModel.setPayeeName(resultSet.getString("payee_name"));
                billPayModel.setAddress(resultSet.getString("address"));
                billPayModel.setCity(resultSet.getString("city"));
                billPayModel.setState(resultSet.getString("state"));
                billPayModel.setZipCode(resultSet.getString("zip_code"));
                billPayModel.setPhone(resultSet.getString("phone"));
                billPayModel.setAccountNumber(resultSet.getString("account_number"));
                billPayModel.setVerifyAccount(resultSet.getString("verify_account"));
                billPayModel.setAmount(resultSet.getString("amount"));
                LogUtility.infoLog("The bill pay data loaded from database: "
                        + billPayModel.getPayeeName());
                attachBillPayData(billPayModel);
            }
        } catch (SQLException e) {
            LogUtility.errorLog("Database error on getBillPayData: " + e.getMessage());
        }
        return billPayModel;
    }

    @Attachment(value = "Bill Pay Data from DB", type = "text/html")
    public String attachBillPayData(BillPayModel model) {
        return "<table border='1' cellpadding='5' cellspacing='0'>" +
                "<tr><th>Field</th><th>Value</th></tr>" +
                "<tr><td>Payee Name</td><td>" + model.getPayeeName() + "</td></tr>" +
                "<tr><td>Address</td><td>" + model.getAddress() + "</td></tr>" +
                "<tr><td>City</td><td>" + model.getCity() + "</td></tr>" +
                "<tr><td>State</td><td>" + model.getState() + "</td></tr>" +
                "<tr><td>Zip Code</td><td>" + model.getZipCode() + "</td></tr>" +
                "<tr><td>Phone</td><td>" + model.getPhone() + "</td></tr>" +
                "<tr><td>Amount</td><td>" + model.getAmount() + "</td></tr>" +
                "</table>";
    }

    public RequestLoanModel getLoanData() {
        RequestLoanModel loanModel = new RequestLoanModel();
        String query = "SELECT * FROM loan_data WHERE id = 1";
        try (PreparedStatement statement = dataBaseConnection.getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                loanModel.setLoanAmount(resultSet.getString("loan_amount"));
                loanModel.setDownPayment(resultSet.getString("down_payment"));
                loanModel.setApprovedStatus(resultSet.getString("approved_status"));
                loanModel.setDeniedStatus(resultSet.getString("denied_status"));
                LogUtility.infoLog("The loan data loaded from database: amount="
                        + loanModel.getLoanAmount() + " downPayment=" + loanModel.getDownPayment());
                attachLoanData(loanModel);
            }
        } catch (SQLException e) {
            LogUtility.errorLog("Database error on getLoanData: " + e.getMessage());
        }
        return loanModel;
    }

    @Attachment(value = "Loan Data from DB", type = "text/html")
    public String attachLoanData(RequestLoanModel model) {
        return "<table border='1' cellpadding='5' cellspacing='0'>" +
                "<tr><th>Field</th><th>Value</th></tr>" +
                "<tr><td>Loan Amount</td><td>" + model.getLoanAmount() + "</td></tr>" +
                "<tr><td>Down Payment</td><td>" + model.getDownPayment() + "</td></tr>" +
                "<tr><td>Approved Status</td><td>" + model.getApprovedStatus() + "</td></tr>" +
                "<tr><td>Denied Status</td><td>" + model.getDeniedStatus() + "</td></tr>" +
                "</table>";
    }
}