package com.liverpool.Steps.Home;

import com.liverpool.Actor.I;
import com.liverpool.Pages.Home.HomePage;
import com.liverpool.Pages.Commons.ListPage;
import io.cucumber.java.en.When;

public class HomeSteps {

    @When("^perform a product search (.*)$")
    public void perform_a_product_search(String product) {
        HomePage homePage = I.get().initPage(HomePage.class);
        homePage.searchProduct(product);

        ListPage listPage = I.get().initPage(ListPage.class);
        listPage.validateElementList();
    }
}