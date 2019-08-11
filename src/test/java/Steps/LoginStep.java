// filename: Steps/LoginStep.java

package Steps;

import Base.BaseUtil;
import Pages.LoginPage;
import Transformation.EmailTransform;
import Transformation.SalaryCountTransform;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class LoginStep extends BaseUtil {

  private BaseUtil base;

  public LoginStep(BaseUtil base) {
    this.base = base;
  }

  Boolean isDisplayed(By locator, Integer timeout) {
    try {
      WebDriverWait wait = new WebDriverWait(base.Driver, timeout);
      wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    } catch (org.openqa.selenium.TimeoutException exception) {
      return false;
    }
    return true;
  }



  @Given("^User navigates to the login page$")
  public void userNavigatesToTheLoginPage() {

    System.out.println("User visits the login page.\n");
    base.Driver.navigate().to("http://executeautomation.com/demosite/Login.html");
  }

  @And("^User enters email address as Email:([^\"]*)$")
  public void userEntersEmailAddressAsEmailAdmin(@Transform(EmailTransform.class) String email) {
    System.out.println("The email address is " + email);
  }

  @And("^User enters the following for login$")
  public void userEntersTheFollowingForLogin(DataTable table) {
    // Create an Array List
    List<User> users = new ArrayList<User>();

    // Store all of the users
    users = table.asList(User.class);
    LoginPage page = new LoginPage(base.Driver);
    for (User user: users) {
      page.login(user.username, user.password);
    }

  }

  @And("^User clicks the Login button$")
  public void userClicksTheLoginButton() {
    LoginPage page = new LoginPage(base.Driver);
    page.clickLogin();
  }

  @Then("^User should see the userform page$")
  public void userShouldSeeTheUserformPage() {

    System.out.println("User sees the userform page.\n");
    isDisplayed(By.id("Initial"), 10);
    assertTrue("Initial field is not displayed.", base.Driver.findElement(By.id("Initial")).isDisplayed());
  }

  @And("^User enters ([^\"]*) and ([^\"]*)$")
  public void userEntersUsernameAndPassword(String username, String password) {
    System.out.println("The username is " + username + " and the password is " + password + ".");
  }

  @And("^User verifies the number of digits in their salary of (\\d+) dollars$")
  public void userVerifiesTheNumberOfDigitsInTheirSalaryOfDollars(@Transform(SalaryCountTransform.class) int salary) {
    System.out.println("User has a " + salary + "-digit salary.");
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
