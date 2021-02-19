package QATools_Demo;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
public class Practice_form {

	public static void main(String[] args) {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Pankaj");
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("gupta");
        driver.findElement(By.xpath("//input[@value='Male']")).click();
        driver.findElement(By.xpath("//input[@id='exp-2']")).click();
        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("04-04-2020");
        driver.findElement(By.xpath("//input[@id='profession-0']")).click();
        driver.findElement(By.xpath("//input[@id='profession-1']")).click();
        Select s= new Select(driver.findElement(By.xpath("//select[@id='continents']")));
        s.selectByValue("AF");
        Select s1= new Select(driver.findElement(By.xpath("//select[@id='continentsmultiple']")));
        s1.selectByValue("EU");
        s1.selectByValue("AF");
        s1.selectByValue("AUS");
        Select s2= new Select(driver.findElement(By.xpath("//select[@id='selenium_commands']")));
        s2.selectByIndex(0);
        s2.selectByIndex(1);
        s2.selectByIndex(2);
	}

}
