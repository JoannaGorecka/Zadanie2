package Zadanie2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class ItemPage {
    private WebDriver driver;

    public ItemPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "group_1")
    private WebElement itemSizeButton;

    @FindBy(xpath = "//*[@id='group_1']/option[2]")
    private WebElement selectItemSize;


    @FindBy(className = "touchspin-up")
    private WebElement quantityArrow;


    @FindBy(className = "add-to-cart")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[contains(.,'Proceed to checkout')]")
    private WebElement proceedButton;


    public void choosingItemSize() {
        itemSizeButton.click();
        selectItemSize.click();
    }

    public void choosingQuantity(int quantity) {
        Actions actions = new Actions(driver);
        for (int i = 0; i < quantity; i++) {
            actions.click(quantityArrow).perform();
        }
    }

    public void addToCart() {
        addToCartButton.click();
    }
    public void proceedButton() {
        proceedButton.click();
    }
    public void proceedButton2() {
        proceedButton.click();
    }



}
