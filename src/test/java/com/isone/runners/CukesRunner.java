package com.isone.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
//                "io.qameta.allure.cucumberjunit.AllureCucumberJUnit", // Allure plugin
        },
        features="src/test/resources/features",
        glue= "com/isone/step_defs",
        dryRun = false,
        tags="@home",
       publish = true
)

public class CukesRunner {

}
