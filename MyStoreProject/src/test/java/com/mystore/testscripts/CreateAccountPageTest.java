package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.CreateAccountPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class CreateAccountPageTest extends BaseClass {
	
	IndexPage indexpg;
	LoginPage loginpg;
	CreateAccountPage createpg;
	
	@BeforeMethod
	public void setup() {
		launchApp();	
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void isLogoPresent() {
		indexpg=new IndexPage();
		loginpg=indexpg.clickOnSignIn();
		createpg=loginpg.createNewAccount("skgux@gmail.com");
		Assert.assertTrue(createpg.isLogoPresent());
	}

}
