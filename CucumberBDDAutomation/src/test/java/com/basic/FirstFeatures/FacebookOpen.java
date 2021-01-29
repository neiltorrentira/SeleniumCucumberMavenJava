package com.basic.FirstFeatures;

import com.basic.SharedClass.WebDriverClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FacebookOpen {

	WebDriver driver;
	
	public FacebookOpen (WebDriverClass openBrowser) throws InterruptedException {
		driver = openBrowser.Setup();
	}
	
	@Test
	@Given("^Open Facebook$")
	public void open_facebook_test() throws InterruptedException {

		TimeUnit.SECONDS.sleep(1);
		//Launch the Online Store Website
		driver.get("https://www.facebook.com");			
	}
	
	@Test
	@When("^User click Create New Account$")
	public void user_enter_search_text_test() throws InterruptedException {
		// Print a Log In message to the screen
		 System.out.println("\nSuccessfully opened www.Facebook.com\n");
		 TimeUnit.SECONDS.sleep(1);
		 driver.findElement(By.xpath("//*[@id=\"u_0_2\"]")).click();	 
	}
	
	@Test
	@And("^User enters \"([^\"]*)\" first name$")
	public void user_enter_firstname_test(String searchString1) throws InterruptedException {

		 TimeUnit.SECONDS.sleep(1);
		 driver.findElement(By.name("firstname")).sendKeys(searchString1);
	}
	
	@Test
	@And("^User enters Firstname \"([^\"]*)\" and lastname \"([^\"]*)\"$")
	public void user_enter_firstname_lastname_test(String searchString1, String searchString2) throws InterruptedException {

		 TimeUnit.SECONDS.sleep(1);
		 driver.findElement(By.name("firstname")).sendKeys(searchString1);
		 driver.findElement(By.name("lastname")).sendKeys(searchString2);
	}
	
	@Test
	@Then("^User validate Firstname \"([^\"]*)\"$")
	public void user_validate_firstname_test(String searchString1) throws InterruptedException {

		 TimeUnit.SECONDS.sleep(1);
		 String searchTextActual1 = driver.findElement(By.name("firstname")).getAttribute("value");
		 assertEquals(searchString1, searchTextActual1);
		 System.out.println("\nSearch text: " + searchTextActual1 + " is Found!\n");
	}
	
	@Test
	@Then("^User validate Firstname \"([^\"]*)\" and lastname \"([^\"]*)\"$")
	public void user_validate_firstname_lastname_test(String searchString1, String searchString2) throws InterruptedException {

		 TimeUnit.SECONDS.sleep(1);
		 String searchTextActual1 = driver.findElement(By.name("firstname")).getAttribute("value");
		 assertEquals(searchString1, searchTextActual1);
		 System.out.println("\nSearch text: " + searchTextActual1 + " is Found!\n");
		 
		 String searchTextActual2 = driver.findElement(By.name("lastname")).getAttribute("value");
		 assertEquals(searchString2, searchTextActual2);
		 System.out.println("\nSearch text: " + searchTextActual2 + " is Found!\n");
	}
	
	
	@Then("^User Closes Browser$")
	public void ClosesBrowser() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1); 
		// Close the driver 
		driver.close(); driver = null; 
	}
	
}
