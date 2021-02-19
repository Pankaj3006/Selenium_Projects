package QATools_Demo;

import java.util.Iterator;
import java.util.List;
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

public class Multiple_Windows_Practice 
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
	driver.get("http://demo.automationtesting.in/Windows.html");
	driver.findElement(By.xpath("//a[@href='#Multiple']")).click();
	driver.findElement(By.xpath("(//button[@class='btn btn-info'])[2]")).click();
	Set<String> NoOfWindows = driver.getWindowHandles();
	System.out.println(NoOfWindows.size());
	Iterator<String> wind = NoOfWindows.iterator();
	while(wind.hasNext())
	{
		driver.switchTo().window(wind.next());
		System.out.print(driver.getCurrentUrl());
		System.out.print("---------------------   ");
		System.out.println(driver.getTitle());
	}
	Thread.sleep(3000);
	System.out.println("***********************New Program*****************************");
	driver.get("http://www.sakinalium.in");
	WebElement Headdriver = driver.findElement(By.xpath("//div[@class='navbar-collapse collapse']/ul"));
	List<WebElement> links = Headdriver.findElements(By.tagName("a"));
	//System.out.println(links.size());
	for(int i=4;i<links.size(); i++)
	{ 
		String key = Keys.chord(Keys.CONTROL,Keys.ENTER);
		links.get(i).sendKeys(key);
	}
	Set<String> differentWindows = driver.getWindowHandles(); 
	System.out.println(differentWindows.size());
	Iterator<String> diffwin = differentWindows.iterator();
	while(diffwin.hasNext())
	{
		driver.switchTo().window(diffwin.next());
		System.out.print(driver.getCurrentUrl()+ "---------------------");
		System.out.println(driver.getTitle());
	}
	Thread.sleep(2000);
	driver.quit();
	}
}
