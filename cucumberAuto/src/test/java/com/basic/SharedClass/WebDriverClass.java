package com.basic.SharedClass;

//import org.junit.Before;
//import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.edge.EdgeDriver;


public class WebDriverClass {
	
	WebDriver driver;
	
	@BeforeStep
	public WebDriver Setup() throws InterruptedException {
		if(driver==null) {
			System.setProperty("webdriver.chrome.driver", "D:\\seleniumBrowsers\\chromedriver.exe");
			driver = new ChromeDriver();
			//Applied wait time
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//maximize window
			driver.manage().window().maximize();
			//TimeUnit.SECONDS.sleep(4);
			TimeUnit.SECONDS.sleep(1);
		}
		return driver;		
	}
	
	@AfterStep
	public void CloseBrowser(){
		 //TimeUnit.SECONDS.sleep(1);
		// Close the driver
		 driver.quit();
		 //driver.close();
		 driver = null;
		 System.out.println("\nDriver/Browser is Closed!\n");
	}

}
