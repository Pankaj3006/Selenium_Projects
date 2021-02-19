package Automation_Testing_Demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class Sorted_Table_Row {

	public static void main(String[] args) throws InterruptedException {
	System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
	Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
	System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("useAutomationExtension", false);
	WebDriver driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[2]")).click();
	//driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[2]")).click();
	List<WebElement> collist = driver.findElements(By.cssSelector("tr td:nth-child(2)"));
	ArrayList<String> originallist = new ArrayList<String>();
	   for(int i=0; i<collist.size(); i++)
	   {
		originallist.add(collist.get(i).getText());
	   }
	   for(String s: originallist)
	   {
		   System.out.println(s);
	   }
	   
	   ArrayList<String> copiedlist = new ArrayList<String>();
	   for(int j=0; j<originallist.size(); j++)
	   {
		   copiedlist.add(collist.get(j).getText());
	   }
	   Collections.sort(copiedlist);
	   Collections.reverse(copiedlist);
	   System.out.println("*****************************************************************");
	   for(String s1: copiedlist)
	   {
		   System.out.println(s1);
	   }
	   
	   if(originallist.equals(copiedlist))
	   {
		   System.out.println("Values are initially sorted");
	   }
	   else
	   {
		   System.out.println("Values are not initially sorted");
	   }
	   Thread.sleep(2000);
	   driver.close();
	}

}
