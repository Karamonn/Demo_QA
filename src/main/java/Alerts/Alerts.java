package Alerts;

import Setup.PageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class Alerts extends PageObject {
    @FindBy(id = "alertButton")
    private WebElement alertButton;

    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    private WebElement confirmButton;

    @FindBy(id = "promtButton")
    private WebElement promtButton;

    @FindBy(id = "confirmResult")
    private WebElement result;

    @FindBy(id = "promptResult")
    private WebElement promptResult;

    public Alerts(WebDriver driver) {
        super(driver);
    }

    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public void alert() {
        alertButton.click();
        Alert alert = wait.until(alertIsPresent());
        alert.accept();
    }

    public void timerAlert() {
        timerAlertButton.click();
        Alert alert = wait.until(alertIsPresent());
        alert.accept();
    }

    public boolean cancelAlert() {
        confirmButton.click();
        Alert alert = wait.until(alertIsPresent());
        alert.dismiss();
        String s = result.getText();
        if (s.equals("You selected Cancel"))
            return true;
        else return false;
    }

    public boolean acceptAlert() {
        confirmButton.click();
        Alert alert = wait.until(alertIsPresent());
        alert.accept();
        String s = result.getText();

        if (s.equals("You selected Ok"))
            return true;
        else return false;
    }

    public boolean promptAlert(String text) {

        promtButton.click();
        Alert alert = wait.until(alertIsPresent());
        alert.sendKeys(text);
        alert.accept();


        if (promptResult.getText().equals("You entered " + text))
            return true;
        else return false;
    }
}
