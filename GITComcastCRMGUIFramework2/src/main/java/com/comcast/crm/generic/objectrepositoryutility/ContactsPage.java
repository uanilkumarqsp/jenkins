package com.comcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	WebDriver driver;
	
	public ContactsPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath="//img[@alt='Create Contact...']")
		private WebElement createNewContBtn;
		@FindBy(className="dvHeaderText")
		private WebElement headerMsg;

		public WebElement getHeaderMsg() {
			return headerMsg;
		}

		public WebElement getCreateNewContBtn() {
			return createNewContBtn;
		}
}
