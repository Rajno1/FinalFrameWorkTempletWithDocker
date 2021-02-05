package com.issi.utils;

import com.issi.constants.FrameWorkConstants;
import com.issi.exceptions.FrameWorkExceptions;
import com.issi.exceptions.InvalidExcelPathException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Utility class to read or write to excel.
 */
public final class ExcelUtils {

    /**
     * Private constructor to avoid external instantiation
     */
    private ExcelUtils() {
    }

    /**
     * Encapsulates all the value from the mentioned excel sheet and store it in
     * List holding HashMaps. Key for the map in the column header in the excel sheet.
     *
     * @param sheetName Excel sheetname to read the value from
     * @return List where each index holds a map and Each map holds the details about the test
     * TODO create reusable methods
     */
    public static List<Map<String,String>> getTestDetails(String sheetName) {
        List<Map<String, String>> list = null;


        try(FileInputStream fs = new FileInputStream(FrameWorkConstants.getExcelPath())) {

            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet = workbook.getSheet(sheetName);


            int lastRowNumber = sheet.getLastRowNum();
            int lastColumnum = sheet.getRow(0).getLastCellNum();

            Map<String, String> map = null;
            list = new ArrayList<Map<String, String>>();

            for (int i = 1; i <=lastRowNumber; i++) {
                map = new HashMap<String, String>();
                for (int j = 0; j < lastColumnum; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                list.add(map);
            }
        } catch (FileNotFoundException e) {
            throw new InvalidExcelPathException("Excel file you are trying to read is not found"); // it will terminate the programe after exception found
        } catch (IOException e) {
            throw new FrameWorkExceptions("Some IO Exception happen while reading data from excel");
        }
        return list;
    }
}
