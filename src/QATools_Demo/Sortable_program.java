package QATools_Demo;

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

public class Sortable_program {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	    driver.get("https://demoqa.com/sortable");
	    List<WebElement> itemlist =  driver.findElements(By.xpath("//ul[@id='sortable']/li"));
	    ArrayList<String> list = new ArrayList<String>();
	    for(int i=0;i<itemlist.size();i++)
	    {
	    	list.add(itemlist.get(i).getText());
	    }
	    for(String s: list)
		{
			System.out.println(s);
		}
		Collections.sort(list);
		Collections.reverse(list);
		System.out.println("********************Reverse Sortable List*******************");
		for(String s: list)
		{
			System.out.println(s);
		}
		Thread.sleep(3000);
		driver.close();

	}

}
