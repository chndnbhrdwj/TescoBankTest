package hooks;

import core.Driver;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Created by chandan on 4/10/19.
 */
public class Hooks {

    @Before
    public void before() {

    }

    @After
    public void after() {
        Driver.getDriver().quit();
    }
}
