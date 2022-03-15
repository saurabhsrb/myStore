package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass{
	IndexPage indexpg;
	
	@BeforeMethod
	public void setup() {
		launchApp();	
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void logoTest() {
		indexpg=new IndexPage();
		Assert.assertTrue(indexpg.validateLogo());
	}
	
	@Test
	public void verifyTitle() {
		String title=indexpg.getMyStoreTitle();
		System.out.println(title);
		Assert.assertEquals(title, "My Store");
	}
	
}
