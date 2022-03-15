package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {

	@FindBy(id = "cgv")
	WebElement checkbox;

	@FindBy(xpath = "//button/span[contains(text(),\"Proceed to checkout\")]")
	WebElement proceedtocheckout;

	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickcheckbox() {
		checkbox.click();
	}

	public PaymentPage proceedtocheckout() {
		proceedtocheckout.click();
		return new PaymentPage();
	}
}
