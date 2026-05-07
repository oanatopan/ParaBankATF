package dataBase;

import modelObject.BillPayModel;
import modelObject.RegisterModel;
import modelObject.RequestLoanModel;

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
        try {
            PreparedStatement statement = dataBaseConnection.getConnection().prepareStatement(query);
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
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return registerModel;
    }

    public BillPayModel getBillPayData() {
        BillPayModel billPayModel = new BillPayModel();
        String query = "SELECT * FROM bill_pay_data WHERE id = 1";
        try {
            PreparedStatement statement = dataBaseConnection.getConnection().prepareStatement(query);
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
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return billPayModel;
    }

    public RequestLoanModel getLoanData() {
        RequestLoanModel loanModel = new RequestLoanModel();
        String query = "SELECT * FROM loan_data WHERE id = 1";
        try {
            PreparedStatement statement = dataBaseConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                loanModel.setLoanAmount(resultSet.getString("loan_amount"));
                loanModel.setDownPayment(resultSet.getString("down_payment"));
                loanModel.setApprovedStatus(resultSet.getString("approved_status"));
                loanModel.setDeniedStatus(resultSet.getString("denied_status"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return loanModel;
    }
}