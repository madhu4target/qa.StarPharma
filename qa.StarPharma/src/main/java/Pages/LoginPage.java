package Pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;

public class LoginPage extends BasePage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		
		super(driver);

	}



	@FindBy(xpath = "//input[@id='username']") WebElement txtUserName;
	@FindBy(how = How.XPATH, using = "//input[@id='password']") WebElement txtPassWord;
	@FindBy(how = How.XPATH, using = "//input[@id='Login']") WebElement btnLogin;
	

	
	public HomePage LoginCredentialsEnter(String LocalUname, String LocalPassword)
	{
		txtUserName.sendKeys(LocalUname);
		//txtPassWord.sendKeys(prop.getProperty("password")); -- error
		txtPassWord.sendKeys(LocalPassword);
		btnLogin.click();
		
		return new HomePage(driver);
	}
	
}	


