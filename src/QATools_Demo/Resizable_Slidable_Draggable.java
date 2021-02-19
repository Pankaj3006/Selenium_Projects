package QATools_Demo;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Resizable_Slidable_Draggable
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
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//Resizable
	driver.get("https://demoqa.com/resizable");
	driver.findElement(By.xpath("//div[@id='resizable']"));
	Actions a = new Actions(driver);
	WebElement resi_zable= driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
	a.dragAndDropBy(resi_zable, 150, 250).perform();
	a.clickAndHold(resi_zable).moveByOffset(-150,-350).perform();
	System.out.println("Resizing is Done");
	//Slidable
	driver.get("https://demoqa.com/slider");
	WebElement Slidable = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
	a.dragAndDropBy(Slidable, 150, 250).perform();
	System.out.println("Sliding is Done");
	//Draggable
	driver.get("https://demoqa.com/draggable/");
	a.dragAndDropBy(driver.findElement(By.xpath("//div[@id='draggable']")), 150, 250).perform();
	System.out.println("Dragging is Done");
	//Drag and Drop
	driver.get("https://demoqa.com/droppable/");
	WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
	WebElement droppable = driver.findElement(By.xpath("//div[@id='droppable']"));
	a.dragAndDrop(draggable, droppable).build().perform();
	a.dragAndDropBy(driver.findElement(By.xpath("//div[@id='draggable']")), 150, 250).perform();
	System.out.println("Dragging and dropping is Done");
    driver.close();
	}
}
