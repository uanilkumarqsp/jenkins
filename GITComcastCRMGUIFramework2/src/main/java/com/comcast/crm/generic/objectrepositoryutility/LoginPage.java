package com.comcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
@FindBy(name="user_name")
private WebElement usernameEdt;

@FindBy(name="user_password")
private WebElement passwordEdt;

@FindBy(id="submitButton")
private WebElement loginBtn;

     // object initialization 


// 4 object encapsulation

public WebElement getUsernameEdt() {
	return usernameEdt;
}

public WebElement getPasswordEdt() {
	return passwordEdt;
}

public WebElement getLoginBtn() {
	return loginBtn;
}

//step 5 provide action 

public void loginToapp(String url,String username,String password)
{
	waitForPageLoad(driver);
	driver.get(url);
	driver.manage().window().maximize();
	usernameEdt.sendKeys(username);
	
	passwordEdt.sendKeys(password);
	
	loginBtn.click();
	
}



}
