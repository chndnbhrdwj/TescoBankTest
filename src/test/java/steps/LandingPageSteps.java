package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import page_objects.LandingPage;

/**
 * Created by chandan on 4/10/19.
 */
public class LandingPageSteps {

    LandingPage landingPage = new LandingPage();

    @When("^I am on (.*) section$")
    public void iAmOn(String location)
    {
        switch (location) {
            case "LogTextBox":
                landingPage.goToLogTextBox();
                break;
            case "NotifyWithText":
                landingPage.goToNotifyWithTextSection();
                break;
            case "CheckboxPreference":
                landingPage.goToPreferenceSwitch();
                break;
            default:
                throw new IllegalStateException("App section is not implemented");
        }
    }

    @Then("^Add button should work$")
    public void addButtonShouldWork() {
        Assert.assertTrue(landingPage.addButtonIsFunctional());
    }

    @Then("^Show long notification button should work$")
    public void showLongNotificationButtonShouldWork() {
        landingPage.longNotificationIsFunctional();
        //TODO find out if toast can be verified with appium or should be part of espresso unit tests

    }

    @Then("^I should be able to set preference$")
    public void iShouldBeAbleToSetPreference() {
        landingPage.checkCheckBox();
        Assert.assertTrue(landingPage.preferenceCheckBoxChecked());
    }
}
