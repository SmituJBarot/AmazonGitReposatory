package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//a[@aria-label='Amazon Canada Home']")
	WebElement amazonLable;
	
	@FindBy(id = "nav-link-accountList")
	WebElement signInLink;
	
	@FindBy (id = "twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy (xpath = "//div[@class='left-pane-results-container']/div")
	List<WebElement> allOptions;
	
	@FindBy(linkText = "Electronics")
	WebElement electronicLink;
	
	@FindBy (xpath = "//div[contains(@class,'navFooterVerticalRow navAccessibility')]//li")
	List<WebElement> allFooterLinks;
	
	@FindBy (xpath = "//div[@id='nav-al-container']//a")
	List<WebElement> allList;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyAmazonBottomLable() {
		return amazonLable.isDisplayed();
	}
	
	public String getDefaultValueFromSearchBox() {
		return searchBox.getAttribute("placeholder");	 
	}
	
	public void getAllOptionsFromSuggestionList(String a) {
		searchBox.sendKeys(a);
		System.out.println(allOptions.size());
		
		for (int i=0; i<allOptions.size(); i++) {
			System.out.println(allOptions.get(i).getText());
		}
	}
	
	public ElectronicPage clickOnElectronicsLink() {
		electronicLink.click();
		return new ElectronicPage();
	}
	
	public void getAllFooterLinks() {
		System.out.println(allFooterLinks.size());
		
		for (int i=0; i<allFooterLinks.size(); i++) {
			System.out.println(allFooterLinks.get(i).getText());
		}
	}
	
	
	public LoginPage clickOnSignInLink() {
		signInLink.click();
		return new LoginPage();
		}
	
	public void hoverToSignInGetList() {
		Actions a = new Actions(driver);
		a.moveToElement(signInLink).build().perform();
		System.out.println(allList.size());
		
		for (int i=0; i<allList.size(); i++) {
			System.out.println(allList.get(i).getText());
		}
	}
}
