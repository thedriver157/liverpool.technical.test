package com.liverpool.Steps.Login;

import com.liverpool.Actor.I;
import com.liverpool.Pages.Commons.NavBarSection;
import com.liverpool.Pages.Login.LoginPage;
import com.liverpool.Pages.MyAccount.MyAccountPage;
import com.liverpool.Utils.EnvVars;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    LoginPage loginPage;

    @When("^login in the app$")
    public void login_in_the_app() {
        NavBarSection navBarSection = I.get().initPage(NavBarSection.class);
        navBarSection.accessToNavBarSection("MY_ACCOUNT");

        loginPage = I.get().initPage(LoginPage.class);
        loginPage.goToLoginFromMyAccount();

        loginPage.login();
    }

    @Then("^validate is user not logged$")
    public void validate_is_user_not_logged() {
        loginPage = I.get().initPage(LoginPage.class);
        assertThat(loginPage.isUserLogged()).isFalse();

        I.get().takeScreenshot("validate user not logged");
    }

    @Then("^validate is user not logged from shopping cart$")
    public void validate_is_user_not_logged_from_shopping_cart() {
        loginPage = I.get().initPage(LoginPage.class);
        assertThat(loginPage.isUserLoggedFromShoppingCart()).isFalse();
    }

    @When("^close login screen$")
    public void close_login_screen() {
        loginPage = I.get().initPage(LoginPage.class);
        loginPage.closeLoginScreen();
    }

    @Then("^validate successfull login$")
    public void validate_successfull_login() {
        MyAccountPage myAccountPage = I.get().initPage(MyAccountPage.class);

        String userName = myAccountPage.getUserName();
        assertThat(userName).isEqualTo(EnvVars.getEnvVar("USER_NAME"));

        I.get().takeScreenshot("validate login successfull");
    }
}