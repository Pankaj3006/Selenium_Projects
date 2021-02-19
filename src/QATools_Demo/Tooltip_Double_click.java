package QATools_Demo;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Tooltip_Double_click
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
		driver.get("https://demoqa.com/tooltip-and-double-click");
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//button[@id='doubleClickBtn']"))).doubleClick().build().perform();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        a.contextClick(driver.findElement(By.xpath("//button[@id='rightClickBtn']"))).build().perform();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[@class='contextMenu']/div[4]")).click();
      //driver.findElement(By.xpath("//div[@id='rightclickItem']/div[4]")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        a.moveToElement(driver.findElement(By.xpath("//div[@id='tooltipDemo']"))).build().perform();
        Thread.sleep(2000);
        driver.close();
     }
}
