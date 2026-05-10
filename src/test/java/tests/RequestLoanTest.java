package tests;

import dataBase.DataBaseQueries;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import modelObject.RegisterModel;
import modelObject.RequestLoanModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountServicesPage;
import pages.RegisterPage;
import pages.RequestLoanPage;
import sharedData.SharedData;

@Feature("@Transactions")
@Story("@RequestLoanTest")
public class RequestLoanTest extends SharedData {

    @Test(groups = {SuiteType.SMOKE_SUITE, SuiteType.REGRESSION_SUITE})
    public void metodaTest() {

        DataBaseQueries db = new DataBaseQueries();
        RegisterModel registerData = db.getRegisterData();
        RequestLoanModel loanData = db.getLoanData();

        RegisterPage registerPage = new RegisterPage(getDriver());
        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        RequestLoanPage requestLoanPage = new RequestLoanPage(getDriver());

        String usernameValue = "oana" + System.currentTimeMillis() + Thread.currentThread().getId();
        registerPage.registerProcess(usernameValue, registerData);

        accountServicesPage.clickRequestLoan();
        requestLoanPage.loanProcess(loanData);

        String actualLoanStatus = requestLoanPage.getLoanStatus();
        Assert.assertTrue(
                actualLoanStatus.equals(loanData.getApprovedStatus()) ||
                        actualLoanStatus.equals(loanData.getDeniedStatus()),
                "Loan status is not Approved or Denied. Actual status: " + actualLoanStatus);
    }
}