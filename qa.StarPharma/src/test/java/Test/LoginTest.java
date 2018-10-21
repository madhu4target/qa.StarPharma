package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginTest extends BaseTest{
	
	//LoginPage loginPageRef = new LoginPage(driver);
	
	@Test (priority = 1)
	public void LoginPageLandingTest()
	{
		String expectedTitle = "Login | Salesforce";
		String presentTitle = driver.getTitle();
		Assert.assertEquals(presentTitle.trim(), expectedTitle.trim());  // to check on the correct landing page
	}
		
	@Test (priority = 2)
	public void validUserName()
	{
		LoginPage loginPageRef = new LoginPage(driver);
		
		//get username and password from properties and pass into loginPage
		String UName = prop.getProperty("userName");
		String Pwd = prop.getProperty("password");
		
		loginPageRef.LoginCredentialsEnter(UName, Pwd);// To pass it into loginpage using loginPageRef
		
		String presentTitle = driver.getTitle(); // after clicking on login button
		System.out.println(presentTitle);
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		
		if (presentTitle == "Verify Your Identity | Salesforce")
		{
			System.out.println("Fail -- Ending at Verification page");
		}
		Assert.assertEquals(presentTitle.trim(), expectedTitle.trim());
		
	}
	
	@Test (priority = 3)
	public void TwoStepVerificationPageTest()
	// if code verification page appears, it is failed test
	{
		
	}
	
	
	
	
	

}
