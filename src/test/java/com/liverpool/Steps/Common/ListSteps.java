package com.liverpool.Steps.Common;

import com.liverpool.Actor.I;
import com.liverpool.Pages.Commons.ListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ListSteps {

    ListPage listPage;

    @And("^filter by (.*) brand$")
    public void filter_by_brand(String brand) {
        listPage = I.get().initPage(ListPage.class);
        listPage.addFilterToList(brand);
    }

    @Then("^valid that filter brand (.*) is applied correctly$")
    public void valid_that_filter_brand_is_applied_correctly(String brand) {
        listPage = I.get().initPage(ListPage.class);
        listPage.validateFilterAppliedinElementList(brand);
        I.get().scrollDown();
        listPage.validateFilterAppliedinElementList(brand);
    }

    @And("^sort by (RELEVANT|NEWEST|LEAST_TO_GREATEST|GREATEST_TO_LEAST|QUALIFICATIONS)$")
    public void sort_by(String sort) {
        listPage = I.get().initPage(ListPage.class);
        listPage.sortListBy(sort);
    }

    @Then("^valid that sort by pricing (LEAST_TO_GREATEST|GREATEST_TO_LEAST) is applied correctly$")
    public void valid_that_sort_is_applied_correctly(String sort) {
        listPage = I.get().initPage(ListPage.class);
        listPage.validateSortAppliedinElementList(sort);
        I.get().scrollDown();
        listPage.validateSortAppliedinElementList(sort);
    }
}