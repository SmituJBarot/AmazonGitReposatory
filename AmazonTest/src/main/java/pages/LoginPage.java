package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase{
		
	@FindBy (name = "email")
	WebElement enterEmail;
	
	@FindBy(id = "continue")
	WebElement continueBtn;
	
	@FindBy (name = "password")
	WebElement enterPassword;
	
	@FindBy(id = "signInSubmit")
	WebElement submitBtn;
	
	@FindBy(xpath = "//div[@id='auth-error-message-box']//li")
	WebElement emailErr;
	
	@FindBy (linkText = "Create your Amazon account")
	WebElement createAccountBtn;
	
	@FindBy (xpath = "//a[@class='a-link-nav-icon']")
	WebElement amazonLogo;
	
	@FindBy (linkText = "Conditions of Use12")
	WebElement conditionLink;
	
	@FindBy (xpath = "//span[@id='nav-link-accountList-nav-line-1']")
	WebElement user;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyAmazonLogo() {
		return amazonLogo.isDisplayed();
	}

	public HomePage loginWithCorrectDetails(String b, String c) {
		enterEmail.sendKeys(b);
		continueBtn.click();
		enterPassword.sendKeys(c);
		submitBtn.click();	
		
		return new HomePage();
	}
	
	public void enterWrongEmail(String a) {
		enterEmail.sendKeys(a);
		continueBtn.click();
	}
	
	public String verifyEmailErr() {
		String actualErr = emailErr.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	public RegisterPage clickOnCreateNewAccount() {
		createAccountBtn.click();
		return new RegisterPage();
	}
	
	public boolean linkToTakeSS() {
		return conditionLink.isDisplayed();
	}
	
	public String validateUserNameAfterLogIn() {
		return user.getText();
	}
}
