package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {
	// this will contain...
	// will have constructor
	// will have webElement methods
	// will have all user define methods

	WebDriver driver;

	public BasePage(WebDriver driver) // constructor
	{
		this.driver = driver;
	}

		
}
