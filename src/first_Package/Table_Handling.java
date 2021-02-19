package first_Package;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
public class Table_Handling
{
	public static void main(String[] args) 
	{
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-table");
		int p=0;
		for(int i=1; i<=driver.findElements(By.xpath("//*[@class='tsc_table_s13']/tbody/tr[1]/td")).size(); i++)
		{
		if(driver.findElement(By.xpath("//table[@class='tsc_table_s13']/thead/tr/th["+i+"]")).getText().contains("City"))
		{
		p=i;
		break;
		}
		}
	    System.out.println(p--);
	   for(int j=1; j<=driver.findElements(By.xpath("//*[@class='tsc_table_s13']/tbody/tr")).size(); j++)
		{
			System.out.println(driver.findElement(By.xpath("//*[@class='tsc_table_s13']/tbody/tr["+j+"]/td["+p+"]")).getText());
		} 
		//print the left header
	    System.out.println("***************left Header****************");
       for(int k=1; k<=driver.findElements(By.xpath("//*[@class='tsc_table_s13']/tbody/tr")).size() ;k++)
		{
		System.out.println(driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr["+k+"]/th")).getText());
		}
		//print the table
       System.out.println("****************table with skipping a particular column*********************");
		int r = driver.findElements(By.xpath("//*[@class='tsc_table_s13']/tbody/tr")).size();
		System.out.println(r);
		int c = driver.findElements(By.xpath("//*[@class='tsc_table_s13']/tbody/tr[1]/td")).size();
		System.out.println(c);
		for(int m=1; m<=r; m++)
		{
			for(int n=1; n<=c; n++)
			{
				if(n==p)
				{
					continue;
				}
				else
				{
				System.out.print(driver.findElement(By.xpath("//*[@class='tsc_table_s13']/tbody/tr["+m+"]/td["+n+"]")).getText()+"  ");
				}
			 }
			System.out.println();
		} 
	}
}
