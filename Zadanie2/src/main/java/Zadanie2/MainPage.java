package Zadanie2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[contains(text(), 'Sign in')]")
    private WebElement signInButton;

    public void signInButton() {
        signInButton.click();
    }

}

