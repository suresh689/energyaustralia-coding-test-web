package com.LMG.web.runner;


import com.google.common.collect.ClassToInstanceMap;
//import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.junit.runner.RunWith;
import org.testng.annotations.*;

import java.io.*;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
        glue = {"com.LMG.web.stepdefinitions"},
        dryRun = false,
        monochrome = true,
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-reports/file.html","json:target/cucumber-reports/Cucumber.json",
        },
       tags = {"@Home"}

)

public class CucumberTest {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs cucumber Features", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideFeatures();
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)

    public void testDownClass() {

        testNGCucumberRunner.finish();
    }

}








