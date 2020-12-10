package End_to_End.Section_29;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.base;

public class validate_HomeButton extends base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(validate_HomeButton.class.getName());

	@BeforeTest
	public void Initialize() throws IOException
	{
		driver = intializationBrowser();
	}
	
	@Test
	public void ValidateHomeButton()
	{
		driver.get(prop.getProperty("url"));
		
		LandingPage landp = new LandingPage(driver);
		Assert.assertTrue(landp.HomeButton().isDisplayed());
		log.info("Home Button Verified!");
	}
	
	@AfterTest
	public void terminate()
	{
		driver.close();
	}
}
