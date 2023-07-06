package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class PianoPage extends TestBase{
	
	@FindBy (id = "landingImage")
	WebElement viewImg;
	
	@FindBy (id = "add-to-cart-button")
	WebElement cartBtn;
	
	public PianoPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyImgDisplayed() {
		 return viewImg.isDisplayed();
	}
	
	public ShoppingPage itemAddToCart() {
		cartBtn.click();
		
		return new ShoppingPage();
	}

}