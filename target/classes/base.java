package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver intializationBrowser() throws IOException 
	{

		prop = new Properties();
		String user = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(user+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		//String browserName = System.getProperty("browser");
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", user+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions coptions = new ChromeOptions();
			if(browserName.contains("headless"))
			{
				coptions.addArguments("headless");
				
			}
			driver = new ChromeDriver(coptions);
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", user+"\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if(browserName.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", user+"\\src\\main\\java\\resources\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	
	
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		
		return destinationFile;
	}
	
	
}
