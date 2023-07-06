package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterPageTest extends TestBase{

	RegisterPage rp;
	HomePage hp;
	LoginPage lp;


	public RegisterPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		Initialization();
		rp = new RegisterPage();
		hp = new HomePage();
		hp.clickOnSignInLink();
		lp = new LoginPage();
		lp.clickOnCreateNewAccount();	
	}
	
	@AfterMethod
	public void endUp() {
		driver.quit();
	}

	@Test(priority = 1)
	public void validateRegisterPageTitle() {
		String title = rp.validatePageTitle();
		Assert.assertEquals(title, "Amazon Registration");
	}
	
	@Test(priority = 2)
	public void createNewAccountTest() {
		lp = rp.createNewAccount(prop.getProperty("name"), prop.getProperty("id"), prop.getProperty("pass"), prop.getProperty("pass"));
	}


}
