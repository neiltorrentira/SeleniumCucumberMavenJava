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
					tags = "@Smoke and @Regression",
					dryRun = false,
					features = "src/test/resources/com/basic/FirstFeature/",
					glue = "com.basic.FirstFeatures",
					plugin = {"pretty",
							"summary",
                            "html:target/cucumber-htmlreport-FirstFeature.html",
                            "json:target/cucumber-report-FirstFeature.json",
                            //"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport-FirstFeature.html"
                            }) 

public class RunGoogleSearch {
	/*
	 * @AfterClass public static void writeExtentReport() {
	 * Reporter.loadXMLConfig(new File("config/report.xml")); }
	 */
}
