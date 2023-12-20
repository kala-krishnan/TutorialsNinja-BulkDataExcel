package com.tutorialNinjas.bulktesting.utility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tutorialNinjas.bulktesting.DataPojos.RegisterPojos;

import java.io.IOException;

public class ExcelDataMapUtils {
	
	 public static List<Map<String, String>> batchXLdata(String dataKey, String sheetName) throws IOException {
	        String excelURL = System.getProperty("user.dir")+"//src//test//resources//ExcelData//TutorialNinjasData.xlsx";
	        Map<String, List<RegisterPojos>> dataMap = ExcelUtils.readExcelData(excelURL, sheetName, dataKey);

	        if (dataMap.containsKey(dataKey)) {
	            List<RegisterPojos> registerDataList = dataMap.get(dataKey);
	            List<Map<String, String>> resultList = new ArrayList<>();
	            for (RegisterPojos registerData : registerDataList) {
	                Map<String, String> result = new HashMap<>();
	                result.put("FirstName", registerData.getFirstName());
	                result.put("LastName", registerData.getLastName());
	                result.put("email", registerData.getEmail());
	                result.put("telephone",String.valueOf(registerData.getTelephone()));
	                result.put("password", registerData.getPassword());
	                result.put("confirmpassword", registerData.getConfirmpassword());
	                result.put("subcribeValue", registerData.getSubcribeValue());
	                
	                resultList.add(result);
	            }

	            return resultList;
	        } else {
	            throw new IllegalArgumentException("NO DATA FOUND for dataKey: " + dataKey);
	        }
	    }

}
