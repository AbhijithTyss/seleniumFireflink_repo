package cars;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FordTest {
	@Test(groups = "smoke")
	public void launchFord() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ford.com/cars/mustang/");
		Reporter.log("Ford launched",true);
	}
}
