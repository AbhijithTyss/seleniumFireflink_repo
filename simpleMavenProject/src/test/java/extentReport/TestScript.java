package extentReport;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

@Listeners(ListenerImplementation.class)
public class TestScript extends BaseClass{
	@Test
	public void clickOnBooks() {
		driver.findElement(By.partialLinkText("BOOKS")).click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop");
		test.log(Status.PASS, "User navigated to books page");
	}
}