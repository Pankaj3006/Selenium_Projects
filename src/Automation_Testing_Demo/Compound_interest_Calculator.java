package Automation_Testing_Demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Compound_interest_Calculator {

	public static void main(String[] args) throws IOException {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.thecalculatorsite.com/finance/calculators/compoundinterestcalculator.php");
		WebDriverWait w = new WebDriverWait(driver, 10);
		FileInputStream fis = new FileInputStream("E:\\DRIVER\\Excel_Demo.xlsx");
		XSSFWorkbook excel= new XSSFWorkbook(fis);
		XSSFSheet sheet =excel.getSheet("Office");
		int rowcount = sheet.getLastRowNum();
		System.out.println("total number of records present in sheet are: "+ rowcount);
		for(int row=0; row<=rowcount; row++)
		{
		XSSFRow currentrow = sheet.getRow(row);
		//String base_amount= NumberToTextConverter.toText(currentrow.getCell(0).getNumericCellValue());
		int base_amount = (int)currentrow.getCell(0).getNumericCellValue();
		String interest_rate= NumberToTextConverter.toText(currentrow.getCell(1).getNumericCellValue());
		String cal_period= NumberToTextConverter.toText(currentrow.getCell(2).getNumericCellValue());
		String comp_interval= NumberToTextConverter.toText(currentrow.getCell(3).getNumericCellValue());
		
		driver.findElement(By.xpath("//input[@id='amount']")).clear();
		driver.findElement(By.xpath("//input[@id='amount']")).sendKeys(String.valueOf(base_amount)); 
		driver.findElement(By.xpath("//input[@id='percent']")).clear();
		driver.findElement(By.xpath("//input[@id='percent']")).sendKeys(interest_rate);
		Select s= new Select(driver.findElement(By.xpath("//select[@name='percentPeriod']")));
		s.selectByIndex(0);
		driver.findElement(By.xpath("//input[@id='periodnum']")).clear();
		driver.findElement(By.xpath("//input[@id='periodnum']")).sendKeys(cal_period);
		Select s1= new Select(driver.findElement(By.xpath("//select[@name='periodtype']")));
		s1.selectByIndex(0);
		Select s2= new Select(driver.findElement(By.xpath("//select[@name='calculateinterest']")));
		s2.selectByIndex(3);
		driver.findElement(By.xpath("//input[@name='regdeposit']")).clear();
		driver.findElement(By.xpath("//input[@name='regdeposit']")).sendKeys(comp_interval);
		Select s3= new Select(driver.findElement(By.xpath("//select[@id='regtype']")));
		s3.selectByIndex(1);
	    w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@type='submit']"))));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='reportdata']")));
		//w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[@class='reportdata']"))));
	    int Table_row = driver.findElements(By.xpath("//table[@class='reportdata']/tbody/tr")).size();
		int Table_col = driver.findElements(By.xpath("//table[@class='reportdata']/tbody/tr[3]/td")).size();
		System.out.println("Next Record table");
		for(int i=3; i<=Table_row; i++)
		{
			for(int j=2; j<=Table_col; j++)
			{
				System.out.print(driver.findElement(By.xpath("//table[@class='reportdata']/tbody/tr["+i+"]/td["+j+"]")).getText()+"  ");
         	}
			System.out.println();	
		}		
		}
		excel.close();
	}
	
}
