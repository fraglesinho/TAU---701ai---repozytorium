package pl.kosmala.tau.labfour.seleniumweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(name = "email_create")
    WebElement registerEmailField;

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(id = "passwd")
    WebElement passwordField;

    @FindBy(id = "SubmitCreate")
    WebElement registerButton;

    @FindBy(id = "SubmitLogin")
    WebElement loginButton;

    @FindBy(id = "account-creation_form")
    WebElement accountForm;

    WebElement loginError;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setRegisterEmailFieldText(String txt) {
        registerEmailField.sendKeys(txt);
    }

    public void registerButtonClick() {
        registerButton.click();
    }

    public void setEmailField(String txt) {
        emailField.click();
        emailField.sendKeys(txt);
    }

    public void setPasswordField(String txt) {
        passwordField.click();
        passwordField.sendKeys(txt);
    }

    public void loginButtonClick() {
        loginButton.click();
    }

    public boolean isLoginError() {
        return !driver.findElements(By.xpath("//div[contains(@class, 'alert-danger')]")).isEmpty();
    }

    public boolean isRegisterButtonVisible() {
        return registerButton.isDisplayed();
    }

    public boolean isAccountFormVisible() {
        return accountForm.isDisplayed();
    }
}
