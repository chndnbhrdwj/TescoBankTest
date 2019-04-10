package page_objects;

import core.Driver;
import core.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


/**
 * Created by chandan on 4/10/19.
 */
public class BasePage {

    protected Logger log = Logger.getLogger(this.getClass().getSimpleName());
    protected AppiumDriver driver;
    private WebDriverWait wait;


    public BasePage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(0)),this);
    }

    private void setImplicitWait(int mill) {
        driver.manage().timeouts().implicitlyWait(mill, TimeUnit.SECONDS);
    }

    protected WebElement waitForElement(WebElement element) {
        return waitForElement(element, Integer.valueOf(Utils.getProperty("timeout")));
    }

    protected boolean isDisplayed(WebElement... element) {
        boolean displayed = false;
        for (int f = 0; f < element.length; f++) {
            displayed = elementDisplayed(element[f]);
            if (!displayed) {
                throw new NoSuchElementException("Expected element was not displayed on screen. " + element[f]);
            }
        }
        return displayed;
    }

    protected boolean isPageLoaded(WebElement... element) {
        return isDisplayed(element);
    }

    protected boolean elementDisplayed(WebElement element) {
        setImplicitWait(0);
        boolean displayed = false;
        try {
            if (element != null) {
                displayed = element.isDisplayed();
            }
        } catch (Exception e) {
            displayed = false;
        }
        return displayed;
    }

    protected WebElement waitForElement(WebElement element, int timeInSeconds) {
        WebElement element1 = null;
        wait = new WebDriverWait(driver, timeInSeconds);
        try {
            element1 = wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            log.info("Couldn't find expected element " + element + " " + e.getMessage());
        }
        return element1;
    }

    protected boolean checkBoxIsChecked(WebElement checkbox) {
        return Boolean.valueOf(checkbox.getAttribute("checked"));
    }


}
