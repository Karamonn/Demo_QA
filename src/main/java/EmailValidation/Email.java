package EmailValidation;

import Setup.PageObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Email extends PageObject {

    @FindBy(css = "[ id = 'userName']")
    private static WebElement nameField;

    @FindBy(xpath = "//input [@class = 'mr-sm-2 form-control']")
    private WebElement email;

    @FindBy(id = "currentAddress")
    private WebElement curAddress;

    @FindBy(id = "permanentAddress")
    private WebElement perAddress;

    @FindBy(id = "submit")
    private WebElement sub;

    @FindBy(xpath = "//p [@id = 'email']")
    private WebElement accept;


    public Email(WebDriver driver) {
        super(driver);
    }

    public boolean isIni() {
        return nameField.isDisplayed();
    }

    public void enterName(String name) {
        this.nameField.clear();
        this.nameField.sendKeys(name);
    }

    public void enterEmail(String name) {
        this.email.clear();
        this.email.sendKeys(name);
    }

    public void address(String current, String permanent) {
        this.curAddress.clear();
        this.curAddress.sendKeys(current);

        this.perAddress.clear();
        this.perAddress.sendKeys(permanent);
    }

    public boolean isDisplayed() {
        sub.click();
        try {
            return accept.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}