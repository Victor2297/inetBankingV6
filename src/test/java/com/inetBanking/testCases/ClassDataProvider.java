package com.inetBanking.testCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.inetBanking.utilities.XLUtils;

public class ClassDataProvider {

    public static XSSFWorkbook workbook;
    public static XSSFSheet worksheet;
    public static DataFormatter formatter= new DataFormatter();
    public static String file_location = "C:\\Users\\Victor\\eclipse-workspace\\inetBankingV6\\src\\test\\java\\com\\inetBanking\\testData\\names.xlsx";
    static String SheetName= "Sheet1";
    public  String Res;
    public int DataSet=-1;
    static OPCPackage pkb;
    
	@DataProvider(name = "Data")
		public static String[][]getData() throws IOException {
			String excelPath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\inetBanking\\testData\\names.xlsx";
			int rownum = XLUtils.getRowCount(excelPath, "Sheet1");
			int cocount = XLUtils.getCellCount(excelPath, "Sheet1", 1);
			String loginData[][] = new String[rownum][cocount];
			for(int i = 1; i <= rownum; i++) {
				for(int j = 0; j < cocount; j++) {
					loginData[i-1][j] = XLUtils.getCellData(excelPath, "Sheet1", i, j);
				}
			}
			return loginData;
		}
}