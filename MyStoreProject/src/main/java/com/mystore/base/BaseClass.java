package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.mystore.utility.ExtentManager;
import com.mystore.utility.Log;
import com.mystore.utility.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Log log;
	
	
	@BeforeSuite
	public void BeforeSuite() {
		ExtentManager.generateRep();
		
	}

	@BeforeTest
	public void loadConfig(){
		
		try {
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
		prop.load(fis);
		log=new Log();
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void launchApp() {
		WebDriverManager.chromedriver().setup();
		String browserName=prop.getProperty("browser");
		if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\SENSEI MK2\\Downloads\\geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(browserName.equals("chrome")) {
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT_TIMEOUT));
		System.out.println("driver=" + driver);
		driver.get(prop.getProperty("url"));
		
	}
	
	@AfterSuite
	public void aftrsuite() {
		ExtentManager.endRep();
	}
	
}
