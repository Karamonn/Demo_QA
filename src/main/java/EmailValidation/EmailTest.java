package EmailValidation;

import Setup.Config;
import org.testng.Assert;
import org.testng.annotations.Test;


public class EmailTest extends Config {

    @Test(dataProvider = "validMail")
    public static void validTest(String validMail) {

        driver.get("https://demoqa.com/text-box");

        Email box = new Email(driver);
        box.enterEmail(validMail);
        box.isIni();
        box.enterName("asd"); // валидации нет, дополнительные проверки не требуются
        box.address("Red Street", "White Street"); // валидации нет, дополнительные проверки не требуются
        Assert.assertTrue(box.isDisplayed());
        System.out.println(validMail + " OK");
    }

    @Test(dependsOnMethods = {"validTest"}, dataProvider = "invalidMail")
    public static void invalidTest(String invalidMail) {
        driver.get("https://demoqa.com/text-box");

        Email box = new Email(driver);

        box.isIni();
        box.enterName("asd");
        box.address("Red Street", "White Street");
        box.enterEmail(invalidMail);
        Assert.assertFalse(box.isDisplayed());

    }
}