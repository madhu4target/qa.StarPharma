package Main;

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
	// will have webelement methods
	// will have all user define methods

	static WebDriver driver;
	static Properties prop;

	public BasePage() // constructor
	{
		//InitBrowser();
		// to initiate Browser
	}

	public static WebDriver InitBrowser() // this will initate browswer and retuns driver instance
	{
		System.out.println("1");
		prop = InitProperties();
		
		String myBrowser = prop.getProperty("browser");
		System.out.println(" Using browser ==> " + myBrowser);
		
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

		return driver;
	}

	public static Properties InitProperties() {
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

	public static void main(String[] args) {

		InitBrowser();
		InitProperties();
	}

}
