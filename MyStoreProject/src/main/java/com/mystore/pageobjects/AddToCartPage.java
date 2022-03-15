package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {

	@FindBy(id = "quantity_wanted")
	WebElement quantity;

	@FindBy(id = "group_1")
	WebElement size;

	@FindBy(xpath = "//span[text()=\"Add to cart\"]")
	WebElement addToCartbtn;

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
	WebElement addToCartMessage;

	@FindBy(xpath = "//span[contains(text(),\"Proceed to checkout\")]")
	WebElement proceedToCheckOut;

	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}

	public void selectQuantity(String a) {
		quantity.clear();
		quantity.sendKeys(a);
	}

	public void selectSize(String s) {
		Select dd = new Select(size);
		dd.selectByValue(s);
	}

	public void addToCart() throws InterruptedException {
		Actions act=new Actions(driver);
		act.moveToElement(addToCartbtn).build().perform();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", addToCartbtn);
		
	}

	public boolean validateAddToCart() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(addToCartMessage));
		return addToCartMessage.isDisplayed();
	}

	public OrderPage clickOnCheckout() {
			
			proceedToCheckOut.click();
			return new OrderPage();
	}

}
