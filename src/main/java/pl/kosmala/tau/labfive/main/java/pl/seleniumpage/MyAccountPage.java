package pl.kosmala.tau.labfive.main.java.pl.seleniumpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    WebDriver driver;

    @FindBy(className = "info-account")
    WebElement infoAccount;

    @FindBy(className = "myaccount-link-list")
    WebElement accountMenu;

    @FindBy(className = "logout")
    WebElement logoutButton;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isInfoAccountVisible() {
        return infoAccount.isDisplayed();
    }

    public boolean isAccountMenuVisible() {
        return accountMenu.isDisplayed();
    }

    public void logoutButtonClick() {
        logoutButton.click();
    }
}
