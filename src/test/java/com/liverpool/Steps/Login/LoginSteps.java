package com.liverpool.Steps.Login;

import com.liverpool.Actor.I;
import com.liverpool.Pages.Commons.ListPage;
import com.liverpool.Pages.Home.HomePage;
import com.liverpool.Pages.Login.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    @When("^login to the app$")
    public void login_to_the_app(String product) {
        HomePage homePage = I.get().initPage(HomePage.class);
        homePage.searchProduct(product);

        ListPage listPage = I.get().initPage(ListPage.class);
        listPage.validateElementList();
    }

    @Then("^validate is user not logged$")
    public void validate_is_user_not_logged() {
        LoginPage loginPage = I.get().initPage(LoginPage.class);
        assertThat(loginPage.isUserLogged()).isFalse();
    }

    @Then("^validate is user not logged from shopping cart$")
    public void validate_is_user_not_logged_from_shopping_cart() {
        LoginPage loginPage = I.get().initPage(LoginPage.class);
        assertThat(loginPage.isUserLoggedFromShoppingCart()).isFalse();
    }

    @When("^close login screen$")
    public void close_login_screen() {
        LoginPage loginPage = I.get().initPage(LoginPage.class);
        loginPage.closeLoginScreen();
    }
}