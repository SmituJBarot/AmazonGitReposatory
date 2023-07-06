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
import pages.ShoppingPage;

public class KeyBoardPageTest extends TestBase{
	
	MusicInstrumentPage mp;
	PianoPage pp;
	AmazonPage ap;
	ShoppingPage sp;
	HomePage hp;
	ElectronicPage ep;
	KeyBoardPage kp;
	
	public KeyBoardPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		Initialization();
		
		
		hp = new HomePage();
		ep = new ElectronicPage();
		mp = new MusicInstrumentPage();
		ap = new AmazonPage();
		pp = new PianoPage();
		sp = new ShoppingPage();
		kp = new KeyBoardPage();
		hp.clickOnElectronicsLink();
		ep.scrolldownClickOnMusicInstrument();
		mp.clickOnKeyboardPiano();
	}
	
	@AfterMethod
	public void endUp() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void validateKeyBoardPageTitle() {
		String title = kp.validatePageTitle();
		Assert.assertEquals(title, "Amazon.ca: Keyboards & Pianos: Musical Instruments, Stage & Studio");
	}
	
	@Test(priority=2)
	public void clickOnfolktoolTest() {
		ap = kp.clickOnfolktool();
	}

	@Test(priority=3)
	public void backForwardRefreshTest() {
		mp = kp.goingToBackPage();
		String mpTitle = driver.getTitle();
		Assert.assertEquals(mpTitle, "Amazon.ca: Musical Instruments, Stage & Studio");
		kp.goingToForwardPage();
		kp.refreshCurrentPage();
		String title = driver.getTitle();
		Assert.assertEquals(title, "Amazon.ca: Keyboards & Pianos: Musical Instruments, Stage & Studio");
		}
	
	@Test(priority=4)
	public void validateKeyBoardHeadingTest() {
		boolean heading = kp.validateKeyBoardHeading();
		Assert.assertTrue(heading);
	}
}


