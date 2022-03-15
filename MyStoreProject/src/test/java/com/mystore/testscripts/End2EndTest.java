package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

public class End2EndTest extends BaseClass{
	
	IndexPage indexpg;
	AddToCartPage addtocartpg;
	LoginPage loginpg;
	SearchResultPage searchpg;
	OrderPage orderpg;
	AddressPage addpg;
	ShippingPage shippg;
	PaymentPage paymentpg;
	OrderConfirmationPage ordrcnfpg;
	OrderSummaryPage ordersummryspg;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void endtoend() throws InterruptedException {
		indexpg = new IndexPage();
		searchpg=indexpg.searchProduct("t-shirt");
		addtocartpg=searchpg.clickOnResult();
		addtocartpg.selectQuantity("2");
		addtocartpg.selectSize("2");
		addtocartpg.addToCart();
		orderpg=addtocartpg.clickOnCheckout();
		loginpg=orderpg.clickoncheckout();
		addpg=loginpg.ifNotLoggedInEarlier(prop.getProperty("username"), prop.getProperty("password"));
		shippg=addpg.clickOncheckout();
		shippg.clickcheckbox();
		paymentpg=shippg.proceedtocheckout();
		ordersummryspg=paymentpg.clickonpaymentmethod();
		ordrcnfpg=ordersummryspg.confirmOrder();
	    Assert.assertEquals(ordrcnfpg.confirmsg(), "Your order on My Store is complete.");
	}

}
