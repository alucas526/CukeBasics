package Steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginStep {
  @Given("^User navigates to the login page$")
  public void userNavigatesToTheLoginPage() {
    System.out.println("User sees the login page.");
  }

  @And("^User enters the username as \"([^\"]*)\" and the password as \"([^\"]*)\"$")
  public void userEntersTheUsernameAsAndThePasswordAs(String username, String password) throws Throwable {
    System.out.println("Username is " + username + " and password is " + password);
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
