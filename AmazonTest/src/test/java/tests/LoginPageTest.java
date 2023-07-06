package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class LoginPageTest extends TestBase{

	LoginPage lp;
	HomePage hp;
	RegisterPage rp;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		Initialization();
		lp = new LoginPage();
		hp = new HomePage();
		hp.clickOnSignInLink();
		rp = new RegisterPage();
	}

	@AfterMethod
	public void endUp() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void validateLoginPageTitle() {
		String title = lp.validatePageTitle();
		Assert.assertEquals(title, "Amazon Sign In");
	}
	
	@Test(priority=2)
	public void loginWithCorrectDetailsTest() {
		hp = lp.loginWithCorrectDetails(prop.getProperty("email"), prop.getProperty("pass"));
	}
	
	@Test(priority=3)
	public void verifyAmazonLogoTest() {
		boolean logo = lp.verifyAmazonLogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority=4)
	public void verifyEmailErrTest() {
		lp.enterWrongEmail(prop.getProperty("wrongid"));
		String actualEmailErr = lp.verifyEmailErr();
		Assert.assertEquals(actualEmailErr, prop.getProperty("expectedEmailErr"), "Error Not Verify");
	}
	
	@Test(priority=5)
	public void clickOnCreateNewAccountTest() {
		rp = lp.clickOnCreateNewAccount();
	}
	
	@Test(priority=6)
	public void linkToTakeSSTest() {
		lp.linkToTakeSS();
	}
	
	@Test(priority=7)
	public void validateUserNameAfterLogInTest() {
		lp.loginWithCorrectDetails(prop.getProperty("email"), prop.getProperty("pass"));
		String userName = lp.validateUserNameAfterLogIn();
		Assert.assertEquals(userName, "Hello, Smitu");
	}
	
}
