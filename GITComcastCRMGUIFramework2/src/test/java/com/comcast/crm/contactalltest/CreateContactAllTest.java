package com.comcast.crm.contactalltest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.objectrepositoryutility.ContactsPage;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewContactsPage;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.generic.objectrepositoryutility.HomePage;
import com.comcast.crm.generic.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.generic.objectrepositoryutility.OrganizationPage;
import com.comcast.crm.generic.objectrepositoryutility.OrganizationsListPopUpPage;
import com.comcast.generic.baseutility.BaseClass;

public class CreateContactAllTest extends BaseClass {
	@Test(groups = "smoketest")
	public void createContactTest() throws Throwable {
		// WebDriver driver=null;

//			JavaUtility  ju= new JavaUtility();
//			WebDriverUtility wu = new WebDriverUtility();
//			FileUtility fu = new FileUtility();
//			ExcelUtility eu = new ExcelUtility();

		try {

			// read test script data from excel file

			String lastName = eu.getDataFromExcel("contact", 1, 2) + ju.getRandomNumber();

			// step 1: login to application

			// driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.manage().window().maximize();

			HomePage hp = new HomePage(driver);
			OrganizationPage op = new OrganizationPage(driver);
			CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
			OrganizationInformationPage oip = new OrganizationInformationPage(driver);

			// step 2: navigate to contacts module

			hp.getContactLnk().click();

			ContactsPage cp = new ContactsPage(driver);
			cp.getCreateNewContBtn().click();

			// step 4: enter all the details and create new contact

			CreateNewContactsPage cncp = new CreateNewContactsPage(driver);
			cncp.getContactLastName().sendKeys(lastName);
			// driver.findElement(By.name("lastname")).sendKeys(lastName);

			cncp.getContactSaveBtn().click();
			// driver.findElement(By.xpath("//input[@class='crmButton small
			// save']")).click();

			// step 5: verify header msg expected result

			//String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			String headerInfo = cp.getHeaderMsg().getText();
			  boolean status =headerInfo.contains(lastName); 
			Assert.assertEquals(status,true);

			// step 6: verify last name
			String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actLastName,lastName);
			
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			// driver.quit();
		}
	}

	@Test(groups = "regressiontest")
	public  void createContactWithSupportDate() throws Throwable {

		try {

		//read test script data from excel file
		
		String lastName = eu.getDataFromExcel("contact", 4, 2).toString()+ju.getRandomNumber();

	
	//driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		HomePage hp = new HomePage(driver);
		OrganizationPage op =  new OrganizationPage(driver);
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		
//		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
//		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
//		driver.findElement(By.id("submitButton")).submit();
		
		//step 2: navigate to contacts module
		 
		hp.getContactLnk().click();
		//driver.findElement(By.linkText("Contacts")).click();
		
		//step 3: click on create contact
		
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContBtn().click();
		
		//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//step 4: enter all the details and create new contact
		
		CreateNewContactsPage cncp = new CreateNewContactsPage(driver);
		cncp.getContactLastName().sendKeys(lastName);
		
		//driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		//select todays date
		String startDate =ju.getSystemDataYYYYDDMM();
		String endDate=ju.getRequiedDataYYYYDDMM(25);
		
		cncp.getSupportStartDate().clear();
		//driver.findElement(By.name("support_start_date")).clear();
		cncp.getSupportStartDate().sendKeys(startDate);
		
		//driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		cncp.getSupportEndDate().clear();
		//driver.findElement(By.name("support_end_date")).clear();
		cncp.getSupportEndDate().sendKeys(ju.getRequiedDataYYYYDDMM(25));
		//driver.findElement(By.name("support_end_date")).sendKeys(ju.getRequiedDataYYYYDDMM(25));
		
		//save the contact
		
		cncp.getContactSaveBtn().click();
		//driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		
		// step 5: verify header msg expected result
		
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if (headerInfo.contains(lastName)) {
			System.out.println(lastName+" is created ==pass");
		} else {
			System.out.println(lastName+" is not created ==fail");
		}
		
		//step 6: verify start date
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actStartDate.contains(startDate)) {
			System.out.println(startDate+" is verified ==pass");

		} else {
			System.out.println(startDate+" is not verified ==fail");

		}
		//step 6: verify end date 
		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actEndDate.contains(endDate)) {
			System.out.println(endDate+" is verified ==pass");

		} else {
			System.out.println(endDate+" is not verified ==fail");

		}
		}
		catch(Exception e ) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			//driver.quit();
		}
	}

	@Test(groups = "regressiontest")
	public  void createContactWithOrgTest() throws Throwable {


		// read test script data from excel file

		String lastName = eu.getDataFromExcel("contact", 7, 2).toString();
		String orgName = eu.getDataFromExcel("contact", 7, 3).toString() + ju.getRandomNumber();

		wu.waitForPageLoad(driver);

		driver.manage().window().maximize();
		// LoginPage lp = new LoginPage(driver);

		// lp.loginToapp(url,"admin", "admin");
		HomePage hp = new HomePage(driver);
		OrganizationPage op = new OrganizationPage(driver);
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);

		// step 2: navigate to contact module

		hp.getOrgLink().click();
		op.getCreateNewOrgBtn().click();
		;

		cnop.createOrg(orgName);
		Thread.sleep(3000);
		hp.getContactLnk().click();
		// driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();

		// step 3: click on create contact

		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContBtn().click();
		// driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		// step 4: enter all the details and create new organization

		CreateNewContactsPage cncp = new CreateNewContactsPage(driver);
		cncp.getContactLastName().sendKeys(lastName);

		// driver.findElement(By.name("accountname")).sendKeys(orgName);
		// driver.findElement(By.xpath("//input[@class='crmbutton small
		// save']")).click();

		cncp.getAddOrgBtn().click();
		// driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();

		// Thread.sleep(3000);

		// Switch to child window

		wu.switchToTabOnURL(driver, "module=Accounts");

		//
		Thread.sleep(3000);
		OrganizationsListPopUpPage olpp = new OrganizationsListPopUpPage(driver);
		olpp.getSearchtxt().sendKeys(orgName);
		// /* WebElement e =
		// */driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgName);
		// e.click();
		// e;
		// driver.findElement(By.name("search")).click();
		olpp.getSearchBtn().click();

		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		Thread.sleep(3000);
		// Switch to parent window

		wu.switchToTabOnURL(driver, "Contacts&action");

		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();

		// verify last name
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actLastName.contains(lastName)) {
			System.out.println(lastName + " is created ==pass");

		} else {
			System.out.println(lastName + " is not created ==fail");

		}

		// verify org name

		String actOrgName1 = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actOrgName1.trim().equals(orgName)) {
			System.out.println(orgName + " information is created==PASS");
		} else {
			System.out.println(orgName + " information is not created==FAIL");

		}

		// driver.quit();

	}


}
