package extentReport;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenerImplementation extends BaseClass implements ITestListener{
	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getName();
		test.log(Status.FAIL, methodName+" is failed");
		TakesScreenshot ts=(TakesScreenshot) driver;
		test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64),"error image");
	}
}