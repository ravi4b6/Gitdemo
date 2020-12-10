package End_to_End.Section_29;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPasswordPage;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class Credentials extends base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Credentials.class.getName());
	
	@BeforeTest
	public void initialization() throws IOException
	{
		driver = intializationBrowser();
		log.info("Browser Initialized!");
	}
	
	@Test(dataProvider = "getData")
	public void HomePage(String UserName, String Password, String Text)
	{
		driver.get(prop.getProperty("url"));
		log.info("Entered the website");
		
		LandingPage landp = new LandingPage(driver);
		LoginPage loginp = landp.Login();
		log.info("Clicked on the login button");

	
		loginp.userName().sendKeys(UserName);
		log.info("Entered the Username");
		loginp.password().sendKeys(Password);
		log.info("Entered the password");
		log.info(Text);
		loginp.submit().click();
		log.info("Submitted");
		
		ForgotPasswordPage fp = loginp.forgotPassword();
		fp.Email().sendKeys("adfdfasf");
		fp.Instructions().click();
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];
		data[0][0] = "Restricted_User@Gmail.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted User";
		
		data[1][0] = "Unrestricted User";
		data[1][1] = "789101112";
		data[1][2] = "Unrestricted User";
		
		return data;
	}
	
	@AfterTest
	public void terminate()
	{
		driver.close();
	}
	
	
}
