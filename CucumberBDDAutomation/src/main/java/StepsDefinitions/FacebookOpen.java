package StepsDefinitions;

import Common.WebDriverFactory;
import Helpers.Helper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import static Common.WebDriverFactory.driver;

public class FacebookOpen {
	//org.openqa.selenium.WebDriver driver;
	public FacebookOpen (WebDriverFactory openBrowser){
		driver = openBrowser.Setup();
	}
	
	@Given("Open Facebook")
	public void open_facebook() throws InterruptedException {
		//setupBrowser("Edge");
		TimeUnit.SECONDS.sleep(1);
		//Launch the Online Store Website
		//driver.get("https://www.facebook.com");
		Helper.gotoUrl("https://www.facebook.com");
		WebDriverFactory.prepareBrowser();
	}
	
	@When("User click Create New Account")
	public void user_enter_search_text() throws InterruptedException {
		// Print a Log In message to the screen
		 System.out.println("\nSuccessfully opened www.Facebook.com\n");
		 TimeUnit.SECONDS.sleep(1);
		 //driver.findElement(By.xpath("//*[@id=\"u_0_2\"]")).click();
	}
	
	
	@And("User enters \"([^\"]*)\" first name")
	public void user_enter_firstname(String searchString1) throws InterruptedException {

		 TimeUnit.SECONDS.sleep(1);
		 driver.findElement(By.name("firstname")).sendKeys(searchString1);
	}
	
	@And("User enters Firstname \"([^\"]*)\" and lastname \"([^\"]*)\"")
	public void user_enter_firstname_lastname(String searchString1, String searchString2) throws InterruptedException {

		 TimeUnit.SECONDS.sleep(1);
		 driver.findElement(By.name("firstname")).sendKeys(searchString1);
		 driver.findElement(By.name("lastname")).sendKeys(searchString2);
	}
	
	
	@Then("^User validate Firstname \"([^\"]*)\"$")
	public void user_validate_firstname(String searchString1) throws InterruptedException {

		 TimeUnit.SECONDS.sleep(1);
		 String searchTextActual1 = driver.findElement(By.name("firstname")).getAttribute("value");
		 Assert.assertEquals(searchString1, searchTextActual1);
		 System.out.println("\nSearch text: " + searchTextActual1 + " is Found!\n");
	}
	
	@Then("^User validate Firstname \"([^\"]*)\" and lastname \"([^\"]*)\"$")
	public void user_validate_firstname_lastname(String searchString1, String searchString2) throws InterruptedException {

		 TimeUnit.SECONDS.sleep(1);
		 String searchTextActual1 = driver.findElement(By.name("firstname")).getAttribute("value");
		 Assert.assertEquals(searchString1, searchTextActual1);
		 System.out.println("\nSearch text: " + searchTextActual1 + " is Found!\n");
		 
		 String searchTextActual2 = driver.findElement(By.name("lastname")).getAttribute("value");
		 Assert.assertEquals(searchString2, searchTextActual2);
		 System.out.println("\nSearch text: " + searchTextActual2 + " is Found!\n");
	}
	
	
	@Then("^User Closes Browser$")
	public void ClosesBrowser() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1); 
		// Close the driver 
		driver.quit();
		driver = null;

	}
	
}
