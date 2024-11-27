package pages;

import org.apache.commons.csv.CSVFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.csv.CSVRecord;
import setup.Setup;

import javax.xml.xpath.XPath;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class DashboardPage extends Setup {

    @FindBy(className = "add-cost-button")
    public WebElement btnAdd;


    @FindBy(id = "itemName")
    public WebElement txtItem;

    @FindBy(css = "input[type='number']")
    public WebElement txtCost;

    @FindBy(id = "amount")
    public WebElement txtAmount;

    @FindBy(css = "button[type='submit']")
    public  WebElement btnSubmit;

    @FindBy(id = "month")
    private WebElement monthDropdown;

    @FindBy(id = "remarks")
    public WebElement txtRemarks;

    @FindBy(className = "MuiIconButton-root")
    public WebElement btnMenu;

    @FindBy(xpath = "//li[contains(text(), 'Profile')]")
    public WebElement profileMenuItem;

    @FindBy(xpath = "//button[contains(text(), 'Edit')]")
    public WebElement editButton;

    @FindBy(css = "input[type='file'].upload-input")
    public WebElement uploadInput;

    @FindBy(xpath = "//button[contains(text(),'Upload Image')]")
    private WebElement uploadButton;

    @FindBy(xpath ="//span[contains(text(), 'Total Cost')]")
    public WebElement costAmount;

    @FindBy(css = "input[type='text']")
    public WebElement searchArea;


    public void searchItem(String itemName)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchArea));
        searchArea.sendKeys(itemName);
    }


    public String totalCost() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(costAmount));
        Thread.sleep(3000);
        String text = costAmount.getText();
        // Extract the numeric value using regex
        String actualAmount = text.replaceAll("[^\\d]", "");
        System.out.println("Actual Amount: " + actualAmount + " TK");
        return actualAmount;


    }




    public boolean checkRegisteredUser(String email)
    {
        List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));

        // Iterate over the rows and check if any cell contains the email
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));

            // Check each cell in the row
            for (WebElement cell : cells) {
                if (cell.getText().equals(email)) {
                    // Close the browser if email is found
                    return true;  // Email found, return true
                }
            }
        }
        return false;

    }





    public void addItem(String itemName, String cost, String amount, String month, String remarks) throws InterruptedException {

        btnAdd.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(txtItem));
        txtItem.sendKeys(itemName);
        txtCost.sendKeys(cost);
        txtAmount.sendKeys(amount);
        Select select = new Select(monthDropdown);
        select.selectByVisibleText(month);
        txtRemarks.sendKeys(remarks);

        // Submit the form if needed
        wait.until(ExpectedConditions.visibilityOf(btnSubmit));
        btnSubmit.click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

    }


    public void uploadImage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(btnMenu));
        btnMenu.click();
        wait.until(ExpectedConditions.visibilityOf(profileMenuItem));
        profileMenuItem.click();
        wait.until(ExpectedConditions.visibilityOf(editButton));
        editButton.click();
        wait.until(ExpectedConditions.visibilityOf(uploadInput));
        Path path = Paths.get("./src/test/resources/image.jpg").toAbsolutePath();
        String absolutePath = path.toString();
        uploadInput.sendKeys(absolutePath);
        uploadButton.click();

    }




    public DashboardPage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}