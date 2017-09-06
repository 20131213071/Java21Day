package java21Day;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class OpExcel {
	public static void readBasicExcle(String filepath) {
		try{
			File file = new File(filepath);
			FileInputStream fs = new FileInputStream(file);
			Workbook workBook = WorkbookFactory.create(fs);
			Sheet sh = workBook.getSheet("sheet1");
			int numOfRows = sh.getLastRowNum()+1;
			Row row = sh.getRow(0);
			int numOfColumn = row.getLastCellNum();
			Cell cell = row.getCell(0);
			String value = cell.getStringCellValue();
		}catch(FileNotFoundException e){
		    e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}catch(InvalidFormatException e){
			e.printStackTrace();
		}catch(IOException e){
		}
	}
	public static void main (String[] args){
		OpExcel.readBasicExcle("D:/smx.xlsx");
	}
}
