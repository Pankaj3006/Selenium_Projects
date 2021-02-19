package Automation_Testing_Demo;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class KSRTC_Website {

	public static void main(String[] args) throws InterruptedException, IOException {
    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
	Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
	System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("useAutomationExtension", false);
	//WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver(options);
	driver.manage().window().maximize();
    driver.get("https://ksrtc.in/oprs-web/");
    Thread.sleep(4000);
    //from place
    driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("MYS");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
    JavascriptExecutor js = (JavascriptExecutor)driver;
    String script = "return document.getElementById(\"fromPlaceName\").value;";
    String text = (String) js.executeScript(script);
    System.out.println(text);
    while(!text.contains("MYSORE"))
    {
    driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
    text = (String) js.executeScript(script);
    System.out.println(text);
   	}
    driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.ENTER);
    //to place
    driver.findElement(By.xpath("//input[@id='toPlaceName']")).sendKeys("ERN");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@id='toPlaceName']")).sendKeys(Keys.DOWN);
    String script1 = "return document.getElementById(\"toPlaceName\").value;";
    String text1 = (String) js.executeScript(script1);
    System.out.println(text1);
    while(!text1.equalsIgnoreCase("ERNAKULAM"))
    {
    driver.findElement(By.xpath("//input[@id='toPlaceName']")).sendKeys(Keys.DOWN);
    text1 = (String) js.executeScript(script1);
    System.out.println(text1);
   	}
    driver.findElement(By.xpath("//input[@id='toPlaceName']")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("//input[@id='txtJourneyDate']")).click();
    while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']")).getText().contains("November"))
    {
    	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
    }
    int rowcount = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr")).size();
    int colcount = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[1]/td")).size();
    int count=0;
    for(int i=1;i<=rowcount; i++)
    {
    	for(int j=1; j<=colcount; j++)
    	{
    		if(driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr["+i+"]/td["+j+"]")).getText().contains("2"))
    		{
    			driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr["+i+"]/td["+j+"]")).click();
    			count++;
    			break;
    		}
    		if(count==1)
    			break;
    	}
    }
    driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary')]")).click();
    Thread.sleep(6000);
    int NoOfBuses = driver.findElements(By.xpath("//div[@class='search-result-grid']/div")).size();
    System.out.println(NoOfBuses);
    int x=0;
    for(int k=1; k<=NoOfBuses; k++)
    {
    String str= driver.findElement(By.xpath("//*[@id='ForwardResults']/div["+k+"]/div[1]/div[1]/div[4]/div/h4")).getText();
    //System.out.println(str);
    String[] str1 = str.split("S");
    int m = Integer.parseInt(str1[0]);
    System.out.println("Bus Number"+k+ ":  "+m);
    x=m+x;
    }
    System.out.println("Total number of Seats between these places are: "+ x);   
    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(src, new File("E:\\DRIVER\\screenshot.png"));
    }
}
