package testrunner;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.util.List;


public class AdminDashboardTestRunner extends Setup {


    @BeforeTest (groups = "regression")
    public void doLogin(){
        LoginPage login = new LoginPage(driver);
        login.dologin(System.getProperty("username"),System.getProperty("password"));

    }

    //Check Registered User
    @Test(groups = "regression")
    public void checkRegisteredUser() throws IOException, ParseException, InterruptedException {
        JSONObject lastUser = Utils.getLastUser("./src/test/resources/users.json");

        Thread.sleep(5000);
        if (lastUser != null) {
            String lastUserEmail = (String) lastUser.get("email");
            DashboardPage dashboard = new DashboardPage(driver);
            Assert.assertTrue(dashboard.checkRegisteredUser(lastUserEmail),
                    "The email " + lastUserEmail + " is not found in the table.");

            System.out.println("Test passed: The email is found in the table.");

        }

        String csvFirstName = (String) lastUser.get("firstname");
        String csvEmail = (String) lastUser.get("email");
        String csvPhone = (String) lastUser.get("phoneNumber");


        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));

        // Iterate through each row and extract the necessary data

        String firstName = rows.get(0).findElement(By.cssSelector("td:nth-child(1)")).getText();
        String email = rows.get(0).findElement(By.cssSelector("td:nth-child(3)")).getText();
        String phone = rows.get(0).findElement(By.cssSelector("td:nth-child(4)")).getText();

        // Output the data
        System.out.println("First Name: " + firstName);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("------------");

        Assert.assertEquals(firstName, csvFirstName);
        Assert.assertEquals(email, csvEmail);
        Assert.assertEquals(phone, csvPhone);

        Thread.sleep(3000);
        LoginPage login = new LoginPage(driver);
        login.doLogout(driver);


    }


}