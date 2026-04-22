package com.liverpool.Pages.List;

import com.liverpool.Actor.IActions;
import com.liverpool.Utils.MobileElement;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListPage {

    public ListPage(IActions I) {
        this.I = I;
    }

    private final IActions I;
    static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

    MobileElement elementList = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/constraint_plp_grid_item");
    MobileElement elementBrandList = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/textBrand");
    MobileElement filterBtn = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/text_filter_plp");
    MobileElement filterOption = MobileElement.forAndroid("//*[@resource-id='mx.com.liverpool.shoppingapp:id/text_name_filter_type' and @text='Marcas']");
    MobileElement inputFilter = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/text_edit");
    MobileElement filterOptions = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/text_label_option_filter_item");
    MobileElement applyFilter = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/button_apply_filter_drawer");

    public void validateElementList() {
        LOGGER.info("Validate List Elements");
        I.waitForDisplayed(elementList);
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

    public void validateFilterAppliedinElementList(String brand) {
        LOGGER.info("Validate Applied in List Elements");
        this.validateElementList();

        List<WebElement> elementListBrand = I.grabAllElements(elementBrandList);
        assertThat(elementListBrand)
                .extracting(WebElement::getText)
                .contains(brand.toUpperCase());
    }
}