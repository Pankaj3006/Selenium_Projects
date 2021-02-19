package first_Package;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Particular_row_column {

	public ArrayList<String> getData(String testcasename) throws IOException
	{
		ArrayList<String> a  = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("E:\\DRIVER\\Excel_Demo.xlsx");
		XSSFWorkbook excel= new XSSFWorkbook(fis);
		System.out.println(excel.getNumberOfSheets());
		int NoOfSheet = excel.getNumberOfSheets();
		int k=0;
		int col=0;
		for(int i=0;i<NoOfSheet;i++)
		{
			System.out.println(excel.getSheetName(i));
			if(excel.getSheetName(i).equalsIgnoreCase("demo"))
			{
			XSSFSheet sheet = excel.getSheetAt(i);
			Iterator<Row> rows = sheet.rowIterator();
			Iterator<Cell> cells = rows.next().cellIterator();
			while(cells.hasNext())
			{
				Cell value = cells.next();
				if(value.getStringCellValue().equalsIgnoreCase("testcase"))
				{
					col=k;
				}
				k++;
			}	
           System.out.println(col);
		   while(rows.hasNext())
			{    
		    	Row r=rows.next();
				if(r.getCell(col).getStringCellValue().equalsIgnoreCase(testcasename))
				{
					Iterator<Cell> ce =r.cellIterator();
					while(ce.hasNext())
					{
						Cell c= ce.next();
						if(c.getCellTypeEnum()==CellType.STRING)
						{
						a.add(c.getStringCellValue());
						}
						else
						{
							a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						}
					}
				}
			}
		    break;
			}
			excel.close();	 
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
		
		Excel_Particular_row_column e= new Excel_Particular_row_column();
		ArrayList<String> Data = e.getData("Mobile");
		System.out.println(Data.get(0));
		System.out.println(Data.get(1));
		System.out.println(Data.get(2));
		System.out.println(Data.get(3));
		System.out.println(Data.get(4));
		System.out.println(Data);
		
	}
}
