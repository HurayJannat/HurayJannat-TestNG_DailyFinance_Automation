package pages;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import setup.Setup;

import java.nio.file.Files;
import java.nio.file.Paths;

public class AdminDashboard extends Setup {


    public AdminDashboard (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


}