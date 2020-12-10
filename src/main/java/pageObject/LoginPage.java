package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	

	@FindBy(css="[type='email']")
	WebElement Username;
	
	@FindBy(css="[type='password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath="//a[@class='link-below-button']")
	WebElement ForgotPassword;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement userName()
	{
		return Username;
	}
	
	public WebElement password() 
	{
		return Password;
	}
	
	public WebElement submit() 
	{
		return submit;
	}
	
	public ForgotPasswordPage forgotPassword()
	{
		ForgotPassword.click();
		return new ForgotPasswordPage(driver);
		
	}
	
	

}
