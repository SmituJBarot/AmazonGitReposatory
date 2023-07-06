package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.ElectronicPage;
import pages.HomePage;
import pages.KeyBoardPage;
import pages.MusicInstrumentPage;

public class MusicInstrumentPageTest extends TestBase{
	
	
	ElectronicPage ep;
	MusicInstrumentPage mp;
	HomePage hp;
	KeyBoardPage kp;
	
	public MusicInstrumentPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		Initialization();
		
		mp = new MusicInstrumentPage();
		ep = new ElectronicPage();
		hp = new HomePage();
		kp = new KeyBoardPage();
		hp.clickOnElectronicsLink();
		ep.scrolldownClickOnMusicInstrument();
	}
	
	@AfterMethod
	public void endUp() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void validateMusicInstrumentPageTitle() {
		String title = mp.validatePageTitle();
		Assert.assertEquals(title, "Amazon.ca: Musical Instruments, Stage & Studio");
	}

	@Test(priority=2)
	public void clickOnKeyboardPianoTest() {
		kp = mp.clickOnKeyboardPiano();
	}
	
	@Test(priority=3)
	public void getAllHeaderLinksTest() {
		mp.getAllHeaderLinks();
	}
}
