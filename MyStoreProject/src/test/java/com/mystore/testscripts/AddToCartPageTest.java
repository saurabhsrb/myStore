package com.mystore.testscripts;



import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass {
	
	IndexPage indexpg;
	AddToCartPage addtocartpg;
	SearchResultPage searchpg;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test
	public void logoTest() throws InterruptedException {
		indexpg = new IndexPage();
		searchpg=indexpg.searchProduct("t-shirt");
		addtocartpg=searchpg.clickOnResult();
		addtocartpg.selectQuantity("2");
		addtocartpg.selectSize("2");
		addtocartpg.addToCart();
		assertTrue(addtocartpg.validateAddToCart());
	}
}
