package first_Package;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_table_print {

	public static void main(String[] args) throws IOException {
	
		FileInputStream fis = new FileInputStream("E:\\DRIVER\\Excel_Demo.xlsx");
		XSSFWorkbook excel= new XSSFWorkbook(fis);
		System.out.println(excel.getNumberOfSheets());
		int NoOfSheet = excel.getNumberOfSheets();
		int rowcount=0;
		int colcount=0;
		XSSFSheet sheet = null;
		for(int i=0;i<NoOfSheet;i++)
		{
			System.out.println(excel.getSheetName(i));
			if(excel.getSheetName(i).equalsIgnoreCase("office"))
			{
			 sheet = excel.getSheetAt(i);
			  rowcount =  sheet.getLastRowNum();
			  colcount =  sheet.getRow(i).getLastCellNum();
			}
		}
		System.out.println(rowcount);
		System.out.println(colcount);
		for(int j=0;j<=rowcount;j++)
		{
			XSSFRow currentrow = sheet.getRow(j);
			for(int k=0;k<colcount;k++)
			{
			String value =	currentrow.getCell(k).toString();
			System.out.print(value+ "  ");
			}
			System.out.println();
		}
		/*for(int j=1;j<rowcount;j++)
		{
			XSSFRow currentrow = sheet.getRow(j);
			for(int k=1;k<colcount;k++)
			{
			int value1 =	(int)currentrow.getCell(k).getNumericCellValue();
			System.out.print(value1+ "  ");
			}
			System.out.println();
		}*/
		excel.close();

	}

}
