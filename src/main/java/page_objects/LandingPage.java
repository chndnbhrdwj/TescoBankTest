package page_objects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * Created by chandan on 4/10/19.
 */
public class LandingPage extends BasePage {

    @AndroidFindBy(xpath = "//*[@text='API Demos']")
    private WebElement apiDemos;

    @AndroidFindBy(xpath = "//*[@text='Text']")
    private WebElement text;

    @AndroidFindBy(xpath = "//*[@text='LogTextBox']")
    private WebElement logTextBox;

    @AndroidFindBy(xpath = "//*[@text='App']")
    private WebElement app;

    @AndroidFindBy(xpath = "//*[@text='Preference']")
    private WebElement preference;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Switch')]")
    private WebElement switchText;

    @AndroidFindBy(xpath = "//android.widget.CheckBox")
    private WebElement checkBox;

    @AndroidFindBy(xpath = "//*[@text='Notification']")
    private WebElement notification;

    @AndroidFindBy(xpath = "//*[@text='NotifyWithText']")
    private WebElement notifyWithText;

    @AndroidFindBy(xpath = "//*[contains(@text, 'This is a test')]")
    private WebElement thisIsATest;

    @AndroidFindBy(xpath = "//*[@text='This is a switch']")
    private WebElement thisIsASwitch;

    @AndroidFindBy(id="com.touchboarder.android.api.demos:id/add")
    private WebElement addButton;

    @AndroidFindBy(id="com.touchboarder.android.api.demos:id/long_notify")
    private WebElement longNotifyButton;


    public WebElement getApiDemos() {
        return waitForElement(apiDemos);
    }

    public WebElement getText() {
        return waitForElement(text);
    }

    public WebElement getLogTextBox() {
        return waitForElement(logTextBox);
    }

    public WebElement getApp() {
        return waitForElement(app);
    }

    public WebElement getPreference() {
        return waitForElement(preference);
    }

    public WebElement getSwitchText() {
        return waitForElement(switchText);
    }

    public WebElement getCheckBox() {
        return waitForElement(checkBox);
    }

    public WebElement getNotification() {
        return waitForElement(notification);
    }

    public WebElement getNotifyWithText() {
        return waitForElement(notifyWithText);
    }

    public WebElement getThisIsATest() {
        return waitForElement(thisIsATest);
    }

    public WebElement getThisIsASwitch() {
        return waitForElement(thisIsASwitch);
    }

    public WebElement getAddButton() {
        return waitForElement(addButton);
    }

    public WebElement getLongNotifyButton() {
        return waitForElement(longNotifyButton);
    }

    public void goToApiDemos() {
        getApiDemos().click();
    }

    public void goToLogTextBox() {
        goToApiDemos();
        getText().click();
        getLogTextBox().click();
    }

    public boolean addButtonIsFunctional() {
        getAddButton().click();
        return isDisplayed(getThisIsATest());
    }

    public void goToNotifyWithTextSection() {
        goToApiDemos();
        getApp().click();
        getNotification().click();
        getNotifyWithText().click();
    }

    public void longNotificationIsFunctional() {
        getLongNotifyButton().click();
    }

    public void goToPreferenceSwitch() {
        goToApiDemos();
        getPreference().click();
        getSwitchText().click();
    }

    public void checkCheckBox() {
        if(!preferenceCheckBoxChecked()) {
            getCheckBox().click();
        }
    }

    public boolean preferenceCheckBoxChecked() {
        return checkBoxIsChecked(getCheckBox());
    }
}













