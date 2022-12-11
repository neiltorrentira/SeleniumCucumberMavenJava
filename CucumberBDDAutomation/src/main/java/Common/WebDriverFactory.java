package Common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.time.Duration;
import java.util.Objects;

public class WebDriverFactory {
	public String browser;
	public static WebDriver driver = null;
	private final static Logger logger = LoggerFactory.getLogger(WebDriverFactory.class);

	public static WebDriver getWebDriver() {
		return Objects.requireNonNull(driver);
	}

	/*@BeforeClass(alwaysRun = true)
	//@BeforeStep
	@Parameters({"browser"})
	public WebDriver setupBrowser(String browser){
		this.browser = browser;
		logger.info("SetDriver : "+ browser +" browser | Class : "
				+ this.getClass().getName());

		switch (browser) {
			case "Chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "Edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			default:
				throw new IllegalStateException("Wrong browser to Setup :" + browser);
		}
		//opensHomePage(website);
		return driver;
	}*/

	@BeforeStep
	public org.openqa.selenium.WebDriver Setup() {
		if(driver==null) {
			/*System.setProperty("webdriver.chrome.driver", "D:\\seleniumBrowsers\\chromedriver.exe");
			driver = new ChromeDriver();
			//Applied wait time
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//maximize window
			driver.manage().window().maximize();
			//TimeUnit.SECONDS.sleep(4);
			TimeUnit.SECONDS.sleep(1);*/

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;		
	}

	public static void prepareBrowser(){
		getWebDriver().manage().window().maximize();
		getWebDriver().manage().deleteAllCookies();
		getWebDriver().manage().timeouts()
				.pageLoadTimeout(Duration.ofSeconds(10));
		getWebDriver().manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(10));
	}
	
	//@AfterStep
	//@AfterClass(alwaysRun = true)
	public void CloseBrowser(){
		 //TimeUnit.SECONDS.sleep(1);
		// Close the driver
		 driver.quit();
		 //driver.close();
		 driver = null;
		 System.out.println("\nDriver/Browser is Closed!\n");
	}

}
