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

public class ShoppingPageTest extends TestBase{
	
	MusicInstrumentPage mp;
	PianoPage pp;
	AmazonPage ap;
	ShoppingPage sp;
	HomePage hp;
	ElectronicPage ep;
	KeyBoardPage kp;
	
	public ShoppingPageTest() {
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
		pp.itemAddToCart();
	}
	
	@AfterMethod
	public void endUp() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void validateShoppingPageTitle() {
		String title = sp.validatePageTitle();
		Assert.assertEquals(title, "Amazon.ca Shopping Cart");
	}
	
	@Test(priority=2)
	public void confirmBucketItemTest() {
		boolean ci = sp.confirmBucketItem();
		Assert.assertTrue(ci);
	}
	
	@Test(priority=3)
	public void confirmCartItemsTest() {
		boolean atc = sp.confirmCartItems();
		Assert.assertTrue(atc);
	}
}
