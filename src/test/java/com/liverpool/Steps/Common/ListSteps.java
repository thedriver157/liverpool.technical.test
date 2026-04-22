package com.liverpool.Steps.Common;

import com.liverpool.Actor.I;
import com.liverpool.Pages.Commons.ListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListSteps {

    ListPage listPage;

    @And("^select first element in list$")
    public void select_first_element_in_list() {
        listPage = I.get().initPage(ListPage.class);
        listPage.selectFirstElementInList();
    }

    @And("^filter by (.*) brand$")
    public void filter_by_brand(String brand) {
        listPage = I.get().initPage(ListPage.class);
        listPage.addFilterToList(brand);
    }

    @Then("^validate that filter brand (.*) is applied correctly$")
    public void validate_that_filter_brand_is_applied_correctly(String brand) {
        listPage = I.get().initPage(ListPage.class);

        List<WebElement> elementListBrand = listPage.getAllElementBrandsFromList();
        this.validateFilters(elementListBrand, brand);

        I.get().scrollDown();

        elementListBrand = listPage.getAllElementBrandsFromList();
        this.validateFilters(elementListBrand, brand);
    }

    @And("^sort by (RELEVANT|NEWEST|LEAST_TO_GREATEST|GREATEST_TO_LEAST|QUALIFICATIONS)$")
    public void sort_by(String sort) {
        listPage = I.get().initPage(ListPage.class);
        listPage.sortListBy(sort);
    }

    @Then("^validate that sort by pricing (LEAST_TO_GREATEST|GREATEST_TO_LEAST) is applied correctly$")
    public void validate_that_sort_is_applied_correctly(String sort) {
        listPage = I.get().initPage(ListPage.class);
        List<WebElement> elementListPricing = listPage.getAllElementsPricingFromList();
        this.validateSorting(sort, elementListPricing);

        I.get().scrollDown();

        elementListPricing = listPage.getAllElementsPricingFromList();
        this.validateSorting(sort, elementListPricing);
    }

    private void validateFilters(List<WebElement> elementList, String filter) {
        assertThat(elementList)
                .extracting(WebElement::getText)
                .contains(filter.toUpperCase());
    }

    private void validateSorting(String sortType, List<WebElement> elementList) {
        if (sortType.equalsIgnoreCase("LEAST_TO_GREATEST")) {
            assertThat(elementList)
                    .extracting(WebElement::getText)
                    .isSorted();
        } else {
            assertThat(elementList)
                    .extracting(WebElement::getText)
                    .isSortedAccordingTo(Comparator.reverseOrder());
        }
    }
}