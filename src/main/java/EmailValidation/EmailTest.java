package EmailValidation;

import Setup.Config;
import org.testng.Assert;
import org.testng.annotations.Test;


public class EmailTest extends Config {

    @Test(dataProvider = "validMail")
    public static void validTest(String validMail) {

        driver.get("https://demoqa.com/text-box");

        Email emailCheck = new Email(driver);
        emailCheck.isIni();
        emailCheck.enterName("asd"); // валидации нет, дополнительные проверки не требуются
        emailCheck.address("Red Street", "White Street"); // валидации нет, дополнительные проверки не требуются
        emailCheck.enterEmail(validMail);
        Assert.assertTrue(emailCheck.isDisplayed());
    }

    @Test(dependsOnMethods = {"validTest"}, dataProvider = "invalidMail")
    public static void invalidTest(String invalidMail) {
        driver.get("https://demoqa.com/text-box");

        Email emailCheck = new Email(driver);

        emailCheck.isIni();
        emailCheck.enterName("asd");
        emailCheck.address("Red Street", "White Street");
        emailCheck.enterEmail(invalidMail);
        Assert.assertFalse(emailCheck.isDisplayed());

    }
}