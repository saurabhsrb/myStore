package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass{
	
	@FindBy(xpath="//*[@id=\"center_column\"]/div/p/strong")
	WebElement confirmationMsg;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String confirmsg() {
		return confirmationMsg.getText();
	}

}
