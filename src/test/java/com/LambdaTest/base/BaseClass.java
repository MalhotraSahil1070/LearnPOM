package com.LambdaTest.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.LambdaTest.pageMethods.FormPageMethods;
import com.LambdaTest.utilities.ReadPropFile;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	public WebDriver driver;
	
	public FormPageMethods loginPageMethods;
	public ReadPropFile readPropFile;
	
	public static ExtentReports report;
	public ExtentTest test;
	public static ExtentSparkReporter extentHtmlReporter;
	public String methodName;
	
	
	public void intialize() throws IOException
	{
		readPropFile = new ReadPropFile();
		loginPageMethods = new FormPageMethods(driver);
		
	}
	
	@BeforeSuite
    public void openBrowser() throws IOException {
		
		report = new ExtentReports();
		String filePath = System.getProperty("user.dir")+"//TestReport//TestReport.html";
		extentHtmlReporter = new ExtentSparkReporter(new File(filePath));
		report.attachReporter(extentHtmlReporter);
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		intialize();
		driver.manage().window().maximize();
        driver.get(readPropFile.getURL());
		
		
	}
	
	
	@BeforeMethod
	public void getMethodName(Method method)
	{

		 methodName = method.getName();

		System.out.println("\n\n*******************************************************************************\n");
		System.out.println("\tExecuting "+methodName+" testcase");
		System.out.println("\n*******************************************************************************\n");

		test = report.createTest(methodName);

		
	}
	
	
	@AfterMethod
	public void setTestResult(ITestResult result, Method method) throws IOException
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test is passed");

			String screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		 	test.addScreenCaptureFromBase64String(screenshot);
		}
		else
			if (result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "failed");
			String screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

	        try {
	            // Specify the destination where the screenshot will be saved
	        	test.addScreenCaptureFromBase64String(screenshot);
	            System.out.println("Screenshot captured!");
	            
	        } catch (Exception e) {
	            System.out.println("Failed to capture screenshot: " + e.getMessage());
	        }
			
	       			
		}
		
		
		
	}
	
	@AfterSuite(alwaysRun=true)
	public void generateReport() throws IOException
	{
		if(!driver.equals(null))
			driver.quit();
		   
			report.flush();
	}
	
	
	
	
	

}
