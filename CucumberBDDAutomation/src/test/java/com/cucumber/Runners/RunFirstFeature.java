package com.cucumber.Runners;

import Common.WebDriverFactory;
import Helpers.Helper;
import io.cucumber.java.BeforeStep;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@RunWith(Cucumber.class)
@CucumberOptions(
					monochrome = true,
					//tags = "@Important and @Smoke and @Regression",
					//dryRun = true,
					features = "src/test/java/com/cucumber/FeatureFiles/",
					glue = "StepsDefinitions",
					plugin = {"pretty",
							/*"summary",
                            "html:target/cucumber-htmlreport-FirstFeatures.html",
                            "json:target/cucumber-report-FirstFeatures.json",*/
                            //"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport-FirstFeature.html"
							"html:target/cucumber-reports/cucumber-pretty",
							"json:target/cucumber-reports/CucumberTestReport.json",
							"rerun:target/cucumber-reports/rerun.txt"
                            }) 

public class RunFirstFeature {
	/*
	 * @AfterClass public static void writeExtentReport() {
	 * Reporter.loadXMLConfig(new File("config/report.xml")); }
	 */
	//private final static Logger logger = LoggerFactory.getLogger(RunFirstFeature.class);

	//@BeforeStep
	/*@BeforeClass(alwaysRun = true)
	@Parameters({"browser"})
	public void setDriver(String browser){
		this.browser = browser;
		logger.info("SetDriver : "+ browser +" browser "
				+ " | With Cucumber Runner : " + this.getClass().getName());
		setupBrowser(this.browser);
	}*/

}
