package Zadanie2;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class OrderConfirmationPage {

    public OrderConfirmationPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "confirm-addresses")
    private WebElement confirmAddressButton;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement confirmDeliveryButton;

    @FindBy(id = "payment-option-1")
    private WebElement paymentOption;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement conditionsApprove;

    @FindBy(css = "#payment-confirmation > div.ps-shown-by-js > button")
    private WebElement paymentConfirmation;




    public void confirmAddress() {
        confirmAddressButton.click();
    }
    public void confirmDelivery() {
        confirmDeliveryButton.click();
    }
    public void paymentOption() {
        paymentOption.click();
    }
    public void conditionsApprove() {
        conditionsApprove.click();
    }
    public void paymentConfirmation() {
        paymentConfirmation.click();
    }
        public  void takeScreenshot(WebDriver driver, String filePath) throws IOException {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File(filePath);
            FileHandler.copy(sourceFile, destinationFile);
        }


    }






