package first_Package;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Mouse_Interaction_Action
{
	public static void main(String[] args) throws InterruptedException
	{		
	System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
	Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("useAutomationExtension", false);
	System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/");
	Actions a = new Actions(driver);
	a.moveToElement(driver.findElement(By.xpath("//*[@id='nav-link-accountList']/span[2]/span"))).contextClick().build().perform();
	a.moveToElement(driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
	Thread.sleep(3000);
	driver.close();
	}
}