
package testrunner;
import com.github.javafaker.Faker;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import setup.RegistrationModel;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;

public class RegistrationTestRunner extends Setup {



    @Test(description = "User should not register without required fields", groups="regression")
    public void registrationWithoutRequired() throws IOException, ParseException, InterruptedException {
        RegistrationPage reg = new RegistrationPage( driver);
        reg.registerLink.click();
        reg.btnRegistration.click();
        Thread.sleep(3000);
        String validationError= reg.txtFirstName.getAttribute("validationMessage");
        Assert.assertTrue(validationError.contains("Please fill out this field"));
        driver.findElement(By.cssSelector("a[href='/login']")).click();

    }

  @Test(description = "user should be able to register with all the fields",groups = {"smoke","regression"})
    public void registrationWithALlInput() throws InterruptedException, IOException, ParseException {
        RegistrationPage registration= new RegistrationPage(driver);
        Faker faker =new Faker();

        registration.registerLink.click();
        // setValue
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email="diptyoffs"+lastName+"@gmail.com";
        String password="123"+firstName;
        String phoneNumber= faker.phoneNumber().cellPhone().replaceAll("[^0-9]", "");
        String address= faker.address().country();



        RegistrationModel model = new RegistrationModel();
        model.setFirstName(firstName);
        model.setLastName(lastName);
        model.setEmail(email);
        model.setPassword(password);
        model.setPhoneNumber(phoneNumber);
        model.setAddress(address);
        registration.doregistration(model);


        //Assert
        Thread.sleep(3000);
        String expectedMessage="registered successfully!";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String successMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast"))).getText();
        Assert.assertTrue(successMessage.contains(expectedMessage));


        // Save in JSON
        JSONObject userObj= new JSONObject();
        userObj.put("firstname",firstName);
        userObj.put("lastname",lastName);
        userObj.put("email",email);
        userObj.put("password",password);
        userObj.put("phoneNumber",phoneNumber);
        userObj.put("address",address);
        Utils.saveUserInfo("./src/test/resources/users.json",userObj);
        Thread.sleep(10000);

    }


 @Test(description = "user should be able to register only required fields",groups ="regression")
    public void registrationWithRequiredInput() throws IOException, ParseException, InterruptedException {

        RegistrationPage registration= new RegistrationPage(driver);
        Faker faker =new Faker();
        registration.registerLink.click();

        // setValue
        String firstName = faker.name().firstName();
        String email="diptyoffs"+firstName+"@gmail.com";
        String password="123"+firstName;
        String phoneNumber= faker.phoneNumber().cellPhone().replaceAll("[^0-9]", "");


        RegistrationModel model = new RegistrationModel();
        model.setFirstName(firstName);
        model.setEmail(email);
        model.setPassword(password);
        model.setPhoneNumber(phoneNumber);
        registration.doregistration(model);


        //Assert
        Thread.sleep(3000);
        String expectedMessage="registered successfully!";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String successMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast"))).getText();
        Assert.assertTrue(successMessage.contains(expectedMessage));



        // Save in JSON
        JSONObject userObj= new JSONObject();
        userObj.put("firstname",firstName);
        userObj.put("email",email);
        userObj.put("password",password);
        userObj.put("phoneNumber",phoneNumber);

        Utils.saveUserInfo("./src/test/resources/users.json",userObj);

    }







}