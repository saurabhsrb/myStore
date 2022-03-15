package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class CreateAccountPage extends BaseClass {
	
	@FindBy(xpath="//h1[text()=\"Create an account\"]")
	WebElement createAccountLogo;
	
	public CreateAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isLogoPresent() {
		return createAccountLogo.isDisplayed();
	}

}
