package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class AmazonPage extends TestBase{

	@FindBy (id = "low-price")
	WebElement min;
	
	@FindBy (id = "high-price")
	WebElement max;
	
	@FindBy (id = "a-autoid-1")
	WebElement go;
	
	@FindBy (xpath = "//span[contains(text(),'Piano Accordion, 22 Key Accordion Playing Musical ')]")
	WebElement item;
	
	
	public AmazonPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public void seleciMinMaxValueForItem(String a, String b) {
		min.sendKeys(a);
		max.sendKeys(b);
		go.click();
	}
	
	public PianoPage selectItemPiano() {
		item.click();
		
		return new PianoPage();
	}
}
