package first_Package;

import java.util.Arrays;
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

public class GreenKart_Program {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		// WebDriverWait w = new WebDriverWait(driver,6);
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		System.out.println(driver.getTitle());
		String[] itemsNeeded = { "Brocolli", "Tomato", "Beans", "Potato" };
		additems(driver, itemsNeeded);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//*[text()='PROCEED TO CHECKOUT']")).click();
		// w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='promoCode']")));
		driver.findElement(By.xpath("//*[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[Class='promoBtn']")).click();
		// w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
	}
	public static void additems(WebDriver driver, String[] itemsNeeded) {
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		for (int i = 0; i < products.size(); i++) {
			String[] itemsavailable = products.get(i).getText().split("-");
			String FormattedName = itemsavailable[0].trim();

			List<String> itemNeededList = Arrays.asList(itemsNeeded);

			if (itemNeededList.contains(FormattedName)) {
				driver.findElements(
						By.xpath("//div[@class='product-action']/button"))
						.get(i).click();
				System.out.println(FormattedName + " succesfully Added");
			}

			int j = 0;
			if (j == itemsNeeded.length) {
				break;
			}
		}
	}
}
