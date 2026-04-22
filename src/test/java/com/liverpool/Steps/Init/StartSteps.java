package com.liverpool.Steps.Init;

import com.liverpool.Actor.I;
import com.liverpool.Pages.Init.StartPage;
import io.cucumber.java.en.Given;

public class StartSteps {

    @Given("^try to close the compatibility alert window and permissions$")
    public void try_close_the_compatibility_alert_window_and_permissions() {
        StartPage startPage = I.get().initPage(StartPage.class);
        startPage.closeCompatibilityAlertWindow();
        startPage.allowTrackingPermissions();
        startPage.skipTutorial();
    }
}