package com.mystore.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass {

	@FindBy(xpath="//span[@class='price']/span") 
	WebElement unitPrice;

	@FindBy(id="total_price")
	WebElement totalPrice;

	@FindBy(xpath="//span[text()=\"Proceed to checkout\"]")
	WebElement proceed;

	public OrderPage() {
		PageFactory.initElements(driver, this);
	}

	public double getUnitPrice() {
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		String unit= unitPrice.getText();
		System.out.println(unit);
		String unit2=unit.replaceAll("[^0-9a-zA-Z\\.]", "");
		double unitfinalprice=Double.parseDouble(unit2);
		return unitfinalprice;
	}
	
	public double getTotalPrice() {
		String total= totalPrice.getText();
		String total2=total.replaceAll("[^0-9a-zA-Z\\.]", "");
		double totalfinalprice=Double.parseDouble(total2);
		return totalfinalprice;
	}
	
	public LoginPage clickoncheckout() {
		proceed.click();
		return new LoginPage();
	}
	
	
}
