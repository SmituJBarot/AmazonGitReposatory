package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.MusicInstrumentPage;
import pages.ElectronicPage;
import pages.HomePage;

public class ElectronicPageTest extends TestBase{
	
	ElectronicPage ep;
	HomePage hp;
	MusicInstrumentPage mp;
	
	ElectronicPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		Initialization();
		
		ep = new ElectronicPage();
		hp = new HomePage();
		mp = new MusicInstrumentPage();
		hp.clickOnElectronicsLink();
	}
	
	@AfterMethod
	public void endUp() {
		driver.quit();
	}

	@Test(priority=1)
	public void validateElectronicPageTitle() {
		String title = ep.validatePageTitle();
		Assert.assertEquals(title, "Electronics: Amazon.ca");
	}
	
	@Test(priority=2)
	public void getAllLinksFromDropDOwnTest() {
		ep.getAllLinksFromDropDOwn();
	}
	
	@Test(priority=3)
	public void scrolldownClickOnMusicInstrumentTest() {
		mp = ep.scrolldownClickOnMusicInstrument();
	}
	
	@Test(priority=4)
	public void verifyElectronicImgTest() {
		boolean img = ep.verifyElectronicImg();
		Assert.assertTrue(img);
	}
}

