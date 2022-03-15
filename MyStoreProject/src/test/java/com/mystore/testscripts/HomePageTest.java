package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class HomePageTest extends BaseClass {
	
	
	IndexPage indexpg;
	LoginPage loginpg;
	HomePage homepg;

	
	@BeforeMethod
	public void setup() {
		launchApp();	
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void wishListDisplay() {
		indexpg=new IndexPage();
		loginpg=indexpg.clickOnSignIn();
		homepg=loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homepg.validateWishlist());

	}
	
	@Test
	public void validateOrderhistory() {
		indexpg=new IndexPage();
		loginpg=indexpg.clickOnSignIn();
		homepg=loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homepg.validateOrderHistory());

	}

}
