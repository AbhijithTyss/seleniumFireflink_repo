package extentReport;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	
	@BeforeSuite
	public void configureReports() {
		String TIME = LocalDateTime.now().toString().replace(":", "-");
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/ExtentReports_"+TIME+".html");
		report=new ExtentReports();
		report.attachReporter(spark);
	}
	@BeforeClass
	public void browserSetup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
	}	
	@BeforeMethod
	public void login(Method method) {
		test=report.createTest(method.getName());
		driver.findElement(By.linkText("Log in")).click();	
		driver.findElement(By.id("Email")).sendKeys("abhis1234@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("abhis@1234");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	@AfterMethod
	public void logout() {
		driver.findElement(By.linkText("Log out")).click();
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterSuite
	public void reportBackup() {
		report.flush();
	}
	
}
