package co.comcast.crm.orgalltest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.listenerutility.ListImpClass;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.generic.objectrepositoryutility.HomePage;
import com.comcast.crm.generic.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.generic.objectrepositoryutility.OrganizationPage;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.generic.baseutility.BaseClass;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class CreateOrganizationAllTest extends BaseClass {

	@Test(groups = "smoketest")
	public void createOrgMandatoryField() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "  read the data from excel");
		// read test SCript data from excel file

		String orgName = eu.getDataFromExcel("org", 1, 2).toString() + ju.getRandomNumber();

		// step 1 to login app

		UtilityClassObject.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		UtilityClassObject.getTest().log(Status.INFO, "  navigate to the org page");
		// ListImpClass.test.log(Status.INFO," navigate to the org page");
		HomePage hp = new HomePage(UtilityClassObject.getDriver());
		OrganizationPage op = new OrganizationPage(UtilityClassObject.getDriver());
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(UtilityClassObject.getDriver());
		OrganizationInformationPage oip = new OrganizationInformationPage(UtilityClassObject.getDriver());
//		HomePage hp = new HomePage(driver);
//		OrganizationPage op = new OrganizationPage(driver);
//		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
//		OrganizationInformationPage oip = new OrganizationInformationPage(driver);

		// step2 navigate to organization module
		hp.getOrgLink().click();
		// driver.findElement(By.linkText("Organizations")).click();;

		// step 3 click on create organization Button
		// driver.findElement(By.xpath("//img[@title='Create
		// Organization...']")).click();



		UtilityClassObject.getTest().log(Status.INFO, "  navigate to create org page");
		// ListImpClass.test.log(Status.INFO," navigate to create org page");
		// step 5 enter al the details & create new organization

		UtilityClassObject.getTest().log(Status.INFO, "   create new org page");
		// ListImpClass.test.log(Status.INFO," create new org page");
		cnop.createOrg(orgName);
		// driver .findElement(By.name("accountname")).sendKeys(orgName);
		// driver .findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// verify header msg Expected result

		// String headerinfo =driver
		// .findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		String actOrgName = oip.getHeaderMsg().getText();
		UtilityClassObject.getTest().log(Status.INFO, orgName + "   createed new org page");
		if (actOrgName.contains(orgName)) {
			System.out.println(orgName + "is created ==pass");
		} else {
			System.out.println(orgName + "is  not created ==pass");
		}
		// verify header orgname info Expected result

		String actorgname = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (actorgname.equals(orgName)) {
			System.out.println(orgName + "is created ==pass");
		} else {
			System.out.println(orgName + "is  not created ==pass");
		}

		// step 5 logout

	}

	@Test(groups = "regressiontest")
	public void createOrgWithPhoneNumber() throws Throwable {

		// read test SCript data from excel file

		String orgName = eu.getDataFromExcel("org", 10, 2).toString() + ju.getRandomNumber();
		String phoneNumber = eu.getDataFromExcel("org", 10, 3).toString();

		// step 1 to login app
		UtilityClassObject.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.get(url);

		HomePage hp = new HomePage(UtilityClassObject.getDriver());
		OrganizationPage op = new OrganizationPage(UtilityClassObject.getDriver());
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(UtilityClassObject.getDriver());
		OrganizationInformationPage oip = new OrganizationInformationPage(UtilityClassObject.getDriver());
//		HomePage hp = new HomePage(driver);
//		OrganizationPage op = new OrganizationPage(driver);
//		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
//		OrganizationInformationPage oip = new OrganizationInformationPage(driver);

		// step2 navigate to organization module

		hp.getOrgLink().click();
		// driver.findElement(By.linkText("Organizations")).click();;

		// step 3 click on create organization Button

		op.getCreateNewOrgBtn().click();
		// driver.findElement(By.xpath("//img[@title='Create
		// Organization...']")).click();

		// step 5 enter al the details & create new organization

		cnop.createOrg(orgName);
		cnop.getPhoneNumEdt().sendKeys(phoneNumber);
		cnop.getSaveBtn();

		// verify header msg Expected result
		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerinfo.contains(orgName)) {
			System.out.println(orgName + "is created ==pass");
		} else {
			System.out.println(orgName + "is  not created ==pass");
		}
		// verify header orgname info Expected result

		String actornum = driver.findElement(By.id("dtlview_Phone")).getText();
		if (actornum.equals(phoneNumber)) {
			System.out.println(phoneNumber + "is created ==pass");
		} else {
			System.out.println(phoneNumber + "is  not created ==pass");
		}

	}

	@Test(groups = "regressiontest")
	public void createOrgWithType() throws Throwable {

		// read test SCript data from excel file

		String orgName = eu.getDataFromExcel("org", 4, 2).toString() + ju.getRandomNumber();
		String industry = eu.getDataFromExcel("org", 4, 3).toString();
		String type = eu.getDataFromExcel("org", 4, 4).toString();

		// step 1 to login app
		UtilityClassObject.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		HomePage hp = new HomePage(UtilityClassObject.getDriver());
		OrganizationPage op = new OrganizationPage(UtilityClassObject.getDriver());
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(UtilityClassObject.getDriver());
		OrganizationInformationPage oip = new OrganizationInformationPage(UtilityClassObject.getDriver());

//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		HomePage hp = new HomePage(driver);
//		OrganizationPage op = new OrganizationPage(driver);
//		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
//		OrganizationInformationPage oip = new OrganizationInformationPage(driver);

		// step2 navigate to organization module
		hp.getOrgLink().click();
		// driver.findElement(By.linkText("Organizations")).click();;

		// step 3 click on create organization Button
		op.getCreateNewOrgBtn().click();
		// driver.findElement(By.xpath("//img[@title='Create
		// Organization...']")).click();

		cnop.createOrg(orgName, industry, type);

		// verify industry and type informATION
		String actIndustry = driver.findElement(By.id("dtlview_Industry")).getText();
		if (actIndustry.contains(industry)) {
			System.out.println(industry + "is created ==pass");
		} else {
			System.out.println(industry + "is  not created ==pass");
		}
		// verify header orgname info Expected result

		String actType = driver.findElement(By.id("dtlview_Type")).getText();
		if (actType.equals(type)) {
			System.out.println(type + "is created ==pass");
		} else {
			System.out.println(type + "is  not created ==pass");
		}

	}

}
