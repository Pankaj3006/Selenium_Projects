package Automation_Testing_Demo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class preparation_for_Excel
{
	public static void main(String[] args) throws IOException
	{
		FileInputStream fis = new FileInputStream("E:\\DRIVER\\Excel_Demo.xlsx");
		XSSFWorkbook excel = new XSSFWorkbook(fis);
		int NoOfSheets = excel.getNumberOfSheets();
		System.out.println(NoOfSheets);
		int rowcount =0;
		int colcount =0;
		XSSFSheet sheet = null;
		for(int i=0; i<NoOfSheets; i++)
		{
			System.out.println(excel.getSheetName(i));
			if(excel.getSheetName(i).equalsIgnoreCase("demo"))
			{
				sheet = excel.getSheetAt(i);
				rowcount = sheet.getLastRowNum();
				colcount = sheet.getRow(0).getLastCellNum();
			}
		}
		System.out.println(rowcount);
		System.out.println(colcount);
		for(int j=0; j<= rowcount; j++)
		{
			XSSFRow currentrow = sheet.getRow(j); 
			for(int k=0; k< colcount; k++)
			{
				
				//String text = currentrow.getCell(k).toString();
				//System.out.print(text+"  ");
				if(currentrow.getCell(k).getCellTypeEnum()==CellType.STRING)
				{
			    String text = currentrow.getCell(k).getStringCellValue();
			    System.out.print(text+ "  ");
				}
				else
				{
				int text = (int) currentrow.getCell(k).getNumericCellValue();
				System.out.print(text+ "  ");
				}
			}
			System.out.println();
		}
   excel.close();
	}

}
