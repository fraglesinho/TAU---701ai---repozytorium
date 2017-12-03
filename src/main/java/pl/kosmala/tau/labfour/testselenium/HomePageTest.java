package pl.kosmala.tau.labfour.testselenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.kosmala.tau.labfour.seleniumweb.HomePage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomePageTest {

    private static WebDriver driver;

    @BeforeClass
    public static void driverSetup() {

        System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void testPhoneNumber() {
        HomePage home = new HomePage(driver);
        assertThat(home.getPhoneNumber(),notNullValue());
    }

    @Test
    public void testSilderText() {
        HomePage home = new HomePage(driver);
        assertThat(home.getSlider().toLowerCase().contains("lorem ipsum"),equalTo(true));
    }

    @Test
    public void testCartGet() {
        HomePage home = new HomePage(driver);
        assertThat(home.getCart().toLowerCase().contains("http://automationpractice.com/index.php"),equalTo(true));
    }

    @Test
    public void testBestSeller() {
        HomePage home= new HomePage(driver);
        home.bestSellersClick();
        assertThat(home.isBestSellersBlockVisible(),equalTo(true));
        assertThat(home.getBestSellersProducts().size(),equalTo(7));
        assertThat(home.getBestSellersProducts().stream().anyMatch(o -> o.getText().equals("Printed Chiffon Dress")),equalTo(true));
    }

    @Test
    public void testDressButton() throws IOException, InterruptedException {
        HomePage home = new HomePage(driver);
        home.dressesButtonHover();
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File screenshootFile = scrShot.getScreenshotAs(OutputType.FILE);
        File filePath = new File("D:\\screen\\screenshoot.jpg");
        FileUtils.copyFile(screenshootFile, filePath);
        assertThat(home.isSubMenuVisible(),equalTo(true));
    }

    @Test
    public void testSingIn() {
        HomePage home = new HomePage(driver);
        home.signinButtonClick();
        assertThat(driver.getCurrentUrl(), equalTo("http://automationpractice.com/index.php?controller=authentication&back=my-account"));
    }

    
    @AfterClass
    public static void cleanp() {
        driver.quit();
    }
}
