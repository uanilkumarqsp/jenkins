package com.comcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactsPage {

WebDriver driver;
	
	public CreateNewContactsPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement contactLastName;
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement contactSaveBtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement addOrgBtn;
	
	public WebElement getAddOrgBtn() {
		return addOrgBtn;
	}

	@FindBy(name="support_start_date")
	private WebElement supportStartDate;
	
	@FindBy(name="support_end_date")
	private WebElement supportEndDate;

	public WebElement getSupportStartDate() {
		return supportStartDate;
	}

	public WebElement getSupportEndDate() {
		return supportEndDate;
	}

	public WebElement getContactLastName() {
		return contactLastName;
	}

	public WebElement getContactSaveBtn() {
		return contactSaveBtn;
	}
	
	
}
