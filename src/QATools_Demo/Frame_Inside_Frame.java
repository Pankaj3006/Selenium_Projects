package QATools_Demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class Frame_Inside_Frame {

	public static void main(String[] args) throws InterruptedException {
	    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Register.html");
		List<WebElement> NoOfFrames = driver.findElements(By.tagName("iframe"));
		System.out.println(NoOfFrames.size());
		driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]")).click();
		driver.findElement(By.xpath("//a[@href='Frames.html']")).click();
        driver.findElement(By.xpath("//a[@href='#Multiple']")).click();
        WebElement insideframe = driver.findElement(By.xpath("//*[@id='Multiple']/iframe"));
        //driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='Multiple']/iframe")));
        driver.switchTo().frame(insideframe);
        WebElement frameinsideframe = driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
        //driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div/div/iframe")));
        driver.switchTo().frame(frameinsideframe);
        driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("inside innermost frame");
        driver.switchTo().defaultContent();
        //driver.switchTo().parentFrame();
        System.out.println(driver.findElements(By.tagName("a")).size());
        WebElement Footdriver = driver.findElement(By.xpath("//*[@id='footer']/div/div"));
        System.out.println(Footdriver.findElements(By.tagName("a")).size());
        Thread.sleep(3000);
        driver.close();
	}

}
