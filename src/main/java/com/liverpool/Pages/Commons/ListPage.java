package com.liverpool.Pages.Commons;

import com.liverpool.Actor.IActions;
import com.liverpool.Utils.MobileElement;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class ListPage {

    public ListPage(IActions I) {
        this.I = I;
    }

    private final IActions I;
    static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

    MobileElement elementList = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/constraint_plp_grid_item");
    MobileElement elementBrandList = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/textBrand");
    MobileElement elementPricingList = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/range_price_horizontal");

    MobileElement filterBtn = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/text_filter_plp");
    MobileElement filterOption = MobileElement.forAndroid("//*[@resource-id='mx.com.liverpool.shoppingapp:id/text_name_filter_type' and @text='Marcas']");
    MobileElement inputFilter = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/text_edit");
    MobileElement filterOptions = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/text_label_option_filter_item");
    MobileElement applyFilter = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/button_apply_filter_drawer");

    MobileElement sortBtn = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/text_sort_plp");
    MobileElement sortByRelevant = MobileElement.forAndroid("android=new UiSelector().text(\"Relevancia\")");
    MobileElement sortByNewest = MobileElement.forAndroid("android=new UiSelector().text(\"Lo Más Nuevo\")");
    MobileElement sortByLeastToGreatest = MobileElement.forAndroid("android=new UiSelector().text(\"Menor precio\")");
    MobileElement sortByGreatestToLeast = MobileElement.forAndroid("android=new UiSelector().text(\"Mayor precio\")");
    MobileElement sortByQualifications = MobileElement.forAndroid("android=new UiSelector().text(\"Calificaciones\")");

    public void validateElementList() {
        LOGGER.info("Validate list elements");
        I.waitForDisplayed(elementList);
    }

    public void selectFirstElementInList() {
        LOGGER.info("Select first element in list");
        this.validateElementList();
        List<WebElement> elementsList = I.grabAllElements(elementList);
        elementsList.stream().findFirst().get().click();
    }

    public void addFilterToList(String specificFilter) {
        LOGGER.info("Apply filter by brand");
        I.tap(filterBtn);

        I.tap(filterOption);

        I.waitForDisplayed(inputFilter);
        I.fillField(inputFilter, specificFilter);

        I.waitForDisplayed(filterOptions);
        List<WebElement> filtersListElement = I.grabAllElements(filterOptions);

        for (WebElement filter : filtersListElement) {
            if (filter.getText().toUpperCase().contains(specificFilter.toUpperCase())) {
                filter.click();
                break;
            }
        }

        I.waitForDisplayed(applyFilter);
        I.tap(applyFilter);
    }

    public List<WebElement> getAllElementBrandsFromList() {
        LOGGER.info("Get all list elements");
        this.validateElementList();

        return I.grabAllElements(elementBrandList);
    }

    public void sortListBy(String sort) {
        LOGGER.info("Sort by: {}", sort.toUpperCase());

        I.waitForTime(5);
        I.waitForElementToBeClickable(sortBtn);
        I.tap(sortBtn);

        switch (sort.toUpperCase()) {
            case "RELEVANT" -> {
                I.waitForDisplayed(sortByRelevant);
                I.tap(sortByRelevant);
            }
            case "NEWEST" -> {
                I.waitForDisplayed(sortByNewest);
                I.tap(sortByNewest);
            }
            case "LEAST_TO_GREATEST" -> {
                I.waitForDisplayed(sortByLeastToGreatest);
                I.tap(sortByLeastToGreatest);
            }
            case "GREATEST_TO_LEAST" -> {
                I.waitForDisplayed(sortByGreatestToLeast);
                I.tap(sortByGreatestToLeast);
            }
            case "QUALIFICATIONS" -> {
                I.waitForDisplayed(sortByQualifications);
                I.tap(sortByQualifications);
            }
        }
    }

    public List<WebElement> getAllElementsPricingFromList() {
        LOGGER.info("Validate sort applied in list elements");
        this.validateElementList();

        return I.grabAllElements(elementPricingList);
    }
}