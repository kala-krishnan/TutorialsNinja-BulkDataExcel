package com.tutorialNinjas.bulktesting.utility;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tutorialNinjas.bulktesting.DataPojos.RegisterPojos;

public class ExcelUtils {
	
	
	public static Map<String, List<RegisterPojos>> readExcelData(String filePath, String sheetName, String keyColumn) throws IOException {
        LinkedHashMap<String, List<RegisterPojos>> dataMap = new LinkedHashMap<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
        	XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

        	XSSFSheet sheet = workbook.getSheet(sheetName);
            int keyColumnIndex = findColumnIndex(sheet, keyColumn);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            	XSSFRow row = sheet.getRow(i);
                String keyValue = getCellValue(row.getCell(keyColumnIndex));

                
                RegisterPojos registerData = new RegisterPojos();
                registerData.setFirstName(getCellValue(row.getCell(1)));
                registerData.setLastName(getCellValue(row.getCell(2)));
                registerData.setEmail(getCellValue(row.getCell(3)));
                registerData.setTelephone(getCellValue(row.getCell(4)));
                registerData.setPassword(getCellValue(row.getCell(5)));
                registerData.setConfirmpassword(getCellValue(row.getCell(6)));
                registerData.setSubcribeValue(getCellValue(row.getCell(7)));
               dataMap.computeIfAbsent(keyValue, k -> new ArrayList<>()).add(registerData);
                
                
            }
        }

        return dataMap;
    }

    private static int findColumnIndex(XSSFSheet sheet, String columnName) {
    	if (sheet == null || sheet.getLastRowNum() < 1) {
            throw new IllegalArgumentException("Sheet is empty or null.");
        }
    	for(int k=0;k<=sheet.getLastRowNum();k++ )
    	{
    	XSSFRow headerRow = sheet.getRow(k);
    	if (headerRow == null) {
            throw new IllegalArgumentException("Header row is null.");
        }
    	
        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            if (getCellValue(headerRow.getCell(i)).equalsIgnoreCase(columnName)) {
                return i;
            }
        }}
        throw new IllegalArgumentException("Column not found: " + columnName);
    }

    private static String getCellValue(XSSFCell cell) {
        if (cell == null) {
            return "";
        }
        if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        } else {
            return cell.getStringCellValue();
        }
    }

}
