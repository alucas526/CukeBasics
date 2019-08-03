package Steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.List;

public class LoginStep {
  @Given("^User navigates to the login page$")
  public void userNavigatesToTheLoginPage() {

    System.out.println("User visits the login page.\n");
  }

  @And("^User enters the following for login$")
  public void userEntersTheFollowingForLogin(DataTable table) {
    // List<List<String>> data = table.raw();

    // System.out.println("The value is " + data.get(0).get(0));
    // System.out.println("The value is " + data.get(0).get(1));

    // Create an Array List
    List<User> users = new ArrayList<User>();
    // Store all of the users
    users = table.asList(User.class);

    for (User user: users) {
      System.out.println("The username is " + user.username);
      System.out.println("The password is " + user.password);
    }

  }

  @And("^User clicks the Login button$")
  public void userClicksTheLoginButton() {
    System.out.println("User clicks the login button.\n");
  }

  @Then("^User should see the userform page$")
  public void userShouldSeeTheUserformPage() {

    System.out.println("User sees the userform page.\n");
  }

  @And("^User enters ([^\"]*) and ([^\"]*)$")
  public void userEntersUsernameAndPassword(String username, String password) {
    System.out.println("The username is " + username + " and the password is " + password + ".");
  }

  public class User {
    private String username;
    private String password;

    public User(String userName, String passWord) {
      username = userName;
      password = passWord;
    }
  }

}
