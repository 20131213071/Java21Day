package java21Day;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/** 
 * @Title: ReadExcel 
 * @Description: 封装读取excel文件
 * @author Administrator 
 * @CreateDate 2017年3月13日 下午2:40:59  
 */
public class ReadExcel { 
	private String filepath;
	private String sheetname;
	private Workbook workbook;
	private Sheet sheet;
	private Row row;
	private Cell cell;
	private Boolean flag;
	private List<String> columeHeader;
	private List<List<String>> listData;
	private List<Map<String,String>> mapData;
	
	public ReadExcel(String filepath,String sheetname){
		this.filepath = filepath;
		this.sheetname = sheetname;
	    this.flag = false;
	    this.load();
	}
	
	public void load(){
		FileInputStream fs = null;
		try{
			fs = new FileInputStream(new File(filepath));
            workbook = WorkbookFactory.create(fs);
            sheet = workbook.getSheet(sheetname);
		}catch(Exception w){
			w.getMessage();
		}finally{
			try{
				if(fs!=null){
					fs.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	/** 
	 * @MethodName: getSheetData 
	 * @Description:获取sheet内的数据
	 *              listData是一行一个list，list内存放所有该行所有的列值
	 *              mapData是一行一个list，list内存放的是map，map的key是第一列header值
	 * @Parameter: 
	 * @return void
	 * @Example: TODO
	 * @ModificationHistory: 
	 * Author		Date		Description(Why & What is modified)
	 * -----------------------------------------------------------------------------------
	 * Administrator - 2017年3月13日 下午3:09:01 - First Release
	 * 
	 */
	private void getSheetData(){
		listData = new ArrayList<List<String>>();
		List<String> list = new ArrayList<String>();
		mapData = new ArrayList<Map<String,String>>();
		Map<String,String> map = new HashMap<String,String>();
		int rownum = sheet.getLastRowNum()+1;
		row = sheet.getRow(rownum);
		int clonum = row.getLastCellNum();
		if(row!=null){
			for(int i=0;i<rownum;i++){
				String key = row.getCell(i).getStringCellValue();
				for(int j=0;j<clonum;j++){
					String element = row.getCell(j).getStringCellValue();
				    list.add(element);
					map.put(key, element);
				}
				listData.add(list);
				if(i>0){
					mapData.add(map);
				}
			}
		}
		flag = true;
	}
	
	/** 
	 * @MethodName: getCellData 
	 * @Description:根据行列的index获取相应值
	 * @Parameter: @param rownum 从1开始
	 * @Parameter: @param clonum 从1开始
	 * @Parameter: @return
	 * @return String
	 * @Example: TODO
	 * @ModificationHistory: 
	 * Author		Date		Description(Why & What is modified)
	 * -----------------------------------------------------------------------------------
	 * Administrator - 2017年3月13日 下午3:08:29 - First Release
	 * 
	 */
	public String getCellData(int rownum,int clonum){
		if(rownum<=0||clonum<=0){
			return null;
		}
		if(!flag){
			this.getSheetData();
		}
		if(listData.size()>rownum && listData.get(rownum-1).size()>clonum){
			return listData.get(rownum-1).get(clonum-1);
		}else{
			return null;
		}
	}
	
	/** 
	 * @MethodName: getCellDate 
	 * @Description:根据行数以及第一列的列名，获取相应值
	 * @Parameter: @param rownum
	 * @Parameter: @param headername
	 * @Parameter: @return
	 * @return String
	 * @Example: TODO
	 * @ModificationHistory: 
	 * Author		Date		Description(Why & What is modified)
	 * -----------------------------------------------------------------------------------
	 * Administrator - 2017年3月13日 下午3:07:37 - First Release
	 * 
	 */
	public String getCellDate(int rownum,String headername){
		if(rownum<=0){
			return null;
		}
		if(!flag){
			this.getSheetData();
		}
		if(mapData.size()>=rownum && mapData.get(rownum-1).containsKey(headername)){
			return mapData.get(rownum-1).get(headername);
		}else{
			return null;
		}
	}
	
    /** 
     * @MethodName: getCellValue 
     * @Description: 根据cell对象，来获取每个cell值，所有的值数据转化为String类型
     * @Parameter: @return
     * @return String
     * @Example: TODO
     * @ModificationHistory: 
     * Author		Date		Description(Why & What is modified)
     * -----------------------------------------------------------------------------------
     * Administrator - 2017年3月21日 下午5:23:33 - First Release
     * 
     */
    private String getCellValue(){
    	String cellValue = "";
    	DataFormatter formatter = new DataFormatter();
		if(cell != null){
			switch(cell.getCellType()){
			case Cell.CELL_TYPE_NUMERIC:
				if(DateUtil.isCellDateFormatted(cell)){
					cellValue = formatter.formatCellValue(cell);
				}else{
					double douvalue = cell.getNumericCellValue();
					int intvalue = (int) douvalue;
					cellValue = douvalue - intvalue == 0?
				String.valueOf(intvalue):String.valueOf(douvalue);	
				}
				break;
			case Cell.CELL_TYPE_STRING:
				cellValue = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				cellValue = String.valueOf(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_FORMULA:
				cellValue = String.valueOf(cell.getCellFormula());
				break;
			case Cell.CELL_TYPE_BLANK:
				cellValue = "";
				break;
			case Cell.CELL_TYPE_ERROR:
				cellValue = "";
			default:
				cellValue = cell.toString().trim();
				break;
			}
		}
			return cellValue.trim();
    }
	public List<List<String>> getListData(){
		return listData;
	}
	public List<Map<String,String>> getMapData(){
		return mapData;
	}
	public static void main (String[] args){
		ReadExcel rx = new ReadExcel("c:\\log\\test.xlsx","test");
		System.out.println(rx.getCellData(1, 2));
		System.out.println(rx.getCellDate(1, "name"));
	}
}
	
	
	
