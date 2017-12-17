package pl.kosmala.tau.labfive.main.java.pl.seleniumpage;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;

    @FindBy(className = "shop-phone")
    WebElement phoneNumber;

    @FindBy(id = "homepage-slider")
    WebElement slider;

    @FindBy(className = "shopping_cart")
    WebElement cart;

    @FindBy(xpath = "//*[@id='home-page-tabs']/li/a[text()='Best Sellers']")
    WebElement bestSellers;

    @FindBy(id = "blockbestsellers")
    WebElement bestSellersBlock;

    @FindBy(css = "#block_top_menu > ul.sf-menu.clearfix.menu-content.sf-js-enabled.sf-arrows > li:nth-child(2)")
    WebElement dressesButton;

    @FindBy(xpath = "//a[@class='login']")
    WebElement signinButton;

    @FindBy(css ="#block_top_menu > ul.sf-menu.clearfix.menu-content.sf-js-enabled.sf-arrows > li:nth-child(2) > ul")
    WebElement subMenu;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPhoneNumber() {
        return phoneNumber.findElement(By.xpath("strong")).getText();
    }

    public String getSlider() {
        return slider.getText();
    }

    public String getCart() {
        return cart.findElement(By.xpath("a")).getAttribute("href");
    }

    public void bestSellersClick() {
        bestSellers.click();
    }

    public List<WebElement> getBestSellersProducts() {
        return bestSellersBlock.findElements(By.className("product-name"));
    }

    public boolean isBestSellersBlockVisible() {
        return bestSellersBlock.isDisplayed();
    }

    public boolean isSubMenuVisible() {
           return subMenu.isDisplayed();
    }

    public void signinButtonClick() {
        signinButton.click();
    }

    public void dressesButtonHover() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(dressesButton);
        actions.perform();
        actions.build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        ExpectedCondition e = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (isSubMenuVisible());
            }
        };
        wait.until(e);
    }
}
