package testrunner;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;

public class SearchItemTestRunner extends Setup {


    @BeforeTest(groups = {"smoke","regression"})
    public void setToken() throws ParseException, IOException, InterruptedException {
        Utils.setAuth(driver);
    }

    @Test(groups = {"smoke","regression"})
    public void searchItem() throws InterruptedException {


        driver.get("https://dailyfinance.roadtocareer.net/user");
        String searchItem = "Keyboard";
        DashboardPage dashboardPage= new DashboardPage(driver);
        dashboardPage.searchItem(searchItem);
        String actualCost= dashboardPage.totalCost();
        String expectedCost= "5";
        Assert.assertEquals(actualCost,expectedCost);
    }



}
