package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
	WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
		}

	public boolean isProductAvailable() {
		return productResult.isDisplayed();
	}
	
	public AddToCartPage clickOnResult() {
		productResult.click();
		return new AddToCartPage();
	}
	
	

}
