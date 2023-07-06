package pages;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class MusicInstrumentPage extends TestBase{

	@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-bold'][contains(text(),'Keyboards & Pianos')]")
	WebElement keyBoardLink;
	
	@FindBy(xpath = "//div[@id='nav-subnav']//a")
	List<WebElement> allHeaderLinks;
	
	public MusicInstrumentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public void getAllHeaderLinks() {
		System.out.println(allHeaderLinks.size());
		
		for(int i=0; i<allHeaderLinks.size(); i++) {
			System.out.println(allHeaderLinks.get(i).getText());
		}
	}
	
	public KeyBoardPage clickOnKeyboardPiano() {
		keyBoardLink.click();
		
		return new KeyBoardPage();
		
	}
}
