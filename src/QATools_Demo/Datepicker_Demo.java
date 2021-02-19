package QATools_Demo;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class Datepicker_Demo
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
		driver.get("https://demoqa.com/date-picker");
		driver.findElement(By.id("datepicker")).click();
		//String year = driver.findElement(By.xpath("//*[@class='ui-datepicker-year']")).getText();
		//String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		while(!driver.findElement(By.xpath("//*[@class='ui-datepicker-title']")).getText().contains("February 2022"))
		{
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
        int r = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr")).size();
        int c = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[1]/td")).size();
        int count=0;
        for(int i=1; i<=r; i++)
        {
        	for(int j=1; j<=c; j++)
        	{
        		if(driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr["+i+"]/td["+j+"]")).getText().contains("20"))
        		{
        			driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr["+i+"]/td["+j+"]")).click();
        			count++;
        			break;
        		}
        	}
        	if(count==1)
        		break;
        }
        System.out.println(driver.findElement(By.id("datepicker")).getAttribute("value"));
        Thread.sleep(2000);
        driver.close();
	}
	
}
