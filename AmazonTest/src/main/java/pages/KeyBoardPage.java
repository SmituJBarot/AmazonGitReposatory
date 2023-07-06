package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class KeyBoardPage extends TestBase{


	@FindBy (linkText = "Folk & World")
	WebElement folkLink;
	
	@FindBy(xpath = "//span[@class='acswidget-carousel__title']")
	WebElement keyboardHeading;
	
	public KeyBoardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public MusicInstrumentPage goingToBackPage() {
		driver.navigate().back();
		System.out.println("Back Done");
		return new MusicInstrumentPage();
	}
	
	public void goingToForwardPage() {
		driver.navigate().forward();
	}
	
	public void refreshCurrentPage() {
		driver.navigate().refresh();
		System.out.println("ForWard Done");
	}
	
	public AmazonPage clickOnfolktool() {
		folkLink.click();
		
		return new AmazonPage();
	}
	
	public boolean validateKeyBoardHeading() {
		return keyboardHeading.isDisplayed();
	}
}
