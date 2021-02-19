package Automation_Testing_Demo;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class File_Upload {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		//file upload
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.findElement(By.xpath("//*[@id='pickfiles']/span")).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("E:\\FileUploadAutoItScript.exe");
		WebDriverWait w1 = new WebDriverWait(driver, 30);
        w1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='processTask']")));  
        		//.visibilityOf(driver.findElement(By.xpath("//*[@id='processTask']"))));
		driver.findElement(By.xpath("//*[@id='processTask']")).click();
		WebDriverWait w = new WebDriverWait(driver, 30);
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='pickfiles']")));
        		//visibilityOf(driver.findElement(By.xpath("//a[@id='pickfiles']"))));
        driver.findElement(By.xpath("//a[@id='pickfiles']")).click();
	}

}
