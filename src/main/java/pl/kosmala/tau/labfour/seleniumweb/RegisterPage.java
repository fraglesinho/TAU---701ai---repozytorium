package pl.kosmala.tau.labfour.seleniumweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

    WebDriver driver;

    WebElement validateError;
    @FindBy(id = "customer_firstname")
    WebElement firstNameField;

    @FindBy(id = "customer_lastname")
    WebElement lastNameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "passwd")
    WebElement passwordField;

    @FindBy(id = "address1")
    WebElement addressField;

    @FindBy(id = "city")
    WebElement cityField;

    @FindBy(id = "postcode")
    WebElement zipCodeField;

    @FindBy(id = "id_country")
    WebElement countryField;

    @FindBy(id = "id_state")
    WebElement stateField;

    @FindBy(id = "phone_mobile")
    WebElement phoneMobileField;

    @FindBy(id = "submitAccount")
    WebElement submitButton;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isValidateError() {
        return !driver.findElements(By.xpath("//div[contains(@class, 'alert-danger')]")).isEmpty();
    }

    public void setFirstNameField(String txt) {
        firstNameField.sendKeys(txt);
    }

    public void setLastNameField(String txt) {
        lastNameField.sendKeys(txt);
    }

    public void setEmailField(String txt) {
        emailField.clear();
        emailField.sendKeys(txt);
    }

    public void setPasswordField(String txt) {
        passwordField.clear();
        passwordField.sendKeys(txt);
    }

    public void setAddressField(String txt) {
        addressField.sendKeys(txt);
    }

    public void setCityField(String txt) {
        cityField.sendKeys(txt);
    }

    public void setZipCodeField(String txt) {
        zipCodeField.click();
        zipCodeField.sendKeys(txt);
    }

    public void setMobilePhoneField(String txt) {
        phoneMobileField.sendKeys(txt);
    }

    public void chooseCountry() {
        new Select(countryField).selectByValue("21");
    }

    public void chooseState() {
        new Select(stateField).selectByValue("1");
    }

    public void submitButtonClick() {
        submitButton.click();
    }

}
