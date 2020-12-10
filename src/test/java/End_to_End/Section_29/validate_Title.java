package End_to_End.Section_29;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.base;

public class validate_Title extends base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(validate_Title.class.getName());
	
	@BeforeTest
	public void Initialize() throws IOException
	{
		driver = intializationBrowser();
	}
	
	@Test
	public void Validation() 
	{
		driver.get(prop.getProperty("url"));
		LandingPage landingp = new LandingPage(driver);
		
		Assert.assertEquals(landingp.Title().getText(), "FEATURED123 COURSES");
		log.info("Title Verified");
		
	}
	
	@AfterTest
	public void terminate() 
	{
		driver.close();
	}

}
