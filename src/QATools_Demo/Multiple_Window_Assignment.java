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

public class Multiple_Window_Assignment {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		driver.findElement(By.partialLinkText("Click")).click();
		Set<String> multiplewin = driver.getWindowHandles();
		Iterator<String> strn = multiplewin.iterator();
		String parentid = strn.next();
		String childid= strn.next();
		driver.switchTo().window(childid);
		System.out.println(driver.getCurrentUrl() + " ---- " + driver.getTitle());
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText());
		driver.switchTo().window(parentid);
		System.out.println(driver.getCurrentUrl() + " ---- " + driver.getTitle());
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Opening')]")).getText());
		System.out.println("*******Next Program*********");
		driver.get("https://www.amazon.in/");
		WebElement headdriver = driver.findElement(By.xpath("//*[@id='navFooter']/div[4]/ul"));
		System.out.println(headdriver.findElements(By.tagName("a")).size());
        List<WebElement> links= headdriver.findElements(By.tagName("a"));
        for(int i=0; i<links.size(); i++)
        {
        	String key = Keys.chord(Keys.CONTROL,Keys.ENTER);
        	links.get(i).sendKeys(key);
        }
	  Set<String> windows = driver.getWindowHandles();
	  Iterator<String> str = windows.iterator();
	  int j=0;
	  while(str.hasNext())
	  {
		  driver.switchTo().window(str.next());
		  System.out.print(j++ + ":  ");
		  System.out.print(driver.getCurrentUrl()+ "     ");
		  System.out.println(driver.getTitle());
	  }
	  Thread.sleep(3000);
	  driver.quit();
	  System.out.println("Browser closed");
	}
	

}
