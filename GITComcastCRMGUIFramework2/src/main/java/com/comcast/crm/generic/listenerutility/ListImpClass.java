
package com.comcast.crm.generic.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.generic.baseutility.BaseClass;

public class ListImpClass implements ITestListener,ISuiteListener {
	//public ExtentSparkReporter spark;*/
	 public  ExtentReports report;
	 public static ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("report configuration");	
		//spark report config 
		String time = new Date().toString().replace(" ","_").replace(":","_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("crm test suite results");
		spark.config().setReportName("crm report");
		spark.config().setTheme(Theme.DARK);
		
		// env information & create Test
		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("report reportBackup");	
		report.flush();
}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("====== "+result.getName()+"===strat===");
		  test = report.createTest(result.getMethod().getMethodName());
		  UtilityClassObject.setTest(test);
		 test.log(Status.INFO, result.getMethod().getMethodName()+"==> STARTED<====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("====== "+result.getName()+"===end===");	
		test.log(Status.PASS, result.getMethod().getMethodName()+"==> COMPLETED <====");
	}

	int i=1;
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testname = result.getName();
		UtilityClassObject.setDriver(BaseClass.sdriver);
		//TakesScreenshot edriver =(TakesScreenshot) (BaseClass.sdriver);
		TakesScreenshot edriver =(TakesScreenshot) UtilityClassObject.getDriver();
		String filepath = edriver.getScreenshotAs(OutputType.BASE64);
		
		//step 2 : use getScreenShotAs method to get file type of screenshot
		//File screenshotAs = edriver.getScreenshotAs(OutputType.FILE);
		String time = new Date().toString().replace(" ","_").replace(":","_");
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(filepath,testname+"_"+time);

		// Store Screen on local driver 
		/*
		 * try { //FileUtils.copyFile(screenshotAs,new
		 * File(".\\ScreenShot.\\ss "+testname+(i++)+".png") );
		 * FileUtils.copyFile(screenshotAs,new
		 * File(".\\ScreenShot.\\ss "+testname+"+"+time+".png") ); } catch (IOException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.SKIP, result.getMethod().getMethodName()+"==> SKIPPED <====");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

}
