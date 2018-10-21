package Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	// This will contain
	// the methods before every test ... where we will be launching browser and getting the url
	
	
	WebDriver driver;
	Properties prop;

	@BeforeSuite
	public  WebDriver InitBrowser() // this will initate browswer and retuns driver instance
	{
		System.out.println("1");
		prop = InitProperties();
		
		String myBrowser = prop.getProperty("browser");
		System.out.println(" Using browser ==> " + myBrowser);
		
		if (driver == null) // checks for the driver if already initiated.
		{
			if (myBrowser.equalsIgnoreCase("chrome")) {
				System.out.println("2");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resource\\drivers\\chromedriver.exe");
				System.out.println("3");
				driver = new ChromeDriver();
				System.out.println("4");
			} else if (myBrowser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\src\\main\\resource\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();

			} else {
				System.out.println("Other browser are not ready yet !!!");
			}
			driver.get(prop.getProperty("url"));
		}

		return driver;
	}

	public  Properties InitProperties() {
		prop = new Properties();

		System.out.println("Path of user dir --> " + System.getProperty("user.dir"));
		try {
			FileInputStream fip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resource\\data\\config.properties");
			prop.load(fip); // this is to load the fip
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.getMessage();
		}
		return prop;
		
	}
	
	@AfterSuite
	public void tearDown() throws InterruptedException
	{
		if(driver != null)
		{
			Thread.sleep(5000);
			driver.quit();
			
		}
		
	}
	
	
	
	
}


