package com.comcast.generic.baseutility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.objectrepositoryutility.HomePage;
import com.comcast.crm.generic.objectrepositoryutility.LoginPage;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class BaseClass {
	
	 public WebDriver driver=null ;
	 public static WebDriver sdriver=null ;
	 public DataBaseUtility du = new DataBaseUtility();
	 
	 public FileUtility fu = new FileUtility();
	 public JavaUtility  ju= new JavaUtility();
	 public WebDriverUtility wu = new WebDriverUtility();
	 public ExcelUtility eu = new ExcelUtility();
	 
	 
	@BeforeSuite(alwaysRun = true,groups = {"smoketest","regressiontest"})
	public void configBS() throws SQLException
	{
		System.out.println(" ===connect to db , report config===");
		du.getDbConnection();
		
	}
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true,groups = {"smoketest","regressiontest"})
	public void configBC(/* String BROWSER */) throws Throwable
	{
		System.out.println(" == Luanch browser ==");
		String BROWSER = fu.getDataFromPropertiesFile("browser");
		System.out.println(BROWSER);
		
		if(BROWSER.equals("chrome"))
		{
			 driver = new ChromeDriver();
			
		}
		else if(BROWSER.equals("firefox"))
		{
			 driver = new FirefoxDriver();
		}
		else if(BROWSER.equals("egde"))
		{
			 driver = new EdgeDriver();
		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
		
	}
	@BeforeMethod(alwaysRun = true,groups = {"smoketest","regressiontest"})
	public void configBM() throws Throwable
	{
		System.out.println(" ==login==");
		//LoginPage lp= new LoginPage(driver);
		LoginPage lp= new LoginPage(UtilityClassObject.getDriver());
		String url = fu.getDataFromPropertiesFile("url");
		String username = fu.getDataFromPropertiesFile("un");
		String password = fu.getDataFromPropertiesFile("pwd");

		lp.loginToapp(url, username, password);
	}

	@AfterMethod(alwaysRun = true,groups = {"smoketest","regressiontest"})
	public void configAM()
	{
		System.out.println(" ===logout ==");
		//HomePage hp = new HomePage(driver);
		
		HomePage hp = new HomePage(UtilityClassObject.getDriver());
		hp.logout();
	}
		
		
	@AfterClass(alwaysRun = true,groups = {"smoketest","regressiontest"})
	public void configAC() throws SQLException
	{
		System.out.println(" ==close the browser ==");
		UtilityClassObject.getDriver().quit();
	}

	@AfterSuite(alwaysRun = true,groups = {"smoketest","regressiontest"})
	public void configAS() throws SQLException
	{
		System.out.println(" ===close db ,Report backUP===");
		du.closeDbConnection();
		 
	}

}
