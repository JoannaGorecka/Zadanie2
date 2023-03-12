package Zadanie2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "field-email")
    private WebElement emailField;

    @FindBy(id = "field-password")
    private WebElement passField;

    @FindBy(id = "submit-login")
    private WebElement submitButton;

    @FindBy(className = "img-fluid")
    private WebElement homePage;

    public void SignIn(String email, String password) {
        emailField.clear();
        emailField.sendKeys(email);
        passField.clear();
        passField.sendKeys(password);
        submitButton.click();
    }
    public void HomePage() {
        homePage.click();
    }
}
