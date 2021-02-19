package first_Package;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
public class Calender_UI
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
	driver.get("https://www.path2usa.com/travel-companions");
	driver.findElement(By.xpath("//input[@id='travel_date']")).click();
	while(!driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr[1]/th[@class='datepicker-switch']")).getText().contains("July"))
	{
	driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'»')]")).click();
	}
	Thread.sleep(2000);
	int r = driver.findElements(By.xpath("//div//div[@class='datepicker-days']/table/tbody/tr")).size();
	int c = driver.findElements(By.xpath("//div/div[@class='datepicker-days']/table/tbody/tr[1]/td")).size();
	int count=0;
	for(int i=1; i<=r; i++)
		{
		for(int j=1; j<=c; j++)
			{
             	System.out.print(driver.findElement(By.xpath("//div/div[@class='datepicker-days']/table/tbody/tr["+i+"]/td["+j+"]")).getText() + "  ");
	            if(driver.findElement(By.xpath("//div/div[@class='datepicker-days']/table/tbody/tr["+i+"]/td["+j+"]")).getText().contains("22"))
	            {
	            driver.findElement(By.xpath("//div/div[@class='datepicker-days']/table/tbody/tr["+i+"]/td["+j+"]")).click();
	            count++;
	            break;
	            }
	     	}
		System.out.println();
		if(count==1)
		{
			break;
		}
		
         }
		/*List<WebElement> dates= driver.findElements(By.className("day"));
		System.out.println(dates.size());
		for(int i=0; i<dates.size(); i++)
		{
			if(driver.findElements(By.className("day")).get(i).getText().contains("25"))
			{
				driver.findElements(By.className("day")).get(i).click();
				break;
			}		
		}*/
    System.out.println(driver.findElement(By.id("travel_date")).getAttribute("value"));	
    Thread.sleep(5000);
    driver.close();
	}
}

