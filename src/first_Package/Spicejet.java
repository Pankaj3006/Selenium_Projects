package first_Package;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Spicejet {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com");
		System.out.println(driver.getTitle());
		Thread.sleep(4000);
		driver.findElement(
				By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']"))
				.click();
		driver.findElement(
				By.xpath("//*[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //*[@value='BLR']"))
				.click();
		driver.findElement(
				By.xpath("//*[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']"))
				.click();
		driver.findElement(
				By.xpath("//*[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //*[@value='MAA']"))
				.click();
		driver.findElement(
				By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active"))
				.click();
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		Select s = new Select(driver.findElement(By
				.cssSelector("#ctl00_mainContent_ddl_Adult")));
		s.selectByValue("4");
		Select s1 = new Select(driver.findElement(By
				.cssSelector("#ctl00_mainContent_ddl_Child")));
		s1.selectByValue("2");
		Select s2 = new Select(driver.findElement(By
				.cssSelector("#ctl00_mainContent_ddl_Infant")));
		s2.selectByValue("1");
		Select s4 = new Select(driver.findElement(By
				.xpath("//*[@id='ctl00_mainContent_DropDownListCurrency']")));
		s4.selectByValue("USD");
		System.out.println(driver.findElement(
				By.xpath("//div[@id='divpaxinfo']")).getText());
		driver.findElement(
				By.xpath("//*[@id='ctl00_mainContent_SeniorCitizenDiv']"))
				.click();
		driver.findElement(
				By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']"))
				.click();
	}
}
