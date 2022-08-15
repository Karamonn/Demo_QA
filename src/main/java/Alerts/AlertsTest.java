package Alerts;

import Setup.Config;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends Config {


    @Test
    public static void testAlertConfirmButton() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        Alerts alerts = new Alerts(driver);
        Assert.assertTrue(alerts.cancelAlert());
        Assert.assertTrue(alerts.acceptAlert());

    }
    @Test
    public static void testAlertButton(){
        driver.get("https://demoqa.com/alerts");
        Alerts alerts = new Alerts(driver);
        alerts.alert();
    }

    @Test
    public static void testPromptAlert()  {
        driver.get("https://demoqa.com/alerts");
        Alerts alerts = new Alerts(driver);
        Assert.assertTrue(alerts.promptAlert("asd"));
    }

    @Test
    public static void testTimerAlert() {
        driver.get("https://demoqa.com/alerts");
        Alerts alerts = new Alerts(driver);
        alerts.timerAlert();
    }


}
