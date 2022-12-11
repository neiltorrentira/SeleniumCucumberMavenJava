package Helpers;

import Common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper extends WebDriverFactory {

    public static void enterText(By by, String value) {
        try {
            System.out.println("Entered value '" + value + "' to element: " + by);
            WebElement txtElement = (new WebDriverWait(getWebDriver(), Duration.ofSeconds(10)))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
            highlightElement(txtElement);
            getWebDriver().findElement(by).sendKeys(value);
        } catch (ElementNotInteractableException e)
        {
            e.printStackTrace();
        }
    }

    public static void clickElement(By by){
        System.out.println("Clicked the element: " + by);
        WebElement buttonElement = (new WebDriverWait(getWebDriver(), Duration.ofSeconds(10)))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
        highlightElement(buttonElement);
        buttonElement.click();
    }

    public static void highlightElement(WebElement element) {
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public static void gotoUrl(String value){
        System.out.println("Opening page: " + value);
        getWebDriver().navigate().to(value);
    }

    public static void verifyTextPresent(String value) {
        if (getWebDriver().getPageSource().contains(value)) {
            System.out.println("String/Text found true: " + value);
        } else {
            System.out.println("String/Text not found/false: " + value);
        }
    }

    public static void sleep(Integer value) throws InterruptedException {
        System.out.println("Sleeping for: " + value);
        Thread.sleep(value);
    }

    public static void verifyPageTitleTrue(String value) {
        if (getWebDriver().getTitle().contentEquals(value)) {
            System.out.println("Page Title found true: " + value);
        } else {
            System.out.println("Page Title not found/false: " + value);
        }
    }
}
