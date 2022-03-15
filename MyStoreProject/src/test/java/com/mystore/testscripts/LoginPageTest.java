package com.mystore.testscripts;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;


public class LoginPageTest extends BaseClass{
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
//	(dataProvider = "creds",dataProviderClass = DataProviders.class)
	@Test
	public void loginTest() {
	indexpg=new IndexPage();
		loginpg=indexpg.clickOnSignIn();
//		loginpg.login(uname, pwd);
		homepg=loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertEquals(homepg.getCurrentUrl(),"http://automationpractice.com/index.php?controller=my-account");
		
		
	}
	

}
