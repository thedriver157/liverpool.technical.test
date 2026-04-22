package com.liverpool.Runners;

import io.cucumber.testng.*;
import org.testng.annotations.*;

@CucumberOptions(
        features = "src/test/resources/Features/",
        glue = { "com.liverpool.Steps", "com.liverpool.Hooks" },
        plugin = { "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }
)

public class TestRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumberScenarios", description = "Run Cucumber Scenarios", dataProvider = "scenarios")
    public void cucumberScenarios(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        if (testNGCucumberRunner == null) {
            return new Object[0][0];
        }

        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (testNGCucumberRunner == null) {
            return;
        }

        testNGCucumberRunner.finish();
    }
}