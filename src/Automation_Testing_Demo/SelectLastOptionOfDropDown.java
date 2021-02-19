package Automation_Testing_Demo;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectLastOptionOfDropDown
{
	public static void main(String[] args) 
	{//https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/package-summary.html //https://www.selenium.dev/selenium/docs/api/java/
		System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demoqa.com/select-menu");
		Select s= new Select(driver.findElement(By.xpath("//select[@id='cars']")));
		List<WebElement> ls1 = s.getOptions();
		s.selectByIndex(ls1.size()-1);
		List<WebElement> ls = s.getAllSelectedOptions();
		Iterator<WebElement> itr = ls.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next().getText());
		}
	}
}
