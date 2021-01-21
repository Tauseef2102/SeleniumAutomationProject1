package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static XSSFWorkbook workbook; 
	static XSSFSheet sheet;
	static String projectPath;

	public ExcelUtils(String excelPath, String sheetName) {
		try {
			projectPath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
	}

	public static void main(String[] args) {
		getRowCount();
		getColCount();
		getCellData(0,0);
	}

	public static int getRowCount() {
		int rowCount=0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No. of rows: "+rowCount);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return rowCount;
	}

	public static int getColCount() {
		int colCount=0;
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
					System.out.println("No. of column: "+colCount);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return colCount;
	}


	public static String getCellData(int rownum, int colnum) {
		String cellData=null;
		try {
		cellData = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return cellData;
	}

}
