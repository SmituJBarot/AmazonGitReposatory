package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.ElectronicPage;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends TestBase{
	
	HomePage hp;
	ElectronicPage ep;
	LoginPage lp;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		Initialization();
		hp = new HomePage();
		ep = new ElectronicPage();
		lp = new LoginPage();
	}

	@AfterMethod
	public void endUp() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void validateHomePageTitle() {
		String title = hp.validatePageTitle();
		Assert.assertEquals(title, "Amazon.ca: Low Prices – Fast Shipping – Millions of Items");
	}
	
	@Test(priority=2)
	public void verifyAmazonBottomLableTest() {
		boolean lable = hp.verifyAmazonBottomLable();
		Assert.assertTrue(lable);
	}
	
	@Test(priority=3)
	public void getDefaultValueFromSearchBoxTest() {
		String value = hp.getDefaultValueFromSearchBox();
		Assert.assertEquals(value, "Search Amazon.ca");
	}
	
	@Test(priority=4)
	public void getAllOptionsFromSuggestionListTest() {
		hp.getAllOptionsFromSuggestionList(prop.getProperty("input"));
	}
	
	@Test(priority=5)
	public void clickOnElectronicsLinkTest() {
		ep = hp.clickOnElectronicsLink();
	}
	
	@Test(priority=6)
	public void getAllFooterLinksTest() {
		hp.getAllFooterLinks();
	}
	
	@Test(priority=7)
	public void clickOnSignInLinkTest() {
		lp = hp.clickOnSignInLink();
	}

	@Test(priority=8)
	public void getListAfterHoverTest() {
		hp.hoverToSignInGetList();
	}
}
