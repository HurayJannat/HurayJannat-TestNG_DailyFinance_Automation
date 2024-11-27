package testrunner;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;

public class ProfileTestRunner extends Setup {


    @BeforeTest(groups = "regression")
    public void setToken() throws ParseException, IOException, InterruptedException {
        Utils.setAuth(driver);
    }



    @Test(description = "verify to upload image", groups = "regression")
    public void uploadImage()
    {
        driver.get("https://dailyfinance.roadtocareer.net/user");
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.uploadImage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

    }
}
