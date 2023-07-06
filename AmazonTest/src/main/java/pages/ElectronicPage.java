package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ElectronicPage extends TestBase{
	
	@FindBy	(xpath = "//img[@alt='Electronics & Gadgets']")
	WebElement ElectroniImg;
	
	@FindBy	(partialLinkText = "Instruments")
	WebElement MusicInstrumentLink;
	
	@FindBy (linkText = "All")
	WebElement dropDownLink;
	
	@FindBy (xpath = "//ul[contains(@class,'hmenu hmenu-visible')]/li")
	List<WebElement> dropDownList;
	
	public ElectronicPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyElectronicImg() {
		return ElectroniImg.isDisplayed();
	}
	
	public MusicInstrumentPage scrolldownClickOnMusicInstrument() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",MusicInstrumentLink );
		MusicInstrumentLink.click();
		
		return new MusicInstrumentPage();
		}
	
	public void getAllLinksFromDropDOwn() {
		dropDownLink.click();
		System.out.println(dropDownList.size());
		
		for (int i=0; i<dropDownList.size(); i++) {
			System.out.println(dropDownList.get(i).getText());
		}	
	}
}

