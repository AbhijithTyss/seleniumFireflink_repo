package extentReport;

import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ToLearnExtentReports {
	@Test
	public void demoTest() {
		String TIME = LocalDateTime.now().toString().replace(":", "-");
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/ExtentReport_"+TIME+".html");
		spark.config().setDocumentTitle("Demo Report");
		spark.config().setTheme(Theme.DARK);
		
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		ExtentTest test = report.createTest("demoTest");
		test.log(Status.PASS, "added log message into report");
		report.flush();
	}
}	