package Zadanie2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignedHomePage {

    public SignedHomePage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id='content']/section/div/div[2]/article/div/div[2]/h3/a")
    private WebElement item;

    public void addItem() {
        item.click();
    }
}
