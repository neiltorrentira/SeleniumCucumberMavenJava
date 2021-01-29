package com.basic.FirstFeatures;

import com.basic.SharedClass.WebDriverClass;
//import org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GoogleSearch {

WebDriver driver;

	public GoogleSearch (WebDriverClass openBrowser) throws InterruptedException {
		driver = openBrowser.Setup();
	}
	
	@Test
	@Given("^Open Google$")
	public void open_google_test() throws InterruptedException {

		TimeUnit.SECONDS.sleep(1);
		//Launch the Online Store Website
		driver.get("https://www.google.com");			
	}
	
	@Test
	@When("^User enter \"([^\"]*)\" search text$")
	public void user_enter_search_text_test(String searchString) throws InterruptedException {
		// Print a Log In message to the screen
		 System.out.println("\nSuccessfully opened the website www.google.com\n");
		 TimeUnit.SECONDS.sleep(1);
		 driver.findElement(By.name("q")).sendKeys(searchString);
		 driver.findElement(By.name("q")).sendKeys(Keys.ENTER);		 
	}
	
	@Test
	@Then("^User validate \"([^\"]*)\" search text is present$")
	public void user_validate_search_text_is_present_test(String searchString) throws InterruptedException {
		//Wait for 5 Sec
		 TimeUnit.SECONDS.sleep(1);
		 //Thread.sleep(3000);

		 String searchTextActual = driver.findElement(By.name("q")).getAttribute("value");
		 assertEquals(searchString, searchTextActual);
		 System.out.println("\nSearch text: " + searchTextActual + " is Found!\n");
		 TimeUnit.SECONDS.sleep(1);
		 
		 driver.findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]/div[3]/a")).click();
		 System.out.println("\nSuccessfully clicked Images\n");
	}
	

	@Then("^User Close Browser$")
	public void CloseBrowser() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1); 
		// Close the driver 
		driver.close(); driver = null; 
	}
	 
	
}
