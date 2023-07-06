package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class RegisterPage extends TestBase{
	
	@FindBy (name = "customerName")
	WebElement yourName;
	
	@FindBy (name = "email")
	WebElement emailId;
	
	@FindBy (name = "password")
	WebElement pass;
	
	@FindBy (name = "passwordCheck")
	WebElement confirmPass;

	@FindBy (id = "continue")
	WebElement continueBtn;
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public LoginPage createNewAccount(String a,String b, String c, String d) {
		yourName.sendKeys(a);
		emailId.sendKeys(b);
		pass.sendKeys(c);
		confirmPass.sendKeys(d);
		continueBtn.click();
		
		return new LoginPage();
	}
}
