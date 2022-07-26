package stepdefinitions;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {
    public static String title;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("user is on login page")
    public void user_is_on_login_page() {
        DriverFactory.getDriver().get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = loginPage.getLoginPageTitle();
        System.out.println("Login page title iS : " + title);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(title.contains(expectedTitleName));
    }

    @Then("forgot your password link should be displayed")
    public void forgot_your_password_link_should_be_displayed() {
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());
        }

    @When("user enters username {string}")
    public void user_enters_username(String uname) {
        loginPage.enterUserName(uname);
    }

    @When("user enters password {string}")
    public void user_enters_password(String pwd) {
        loginPage.enterPassword(pwd);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.qlickOnLogin();
    }

    @Then("user gets the title of the accounts page")
    public void user_gets_the_title_of_the_home_page() {
    }

    @Then("accounts page title should be {string}")
    public void home_page_title_should_be(String string) {
    }

}
