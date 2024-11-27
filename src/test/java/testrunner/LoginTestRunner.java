package testrunner;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;

public class LoginTestRunner extends Setup {



   @Test(priority = 1, description = "User should be able to login with valid creds")
    public void doAdminLogin()
    {
        LoginPage login = new LoginPage(driver);
        login.dologin("admin@test.com","admin123");


        //Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Dashboard']")));

        //Assert
        String expectedText = "Admin Dashboard";
        String actualText = driver.findElement(By.className("admin-dashboard")).getText();
        System.out.println(actualText);
        Assert.assertTrue(actualText.contains(expectedText));

    }


   @Test(priority = 1, description = "User should Not be able to login with invalid creds",groups = "regression")
    public void doNoTLoginWithInvalidCreds() throws InterruptedException {
        //Login
        LoginPage login = new LoginPage(driver);
        login.dologin("huray.jannatdipty@gmail.com", "12345");
        //Wait
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("MuiTypography-body1")));
        // Assert
        String expectedMessage ="Invalid";
        String errorMessage = driver.findElement(By.className("MuiTypography-body1")).getText();
        Assert.assertTrue(errorMessage.contains(expectedMessage));
        login.clearCreds();


    }



//   @Test(priority = 3, description = "User should be able to login with valid creds")
//    public void doLoginWithValidCreds() {
//
//        //Login
//        LoginPage login = new LoginPage(driver);
//        login.dologin("huray.jannatdipty@gmail.com","1234");
//
//
//        //Wait
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Dashboard']")));
//
//        // Assert
//        String expectedText = "Dashboard";
//        String actualText = driver.findElement(By.xpath("//div[text()='Dashboard']")).getText();
//        Assert.assertEquals(actualText, expectedText, "The actual text does not match the expected text.");
//    }




    @Test(priority = 1, description = "User should be able to login",groups = {"smoke","regression"})
    public void userLogin() throws IOException, ParseException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userLogin(driver);
        Utils.getToken(driver);
       //Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Dashboard']")));

        // Assert
        String expectedText = "Dashboard";
        String actualText = driver.findElement(By.xpath("//div[text()='Dashboard']")).getText();
        Assert.assertEquals(actualText, expectedText, "The actual text does not match the expected text.");


    }



}
