package com.liverpool.Steps.Home;

import com.liverpool.Actor.I;
import com.liverpool.Pages.Home.HomePage;
import com.liverpool.Pages.List.ListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {

    ListPage listPage;

    @When("^perform a product search (.*)$")
    public void perform_a_product_search(String product) {
        HomePage homePage = I.get().initPage(HomePage.class);
        homePage.searchProduct(product);

        listPage = I.get().initPage(ListPage.class);
        listPage.validateElementList();
    }

    @And("^filter by (.*) brand$")
    public void filter_by_brand(String brand) {
        listPage.addFilterToList(brand);
    }

    @Then("^valid that the filter brand (.*) is applied correctly$")
    public void valid_that_the_filter_brand_is_applied_correctly(String brand) {
        listPage.validateFilterAppliedinElementList(brand);
        I.get().scrollDown();
        listPage.validateFilterAppliedinElementList(brand);
    }
}