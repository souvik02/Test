package DemoMavenProject.Data;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	
	public Data(String excel)
	{
		try
		{
			File file = new File(excel);
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	public String getData(int sheetNum,int row, int col)
	{
		sheet = wb.getSheetAt(sheetNum);
		String data = sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	
	

}
