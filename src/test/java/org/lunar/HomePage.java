package org.lunar;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class HomePage {

    private static final String PAGE_URL = "https://www.demoblaze.com";

    private final WebDriver driver;

    @FindBy(css = "#logInModal > div > div > div.modal-footer > button.btn.btn-primary")
    private WebElement logInButton;

    @FindBy(css = "#errorl")
    private WebElement errorMessage;

    private static final Map<String, By> textFields = Map.of(
            "login-Username", By.id("loginusername"),
            "login-Password", By.id("loginpassword"),
            "register-Username", By.id("sign-username"),
            "register-Password", By.id("sign-password")

    );

    private static final Map<String, By> navigationButtons = Map.of(
            "Login", By.id("login2"),
            "signIn", By.id("signin2"),
            "login-User" , By.cssSelector("#logInModal > div > div > div.modal-footer > button.btn.btn-primary"),
            "register-User", By.cssSelector("#signInModal > div > div > div.modal-footer > button.btn.btn-primary")
    );

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void closePage() {
        driver.quit();
    }
    public void fillOutField(String field, String text) {
        driver.findElement(textFields.get(field)).sendKeys(text);
    }

    public void clickButton(String button) {

        By buttonLocator = navigationButtons.get(button);
        if (buttonLocator == null) {
            throw new IllegalArgumentException("Locator for button '" + button + "' is not defined in the map.");
        }
        driver.findElement(buttonLocator).click();
       // driver.findElement(navigationButtons.get(button)).click();
    }

    public String getErrorMessage() {

        try{  // Wait for the alert to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Get the alert text
        String alertText = alert.getText();

        // Accept or dismiss the alert as needed
        alert.accept();  // You can also use alert.dismiss() if you need to dismiss the alert instead of accepting

        return alertText;
        } catch (NoAlertPresentException e) {
          return   "No alert present";
        }

    }

}
