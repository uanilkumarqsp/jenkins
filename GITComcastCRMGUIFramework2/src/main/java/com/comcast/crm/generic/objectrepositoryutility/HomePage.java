package com.comcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	public WebElement getProductLink() {
		return productLink;
	}

	@FindBy(linkText="Contacts")
	private WebElement contactLnk;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignlnk;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}

	
	public WebElement getAdminImg() {
		return adminImg;
	}


	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getCampaignlnk() {
		return campaignlnk;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	
	
public void navigateToCampaignPage()
{
	Actions act = new Actions(driver);
	act.moveToElement(moreLink).perform();
	campaignlnk.click();
}
 public void logout()
 {
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		signOutLnk.click();
 }
	
}
