package core;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by chandan on 4/10/19.
 */
public class Driver {

    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {
        return initDriver();
    }

    private static AppiumDriver initDriver() {
        driver = new AppiumDriver(buildCapabilities());
        return driver;
    }

    private static DesiredCapabilities buildCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Utils.getPlatformCapabilities().entrySet()
                .stream()
                .forEach(entry-> {
                    capabilities.setCapability(entry.getKey(), entry.getValue());
                });
        return capabilities;
    }

}
