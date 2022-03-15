package com.mystore.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="creds")
	public Object[][] getData(){
		Object[][] data=new Object[2][2];
		data[0][0]="abc";
		data[0][1]="def";
		data[1][0]="def";
		data[1][1]="def";
		
	
		
		
		return data;
	}

}
