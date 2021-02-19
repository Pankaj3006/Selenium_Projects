package first_Package;

import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class Multiple_Window
{
	public static void main(String[] args) throws InterruptedException
	{
	System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
	Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
	System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("useAutomationExtension", false);
	WebDriver driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.get("https://www.rahulshettyacademy.com/AutomationPractice");
	System.out.println(driver.findElements(By.tagName("a")).size());
	WebElement Footdriver = driver.findElement(By.id("gf-BIG"));
	System.out.println(Footdriver.findElements(By.tagName("a")).size());
	WebElement Columndriver = Footdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
	System.out.println(Columndriver.findElements(By.tagName("a")).size());
	for(int i=1;i<Columndriver.findElements(By.tagName("a")).size();i++)
	{
	String key = Keys.chord(Keys.CONTROL,Keys.ENTER);
	Columndriver.findElements(By.tagName("a")).get(i).sendKeys(key);
	}
	Set<String> str = driver.getWindowHandles();
	Iterator<String> itr= str.iterator();
	while(itr.hasNext())
	{
	driver.switchTo().window(itr.next());
	System.out.print(driver.getCurrentUrl() + "   ");
	System.out.print("-------------------  ");
	System.out.println(driver.getTitle());
	}
  }
}