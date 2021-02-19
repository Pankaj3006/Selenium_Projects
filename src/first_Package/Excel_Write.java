package first_Package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Write {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("E:\\DRIVER\\Excel_Demo.xlsx");
		XSSFWorkbook excel= new XSSFWorkbook(fis);
		XSSFSheet sheet =  excel.getSheet("Office");
		int rowcount = sheet.getLastRowNum();
		System.out.println(rowcount);
		for(int i=0; i<= rowcount; i++)
		{
		 Row Currentrow = sheet.getRow(i);
		 Cell cell = Currentrow.createCell(4);
		 cell.setCellValue(i+6);
		}
		FileOutputStream fos = new FileOutputStream("E:\\DRIVER\\Excel_Demo.xlsx");
		excel.write(fos);
		System.out.println("END OF WRITING DATA IN EXCEL");
        excel.close();
	}

}
