package com.liverpool.Hooks;

import com.liverpool.Actor.I;
import com.liverpool.Actor.IActions;
import com.liverpool.Config.LoadConfig;
import com.liverpool.Driver.MobileDriverFactory;
import com.liverpool.Driver.MobileDriverManager;
import com.liverpool.Models.MobileConfigModel;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class Hooks {

    static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

    @Before
    public void setUp(Scenario scenario) {
        LOGGER.info("Start Scenario: {}", scenario.getName());
        MobileConfigModel mobileConfigModel = LoadConfig.getMobileConfigModel();
        MobileDriverManager mobileDriverManager = MobileDriverFactory.createDriverManager(mobileConfigModel);
        I.set(new IActions(mobileConfigModel, mobileDriverManager));
    }

    @After
    public void tearDown(Scenario scenario) {
        LOGGER.info("Finish Scenario: {}, Status: {}", scenario.getName(), scenario.getStatus());
        if (I.get() != null) {
            I.get().closeDriver();
            I.remove();
        }
    }
}