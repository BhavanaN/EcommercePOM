package com.amazon.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;


public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	public TestBase(){
		try{
			prop = new Properties();
			FileInputStream infile = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/amazon/properties/config.properties");
			prop.load(infile);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void initialization(String browserName){
		int implicitWait = 60;
		int pageLoad = 40;
		//String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("FF")){
			implicitWait = 80;
			pageLoad = 60;
			System.out.println("Entered init with FireFox");
			driver = new FirefoxDriver();
		}else{
			System.out.println("Entered init with Chrome");
			System.setProperty("webdriver.chrome.driver","/Users/nipun/Applications/ws/QA_2017_August/drivers/chromedriver 3");
			driver = new ChromeDriver();
		}
	
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(pageLoad, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		//driver.get("https://www.amazon.com/");
		
		System.out.println(driver.getTitle());
	}
}
