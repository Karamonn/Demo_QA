package Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.time.Duration;

public class Config {

    protected static WebDriver driver;

    @DataProvider(name = "validMail")
    public static Object[][] mailData() {
        return new Object[][]{
                {"asd@mail.ru"}, {"ASD@MAIL.RU"},
                {"a1sd@mail.ru"}, {"asd@m1ail.ru"}, {"a-sd@mail.ru"}, {"asd@m-ail.ru"},
                {"a.sd@mail.ru"}, {"a_sd@mail.ru"}, {"asd@m_ail.ru"}, {"a.sd@mail.ru"}, {"asd@m.ail.ru"}
        };
    }

    @DataProvider(name = "invalidMail")
    public static Object[][] invMailData() {
        return new Object[][]{{"asd@mailru"}, {"asdmail.ru"}, {"a sd@mail.ru"},
                {"@mail.ru"}, {"asd.ru"}, {"asd@mail.ruuuu"}, {"асд@mail.ru"},
                {"asdasd"}, {"1@m.r"}, {""}
        };
    }


    @BeforeTest
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Sel\\chromedriver.exe"); // изменить на ваш актуальный путь до ChromeDriver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @AfterTest
    public void clearCookies() {
        driver.manage().deleteAllCookies();
    }

    @AfterSuite
    public static void closeDriver() {
        driver.close();
    }
}