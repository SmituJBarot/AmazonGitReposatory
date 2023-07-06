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

public class PianoPageTest extends TestBase{
	
	MusicInstrumentPage mp;
	PianoPage pp;
	AmazonPage ap;
	ShoppingPage sp;
	HomePage hp;
	ElectronicPage ep;
	KeyBoardPage kp;
	
	public PianoPageTest() {
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
		kp.clickOnfolktool();
		ap.selectItemPiano();
	}
	
	@AfterMethod
	public void endUp() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void validatePianoPageTitle() {
		String title = pp.validatePageTitle();
		Assert.assertEquals(title, "Piano Accordion, 22 Key Accordion Playing Musical Instruments 8 Bass Accordion Accordions for Children Beginner Folk & World : Amazon.ca: Musical Instruments, Stage & Studio");
		}
	
	@Test(priority=2)
	public void verifyImgDisplayedTest() {
		boolean piano = pp.verifyImgDisplayed();
		Assert.assertTrue(piano);
	}
	
	@Test(priority=3)
	public void itemAddToCartTest() {
		sp = pp.itemAddToCart();
	}

}

