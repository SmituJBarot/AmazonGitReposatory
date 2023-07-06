package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AmazonPage;
import pages.ElectronicPage;
import pages.HomePage;
import pages.KeyBoardPage;
import pages.MusicInstrumentPage;
import pages.PianoPage;

public class AmazonPageTest extends TestBase{

	MusicInstrumentPage mp;
	PianoPage pp;
	AmazonPage ap;
	HomePage hp;
	ElectronicPage ep;
	KeyBoardPage kp;
	
	public AmazonPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		Initialization();
		
		mp = new MusicInstrumentPage();
		hp = new HomePage();
		ep = new ElectronicPage();
		ap = new AmazonPage();
		pp = new PianoPage();
		kp = new KeyBoardPage();
		hp.clickOnElectronicsLink();
		ep.scrolldownClickOnMusicInstrument();
		mp.clickOnKeyboardPiano();
		kp.clickOnfolktool();
	}
	
	@AfterMethod
	public void endUp() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyPageTitle() {
		String title = ap.validatePageTitle();
		Assert.assertEquals(title, "Amazon.ca");
	}
	
	@Test (priority = 2)
	public void seleciMinMaxValueForItemTest() {
	  ap.seleciMinMaxValueForItem(prop.getProperty("minvalue"), prop.getProperty("maxvalue"));
	}
	
	@Test (priority = 3)
	public void finilizeItemPianoTest() {
		pp = ap.selectItemPiano();
	}
}

