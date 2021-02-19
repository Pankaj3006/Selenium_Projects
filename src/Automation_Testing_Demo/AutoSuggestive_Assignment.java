package Automation_Testing_Demo;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoSuggestive_Assignment {

	public static void main(String[] args) {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice");
        driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("UNI");
        driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.DOWN);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String script = "return document.getElementById(\"autocomplete\").value;";
        String text = (String) js.executeScript(script);
        System.out.println(text);
        while(!text.contains("United States Minor Outlying Islands"))
        {
        driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.DOWN);
        text = (String)js.executeScript(script);
        //System.out.println(text);
       	}
        driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//input[@id='autocomplete']")).getAttribute("value"));

	}

}
