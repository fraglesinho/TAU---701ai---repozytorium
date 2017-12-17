package pl.kosmala.tau.labfive.test.java.pl.seleniumpage.bdd.scenerio;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pl.I;
import cucumber.api.java.pl.Kiedy;
import cucumber.api.java.pl.Mając;
import cucumber.api.java.pl.Wtedy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.kosmala.tau.labfive.main.java.pl.seleniumpage.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class FailedLoginScenerio {
    static WebDriver driver;

    @Before
    public static void driverSetup() {

        System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    @Mając("^Załadowaną stronę do logowana$")
    public void ZaladowanaStronaLogowania() {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @Kiedy("^Wprowadzam dane użytkownika \"([^\"]*)\" i hasło \"([^\"]*)\"$")
    public void WprowadzaniePoprawnegoUzytkownikaIHasla(String user, String password) {
        //wiem że w tym momęcie łamię DRY, ale niestety coś nie chwyta obiektu jak jest klasowy
        LoginPage login = new LoginPage(driver);
        login.setEmailField(user);
        login.setPasswordField(password);
    }

    @I("^Nacisnełem przycisk logowania by się zalogować$")
    public void KliknieciePrzyciskuLogowania() {
        LoginPage login = new LoginPage(driver);
        login.loginButtonClick();
    }

    @Wtedy("^Ukazuje mi się strona logowania z blędem$")
    public void UkazanieStronyLogowania() {
        assertThat(driver.getCurrentUrl(),equalTo("http://automationpractice.com/index.php?controller=authentication"));
    }

    @After
    public static void cleanp() {
        driver.quit();
    }
}
