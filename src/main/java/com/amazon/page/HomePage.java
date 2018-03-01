package com.amazon.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;


public class HomePage extends TestBase{

	@FindBy(xpath = "//a[@id = 'nav-link-shopall' ]//span[@class = 'nav-line-2']")
	WebElement departments;
	
	@FindBy(linkText = "Departments")
	WebElement departmentsLink;

	@FindBy(xpath = "//*[@id='nav-flyout-shopAll']/div[2]/span[1]/span")
	WebElement primeVideo;
	
	@FindBy(xpath = "//*[@id='nav-flyout-shopAll']/div[3]/div[1]/div[2]/div/a[2]/span[1]")
	WebElement kidsLink;
	
	@FindBy(id = "nav-link-accountList")
	WebElement account;
	
	@FindBy(xpath = "//a[contains(text(),'Start')]")
	WebElement register;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToKidsDept() {
		
		Actions act = new Actions(driver);
		act.moveToElement(departments).build().perform();
		act.moveToElement(primeVideo).build().perform();
		act.moveToElement(kidsLink).click().build().perform();
		
	}
	public void registerNewUser(){
		Actions act = new Actions(driver);
		act.moveToElement(account).build().perform();
		act.moveToElement(register).click().build().perform();//DOESNT WORK,you dont need to move toclick
		//register.click();
	}
	public String getPageTitle(){
		return driver.getTitle();
	}
	
}