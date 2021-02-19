package first_Package;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class QAAcademy {

	public static void main(String[] args) {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice");
        List<WebElement> ls= driver.findElements(By.cssSelector("[type='checkbox']"));
        System.out.println(ls.size());
        String text=null;
        for (int i = 0; i < ls.size(); i++)
        {
        	if(ls.get(i).getAttribute("value").equalsIgnoreCase("Option2"))
        	{
        		ls.get(i).click();
        		break;
        	}
        }        
        for (int i = 0; i < ls.size(); i++)
        {
        	if(ls.get(i).isSelected())
        	{
        		text = ls.get(i).getAttribute("value");
        		break;
        	}
        }    
	 Select s= new Select(driver.findElement(By.id("dropdown-class-example")));
	 s.selectByValue(text);
	 driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']")).sendKeys(text);
	 driver.findElement(By.xpath("//input[@value='Alert']")).click();
	 String text2 = driver.switchTo().alert().getText();
	 driver.switchTo().alert().accept();
	 if(text2.contains(text))
	 {
		 System.out.println("message Contains  "+text+"  in the alert box and sucess");
	 }
	 else
	 {
		 System.out.println("message does not Contain"+text+"in the alert box and unsucess");
	 }
  }
}
