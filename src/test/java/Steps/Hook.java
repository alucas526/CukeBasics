//filename: Steps/Hook.java

package Steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {

  @Before
  public void InitializeTest() {
    System.out.println("Opening the browser. JK.");
  }

  @After
  public void TearDownTest(Scenario scenario) {

    if(scenario.isFailed()) {
      // Write code or use tool to take a screenshot
      System.out.println(scenario.getName() + " failed.");
    }
    System.out.println("Closing the browser. JK.");
  }

}
