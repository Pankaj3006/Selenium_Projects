package QATools_Demo;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class keyboard_Events_Sample_Form {

	public static void main(String[] args) {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/keyboard-events-sample-form");
		driver.findElement(By.xpath("//form[@id='userform']//table/tbody/tr/td//*[@id='userName']")).sendKeys("Pankaj Gupta");
		driver.findElement(By.xpath("//form[@id='userform']//table/tbody/tr/td//*[@id='currentAddress']")).sendKeys("Bartan Waale");
		driver.findElement(By.xpath("//form[@id='userform']//table/tbody/tr/td//*[@id='permanentAddress']")).sendKeys("Jattari Aligarh");
		driver.findElement(By.xpath("//form[@id='userform']//table/tbody/tr/td//*[@id='submit']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

}
