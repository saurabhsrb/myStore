package com.mystore.testscripts;


import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {

	IndexPage indexpg;
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
	public void searchresult() {
		indexpg = new IndexPage();
		searchpg=indexpg.searchProduct("t-shirt");
		assertTrue(searchpg.isProductAvailable());
	}
}
