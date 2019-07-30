package Steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.List;

public class LoginStep {
  @Given("^User navigates to the login page$")
  public void userNavigatesToTheLoginPage() {
    System.out.println("User sees the login page.");
  }

  @And("^User enters the following for login$")
  public void userEntersTheFollowingForLogin(DataTable table) {
    List<List<String>> data = table.raw();
    System.out.println("The value is " + data.get(0).get(0));
    System.out.println("The value is " + data.get(0).get(1));
  }

  @And("^User clicks the Login button$")
  public void userClicksTheLoginButton() {
    System.out.println("User clicks the login button.");
  }

  @Then("^User should see the userform page$")
  public void userShouldSeeTheUserformPage() {
    System.out.println("User sees the userform page.");
  }

}
