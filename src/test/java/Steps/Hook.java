//filename: Steps/Hook.java

package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hook extends BaseUtil {

  private BaseUtil base;

  public Hook(BaseUtil base) {
    this.base = base;
  }

  @Before
  public void InitializeTest() {

    System.out.println("Opening the browser.");
    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/vendor/geckodriver.exe");
    base.Driver = new FirefoxDriver();

  }

  @After
  public void TearDownTest(Scenario scenario) {

    if(scenario.isFailed()) {
      // Write code or use tool to take a screenshot
      System.out.println(scenario.getName() + " failed.");
    }
    System.out.println("Closing the browser.");
    base.Driver.quit();
  }

}
