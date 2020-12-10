package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	
	WebDriver driver;
	By email = By.cssSelector("[id='user_email']");
	By instructions = By.cssSelector("[type='submit']");
	
	public ForgotPasswordPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement Email()
	{
		return driver.findElement(email);
	}
	
	public WebElement Instructions()
	{
		return driver.findElement(instructions);
	}
	
	

}
