package cn.pms.ssm.excel;

import java.io.File;
import java.io.FileInputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/** 
 * <p>Title:JxlReadExcel</p> 
 * <p>Description:读取excel文件，保存到map </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年6月13日
 * @version 1.0 
*/
public class JxlReadExcel {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<Map> ReaderExcel(File file){		
		
		/*
		 * workbook : 工作簿,就是整个Excel文档
		 * sheet : 工作表
		 * cell : 一个单元格
		 * row : 一行
		 */
		
		if(checkExcel2007(file)){
			return importToExcel2007(file);
		}
		
		//初始化返回值和字段名数组
		ArrayList<Map> arr = new ArrayList<Map>();
		String[] title;
		Workbook workbook = null;
		
		try{
			//读取Excel文件
			workbook = Workbook.getWorkbook(new File("e:/test.xls"));
			//总Sheet数
			int sheetNumber = workbook.getNumberOfSheets();
			System.out.println("Sheet总数: "+sheetNumber);
			for (int i = 0; i < sheetNumber; i++) {
				Sheet sheet = workbook.getSheet(i);
				
				//当前页 总记录行数和列数
				int rowCount = sheet.getRows();			//获取行数
				int columeCount = sheet.getColumns();	//获取列数
				System.out.println("总记录数 : "+rowCount);
				System.out.println("总列数 : "+columeCount);
				
				//第一行为字段名,所以行数大于一才执行
				if(rowCount > 1 && columeCount >0){
					//取第一列 为 字段名
					title = new String[columeCount];
					for (int j = 0; j < columeCount; j++) {
						title[j] = sheet.getCell(j,0).getContents().trim();
					}
					
					//取当前页所有值放入list中
					for (int h = 1; h < rowCount; h++) {	//行数
						LinkedHashMap dataMap = new LinkedHashMap();
						for (int k = 0; k < columeCount; k++) {	//列数
							dataMap.put(title[k], sheet.getCell(k,h).getContents());	//getContents() 获取单元格的值
						}
						arr.add(dataMap);
					}
				}							
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(workbook != null){
				workbook.close();
				workbook = null;
			}
		}		
		return arr;
	}

	/**
	 * 根据文件扩展名判断是否是Excel 2007 以上
	 * @param file
	 * @return
	 */
	private static boolean checkExcel2007(File file){
		String extendName = file.getName().substring(file.getName().lastIndexOf("."));
		if(extendName.equals(".xlsx")){
			return true;
		}
		return false;
	}
	
	
	/**
	 *	根据传入的Excel行数据,得到Map数据 
	 * @param row
	 * @param cells
	 * @param title
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static Map getCellMap(XSSFRow row , int cells , String[] title){
		//初始化
		Map data = new HashMap();
		XSSFCell cell = null;
		
		//分列
		for (int i = 0; i < cells; i++) {
			//列为空,则输入空字符串
			if(row.getCell(i) == null){
				data.put(title[i], "");
				continue;
			}
			cell = row.getCell(i);
			switch (cell.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:{
					if(DateUtil.isCellDateFormatted(cell)){
						data.put(title[i], cell.getDateCellValue());
					}else{
						NumberFormat nf = NumberFormat.getInstance();
						nf.setGroupingUsed(false);
						data.put(title[i], nf.format(cell.getNumericCellValue()));
					}
					break;
				}
				case Cell.CELL_TYPE_STRING:{
					data.put(title[i], cell.getRichStringCellValue());
					break;
				}
				case Cell.CELL_TYPE_BOOLEAN:{
					data.put(title[i], cell.getBooleanCellValue());
					break;
				}
				default:
					data.put(title[i], "");
			}
		}			
		return data;
	}
	
	/**
	 * 输入2007版以上excel文件,解析后返回ArrayList(有个bug,暂时不用,保留)
	 * @param file
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static ArrayList<Map> importToExcel2007(File file){
		ArrayList<Map> arr = new ArrayList<Map>();
		String[] title;
		
		//初始化
		FileInputStream readFile = null;
		XSSFWorkbook workbook = null;
		XSSFRow row = null;
		XSSFSheet sheet = null;
		XSSFCell cell = null;
		
		try{			
			//读取文件
			readFile = new FileInputStream(file);
			workbook = new XSSFWorkbook(readFile);
			
			//文档页数
			int numOfSheets = workbook.getNumberOfSheets();
			System.out.println("文档页数 : "+numOfSheets);
			
			for (int i = 0; i < numOfSheets; i++) {				
				//获取当前的sheet(工作表)
				sheet = workbook.getSheetAt(i);
				//获取当前页的行数
				int sheetRows = sheet.getLastRowNum();				
				System.out.println("当前页总行数 : "+sheetRows);
				//如果当前页行数大于0,则先取第一行为字段名
				if(sheetRows > 0){
					row = sheet.getRow(0);	//当前页 第一行
					int cells = row.getLastCellNum();	//第一行 单元格数量
					title = new String[cells];
					for (int j = 0; j < cells; j++) {
						//列为空,则输入空字符串
						if(row.getCell(j) == null){
							title[j] = "";
							continue;
						}
						cell = row.getCell(j);
						switch (cell.getCellType()) {
							case Cell.CELL_TYPE_NUMERIC:{
								Integer num = new Integer((int) cell.getNumericCellValue());
								title[j] = String.valueOf(num);
								break;
							}
							case Cell.CELL_TYPE_STRING:{
								title[j] = cell.getRichStringCellValue().toString();
								break;
							}
							default:
								title[j] = "";
						}
					}					
					//分行解析
					for (int j = 0; j < sheetRows; j++) {
						//如果是空行,则继续下一条
						if(sheet.getRow(j) == null){
							continue;
						}
						//将每行数据放入map中
						row = sheet.getRow(j);
						arr.add(getCellMap(row,cells,title));
					}					
				}
			}							
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				readFile.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arr;
	}
}


		
