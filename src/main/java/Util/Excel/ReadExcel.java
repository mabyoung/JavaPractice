package Util.Excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
    public static List<Map<String, String>> readExcel(String filePath, int sheetIndex) {
        List<Map<String, String>> result = new ArrayList<>();
        Workbook workBook = getWorkBook(filePath);
        if (workBook == null || sheetIndex < 0) {
            return result;
        }
        Sheet sheet = workBook.getSheetAt(sheetIndex);
        if (sheet == null) {
            return result;
        }
        List<String> colName = getColName(sheet);
        int rowNum = sheet.getPhysicalNumberOfRows();
        int colNum = sheet.getRow(0).getPhysicalNumberOfCells();
        for (int i = 1; i < rowNum; i++) {
            Map<String, String> map = new LinkedHashMap<>();
            Row row = sheet.getRow(i);
            if (row != null) {
                for (int j = 0; j < colNum; j++) {
                    map.put(colName.get(j), getCellFormatValue(row.getCell(j)));
                }
                result.add(map);
            }
        }
        return result;
    }

    public static int getNumOfSheets(String filePath) {
        Workbook workBook = getWorkBook(filePath);
        return workBook.getNumberOfSheets();
    }

    public static String getSheetName(String filePath, int sheetIndex) {
        Workbook workBook = getWorkBook(filePath);
        Sheet sheet = workBook.getSheetAt(sheetIndex);
        return sheet.getSheetName();
    }

    private static List<String> getColName(Sheet sheet) {
        Row row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        List<String> colName = new ArrayList<>();
        for (int i = 0; i < colNum; i++) {
            colName.add(getCellFormatValue(row.getCell(i)));
        }
        return colName;
    }

    private static Workbook getWorkBook(String filePath) {
        if (filePath != null) {
            try {
                InputStream is = new FileInputStream(filePath);
                String extString = filePath.substring(filePath.lastIndexOf("."));
                if (".xls".equals(extString)) {
                    return new HSSFWorkbook(is);
                } else if (".xlsx".equals(extString)) {
                    return new XSSFWorkbook(is);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static String getCellFormatValue(Cell cell) {
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC: {
                    if (DateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        return format.format(date);
                    } else {
                        String result = (cell + "").trim();
                        if (result.length() > 2 && ".0".equals(result.substring(result.length() - 2))) {
                            return result.substring(0, result.length() - 2);
                        }
                        return result;
                    }
                }
                case Cell.CELL_TYPE_STRING: {
                    return cell.getRichStringCellValue().getString();
                }
                default:
                    return null;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ReadExcel readExcel = new ReadExcel();
        String filePath = "F:\\Downloads\\ChromeDownload\\book_list-个人管理-时间管理-投资-文化-宗教.xlsx";
        int numOfSheets = readExcel.getNumOfSheets(filePath);
        for (int i = 0; i < numOfSheets; i++) {
            List<Map<String, String>> list = readExcel(filePath, i);
            for (Map<String, String> map : list) {
                for (Entry<String, String> entry : map.entrySet()) {
                    System.out.print(entry.getKey() + ":" + entry.getValue() + ",");
                }
                System.out.println();
            }
        }
    }
}