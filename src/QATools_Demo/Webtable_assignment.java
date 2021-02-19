package QATools_Demo;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class Webtable_assignment {

	public static void main(String[] args) {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	    driver.get("https://www.rahulshettyacademy.com/AutomationPractice");
        int rowcount = driver.findElements(By.xpath("//table[@id='product']/tbody/tr")).size();
        int colcount = driver.findElements(By.xpath("//table[@id='product']/tbody/tr[2]/td")).size();
        System.out.println(rowcount);
        System.out.println(colcount);
       // for(int i=2; i<=rowcount; i++)
       // {
        	for(int j=1; j<=colcount; j++)
        	{
        		System.out.print(driver.findElement(By.xpath("//table[@id='product']/tbody/tr[3]/td["+j+"]")).getText()+ "  ");
        	}
        	//System.out.println();
        //}
	}

}
