package com.comcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	
	WebDriver driver ;
	
	public OrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createNewOrgBtn;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchBtn;
	
	

	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search_field")
	private WebElement searchDD;

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
}
