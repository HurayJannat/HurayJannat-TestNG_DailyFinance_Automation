package testrunner;
import org.json.simple.parser.ParseException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import setup.ItemsDataSet;
import setup.Setup;
import utils.Utils;
import java.io.IOException;



public class DashboardTestRunner extends Setup {

    @BeforeTest
    public void doLogin(){
        LoginPage login = new LoginPage(driver);
        login.dologin(System.getProperty("username"),System.getProperty("password"));

    }

    @BeforeTest (description = "Add User Token", groups = {"smoke","regression"})
    public void setToken() throws ParseException, IOException, InterruptedException {
        Utils.setAuth(driver);
    }

    @Test(priority = 3, description = " Add Item Manually" )
    public void addItem() throws IOException, InterruptedException {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.addItem("dress","1230","12","January","Awosome");


    }


   @Test(priority = 1, dataProvider= "AddItemCSV", dataProviderClass = ItemsDataSet.class, groups ={"smoke","regression"} )
    public void addItemFromCSV(String itemName, String cost, String amount, String month,String remarks) throws InterruptedException {
       driver.get("https://dailyfinance.roadtocareer.net/user");
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.addItem(itemName,cost,amount,month,remarks);

    }

    @Test(priority = 2, groups = {"smoke","regression"})
    public void checkTotalCost() throws InterruptedException {
        driver.get("https://dailyfinance.roadtocareer.net/user");
        DashboardPage dashboardPage = new DashboardPage(driver);
        String actualAmount= dashboardPage.totalCost();
        String expectedAmount = "24";
        Assert.assertEquals(actualAmount,expectedAmount);
    }












}