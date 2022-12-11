package StepsDefinitions;

import Helpers.Helper;
import Common.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class GoogleSearch {

	public GoogleSearch (WebDriverFactory openBrowser) {
		WebDriverFactory.driver = openBrowser.Setup();
	}
	
	@Given("Open Google")
	public void open_google() throws InterruptedException {

		TimeUnit.SECONDS.sleep(1);
		//Launch the Online Store Website
		//driver.get("https://www.google.com");
		Helper.gotoUrl("https://www.google.com");
		WebDriverFactory.prepareBrowser();
	}
	
	@When("^User enter \"([^\"]*)\" search text$")
	public void user_enter_search_text(String searchString) throws InterruptedException {
		// Print a Log In message to the screen
		 System.out.println("\nSuccessfully opened the website www.google.com\n");
		 TimeUnit.SECONDS.sleep(1);
		 WebDriverFactory.driver.findElement(By.name("q")).sendKeys(searchString);
		 WebDriverFactory.driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}
	
	@Then("^User validate \"([^\"]*)\" search text is present$")
	public void user_validate_search_text_is_present(String searchString) throws InterruptedException {
		//Wait for 5 Sec
		 TimeUnit.SECONDS.sleep(1);
		 //Thread.sleep(3000);

		 String searchTextActual = WebDriverFactory.driver.findElement(By.name("q")).getAttribute("value");
		 Assert.assertEquals(searchString, searchTextActual);
		 System.out.println("\nSearch text: " + searchTextActual + " is Found!\n");
		 TimeUnit.SECONDS.sleep(1);
		 
		 //WebDriverFactory.driver.findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]/div[3]/a")).click();
		 //System.out.println("\nSuccessfully clicked Images\n");
	}
	
	@Then("^User Close Browser$")
	public void CloseBrowser() {
		// Close the driver 
		WebDriverFactory.driver.close(); WebDriverFactory.driver = null;
	}
	 
	
}
