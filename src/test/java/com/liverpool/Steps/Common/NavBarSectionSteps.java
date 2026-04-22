package com.liverpool.Steps.Common;

import com.liverpool.Actor.I;
import com.liverpool.Pages.Commons.NavBarSection;
import io.cucumber.java.en.When;

public class NavBarSectionSteps {

    @When("^access to navbar section (START|EXPLORE|CREDIT_SAVING|SERVICES|MY_ACCOUNT)$")
    public void access_to_navbar_section(String _navBarSection) {
        NavBarSection navBarSection = I.get().initPage(NavBarSection.class);
        navBarSection.accessToNavBarSection(_navBarSection);
    }
}