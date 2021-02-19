package QATools_Demo;

import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class All_Elements_Dropdown {

	public static void main(String[] args) {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	    driver.get("https://demoqa.com/automation-practice-form/");
	    Select s = new Select(driver.findElement(By.xpath("//select[@id='continents']")));
	    List<WebElement> continents = s.getOptions();
	    ListIterator<WebElement> li = continents.listIterator();
	    int j=0, k=0, l=0;
	    while(li.hasNext())
	    {
	    	j = li.nextIndex();
	    	System.out.println((li.next()).getText());
	    }
	    s.selectByIndex(j);
	    System.out.println("********************Multiple************************");
	    Select s1 = new Select(driver.findElement(By.xpath("//select[@id='continentsmultiple']")));
	    List<WebElement> multiplecontinents = s1.getOptions();
	    ListIterator<WebElement> li1 = multiplecontinents.listIterator();
	    while(li1.hasNext())
	    {
	    	k = li1.nextIndex();
	    	System.out.println((li1.next()).getText());
	    }
	    s1.selectByIndex(k);
	    System.out.println("*********************Commands*********************");
	    Select s2 = new Select(driver.findElement(By.xpath("//select[@id='selenium_commands']")));
	    List<WebElement> commands = s2.getOptions();
	    ListIterator<WebElement> li2 = commands.listIterator();
	    while(li2.hasNext())
	    {
	    	l = li2.nextIndex();
	    	System.out.println((li2.next()).getText());
	    }
	    s2.selectByIndex(l);
	}
	
}
