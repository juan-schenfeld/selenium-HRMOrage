import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class BasePage {
    protected WebDriver driver;
    private final int DEFAULT_SECONDS = 10;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebElement visibilityOf(WebElement element, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement visibilityOf(WebElement element) {
        return visibilityOf(element, DEFAULT_SECONDS);
    }

    protected void click(WebElement element, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void click(WebElement element) {
        click(element, DEFAULT_SECONDS);
    }

    protected void sendKeys(WebElement element, String keys, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(keys);
    }

    protected void sendKeys(WebElement element, String keys) {
        sendKeys(element, keys, DEFAULT_SECONDS);
    }


    protected String getText(WebElement element, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOf(element)).getText();
    }

    protected String getText(WebElement element) {
        return getText(element, DEFAULT_SECONDS);
    }
}
