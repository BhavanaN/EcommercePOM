package com.amazon.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.page.HomePage;

public class HomePageTest extends TestBase{
	HomePage homePage;
	
	HomePageTest(){
		super();
	}


@BeforeMethod
@Parameters("Browser")
public void setUp(String browser){
	initialization(browser);
	homePage = new HomePage();
}
  @Test(enabled = true, groups = {"Functional Test"})

  public void HomePageTitleTest() {
	  String pageTitle = homePage.getPageTitle();
	  Boolean result = pageTitle.contains("Amazon.com");
	  assertTrue(result);
  }
  
  @Test(enabled = true, groups = {"Functional Test"})
  public void registerNewUserTest(){
	  
	  homePage.registerNewUser();
	  String pageTitle = homePage.getPageTitle();
	  System.out.println(pageTitle);
	  Boolean result = pageTitle.contains("Registration");
	  assertTrue(result);
  }
  @Test(enabled = true, groups = {"Sanity"})
  public void navigateToDeptTest() {
	 
	  homePage.navigateToKidsDept();
	  String pageTitle = homePage.getPageTitle();
	  System.out.println(pageTitle);
  }
  
 // @AfterSuite
@AfterTest(alwaysRun = true)
  public void tearDown(){
	  System.out.println("Closing browser");
	 driver.close();
  }
}
