package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Setup {
    public WebDriver driver;

    @BeforeTest(groups = {"smoke","regression"})
    public void setup()
    {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://dailyfinance.roadtocareer.net/");
        driver.manage().window().maximize();

    }

    @AfterTest(groups = {"smoke","regression"})
    public void closeDrive()
    {
        driver.quit();
    }

}