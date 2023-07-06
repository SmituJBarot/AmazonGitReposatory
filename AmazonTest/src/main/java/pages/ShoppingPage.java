package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ShoppingPage extends TestBase{

	@FindBy (id = "sw-atc-details-single-container")
	WebElement bucket;
	
	@FindBy (id = "nav-cart")
	WebElement cart;
	
	public ShoppingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean confirmCartItems() {
		return cart.isDisplayed();
	}
	
	public boolean confirmBucketItem() {
		return bucket.isDisplayed();
	}
	
}
