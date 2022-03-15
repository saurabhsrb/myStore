package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass {
	
	@FindBy(xpath="//a[@class=\"bankwire\"]")
	WebElement bankWirePayment;
	
	@FindBy(xpath="//a[@class=\"cheque\"]")
	WebElement chequePayment;
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummaryPage clickonpaymentmethod() {
		bankWirePayment.click();
		return new OrderSummaryPage();
	}


}
