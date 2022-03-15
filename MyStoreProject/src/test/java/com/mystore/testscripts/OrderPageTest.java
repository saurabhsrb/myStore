package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {

	
	IndexPage indexpg;
	AddToCartPage addtocartpg;
	SearchResultPage searchpg;
	OrderPage orderpg;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void validateTotalPrice() throws InterruptedException {
		indexpg = new IndexPage();
		searchpg=indexpg.searchProduct("t-shirt");
		addtocartpg=searchpg.clickOnResult();
		addtocartpg.selectQuantity("2");
		addtocartpg.selectSize("2");
		addtocartpg.addToCart();
		orderpg=addtocartpg.clickOnCheckout();
		Double unitprice=orderpg.getUnitPrice();
		Double totalprice=orderpg.getTotalPrice();
		Double totalexpectedprice=(unitprice*2)+2;
		Assert.assertEquals(totalexpectedprice, totalprice);
	}

}
