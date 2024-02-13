package cars;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PorscheTest {
	@Test(groups = "system")
	public void launchPorsche() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://dealer.porsche.com/ca/northtoronto/");
		Reporter.log("Porsche launched",true);
	}
}
