package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	WebDriver driver;
	private By login = By.cssSelector("[href*='sign_in']");
	private By homeButton = By.cssSelector("li[class='active'] a");
	private By title = By.cssSelector("div[class='text-center'] h2");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public LoginPage Login()
	{
		driver.findElement(login).click();
		LoginPage loginp = new LoginPage(driver);
		return loginp;
	}
	
	public WebElement HomeButton()
	{
		return driver.findElement(homeButton);
	}
	
	public WebElement Title()
	{
		return driver.findElement(title);
	}

}
