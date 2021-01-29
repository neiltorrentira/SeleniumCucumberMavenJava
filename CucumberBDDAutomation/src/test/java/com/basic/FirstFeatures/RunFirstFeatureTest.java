package com.basic.FirstFeatures;

//import java.io.File;
//import org.junit.AfterClass;
import org.junit.runner.RunWith;
//import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions; 

@RunWith(Cucumber.class)
@CucumberOptions(
					monochrome = true,
					//tags = "@Important and @Smoke and @Regression",
					//dryRun = true,
					features = "src/test/resources/com/basic/FirstFeature/",
					glue = "com.basic.FirstFeatures",
					plugin = {"pretty",
							"summary",
                            "html:target/cucumber-htmlreport-FirstFeatures.html",
                            "json:target/cucumber-report-FirstFeatures.json",
                            //"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport-FirstFeature.html"
                            }) 

public class RunFirstFeatureTest {
	/*
	 * @AfterClass public static void writeExtentReport() {
	 * Reporter.loadXMLConfig(new File("config/report.xml")); }
	 */
}
