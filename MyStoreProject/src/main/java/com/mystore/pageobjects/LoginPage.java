/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

/**
 * @author SENSEI MK2
 *
 */
public class LoginPage extends BaseClass {
	
	@FindBy(id="email")
	WebElement userName;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(name="SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(id="email_create")
	WebElement emailForNewAccount;

	@FindBy(id="SubmitCreate")
	WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String uname, String pwd) {
		userName.sendKeys(uname);
		password.sendKeys(pwd);
		signInBtn.click();
		return new HomePage();
		
	}
	
	public CreateAccountPage createNewAccount(String email) {
		emailForNewAccount.sendKeys(email);
		createNewAccountBtn.click();
		return new CreateAccountPage();
	}
	
	public AddressPage ifNotLoggedInEarlier(String uname, String pwd) {
		userName.sendKeys(uname);
		password.sendKeys(pwd);
		signInBtn.click();
		return new AddressPage();
		
	}
	
}
