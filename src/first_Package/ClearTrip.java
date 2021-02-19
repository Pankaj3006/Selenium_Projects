package first_Package;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class ClearTrip {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com");
		driver.findElement(By.xpath("//*[@id='DepartDate']")).click();
		driver.findElement(
				By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active"))
				.click();
		Select s = new Select(driver.findElement(By
				.xpath("//select[@id='Adults']")));
		s.selectByValue("3");
		Select s1 = new Select(driver.findElement(By
				.xpath("//select[@id='Childrens']")));
		s1.selectByValue("3");
		Select s2 = new Select(driver.findElement(By
				.xpath("//select[@id='Infants']")));
		s2.selectByValue("1");
		driver.findElement(By.xpath("//a[@id='MoreOptionsLink']")).click();
		Thread.sleep(3000);
		Select s3 = new Select(driver.findElement(By
				.xpath("//select[@id='Class']")));
		s3.selectByIndex(3);
		driver.findElement(By.xpath("//input[@id='AirlineAutocomplete']"))
				.sendKeys("Indigo");
		driver.findElement(By.xpath("//input[@id='SearchBtn']")).click();
		System.out.println(driver.findElement(
				By.xpath("//div[@id='homeErrorMessage']")).getText());
		System.out.println(driver.findElement(
				By.xpath("//a[@id='flightsHomeFlashSaleBanner']")).getText());

	}

}
