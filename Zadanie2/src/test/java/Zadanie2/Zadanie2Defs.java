package Zadanie2;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.time.Duration;

public class Zadanie2Defs {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable notifications");
        DesiredCapabilities cp = new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl");
    }
    @After
    public void cleanup() {
        driver.quit();
    }


    @Given("user is logged in with {} and {} and is on the home page")
    public void userLoggedIn(String email, String password) {
        MainPage mainPage = new MainPage(driver);
        mainPage.signInButton();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.SignIn(email, password);
        signInPage.HomePage();
    }

    @Then("user selects the size and adds {} items to the cart")
    public void addItem(int quantity) {
        SignedHomePage signedHomePage = new SignedHomePage(driver);
        signedHomePage.addItem();

        ItemPage itemPage = new ItemPage(driver);
        itemPage.choosingItemSize();
        itemPage.choosingQuantity(quantity);
        itemPage.addToCart();
        itemPage.proceedButton();
        itemPage.proceedButton2();

    }

    @Then("user confirms the address, selects pick up and payment method")
    public void orderConfirmation() {
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        orderConfirmationPage.confirmAddress();
        orderConfirmationPage.confirmDelivery();
        orderConfirmationPage.paymentOption();
        orderConfirmationPage.conditionsApprove();
        orderConfirmationPage.paymentConfirmation();


    }

    @And("user takes a screenshot of the order")
    public void screenshot() throws IOException {
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        orderConfirmationPage.takeScreenshot(driver, "report/Screenshots/screenshots");


    }
}
