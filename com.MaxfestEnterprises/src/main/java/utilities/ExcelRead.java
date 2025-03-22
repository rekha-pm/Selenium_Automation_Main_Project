package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	static FileInputStream f;
	static XSSFWorkbook wb;
	static XSSFSheet sh;

	public static String getStringData(int row, int col,String sheetName) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\excelFile\\DataSheet.xlsx");
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheetName);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getStringCellValue();
	}

	public static String getIntegerData(int row, int col,String sheetName) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\excelFile\\DataSheet.xlsx");
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheetName);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		int cellValue = (int) (c.getNumericCellValue());
		return String.valueOf(cellValue);
	}
}
