import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by chandan on 4/10/19.
 */

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "html:target/cucumber-html-report",
        "json:target/cucumber.json"},
        features = { "src/test/resources/features" }
)

public class TestSuite {

}
