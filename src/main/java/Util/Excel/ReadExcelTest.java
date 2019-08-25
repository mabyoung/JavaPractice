package Util.Excel;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ReadExcelTest {
    public void dealDoubanBook(String excelFilePath, String sqlFilePath) {
        try {
            File sqlFile = new File(sqlFilePath);
            if (sqlFile.exists()) {
                if (!sqlFile.delete()) {
                    System.out.println("删除文件失败！！！直接退出");
                    return;
                }
            }
            PrintWriter printWriter = new PrintWriter(new FileWriter(sqlFile, true), true);//第二个参数为true，从文件末尾写入 为false则从开头写入
            int numOfSheets = ReadExcel.getNumOfSheets(excelFilePath);
            for (int i = 0; i < numOfSheets; i++) {
                List<Map<String, String>> excelContentMapList = ReadExcel.readExcel(excelFilePath, i);
                String sheetName = ReadExcel.getSheetName(excelFilePath, i);
                for (Map<String, String> excelContentMap : excelContentMapList) {
                    String sql = "insert into book(book_name, score, evaluator_num, author, publishing_house, published_date, price, book_type) values (\"$1\", $2, $3, \"$4\", \"$5\", \"$6\", \"$7\", \"$8\");";
                    sql = sql.replace("$1", quotationEscape(excelContentMap.get("书名")));
                    sql = sql.replace("$2", excelContentMap.get("评分"));
                    sql = sql.replace("$3", excelContentMap.get("评价人数"));
                    sql = sql.replace("$4", quotationEscape(excelContentMap.get("作者")));
                    String publishInfo = excelContentMap.get("出版社");
                    String[] split = publishInfo.split("/");
                    if (split.length >= 3) {
                        sql = sql.replace("$5", quotationEscape(split[0].trim()));
                        sql = sql.replace("$6", quotationEscape(split[1].trim()));
                        sql = sql.replace("$7", quotationEscape(split[2].trim()));
                        sql = sql.replace("$8", quotationEscape(sheetName));
                        printWriter.println(sql);
                    }
                }
                System.out.println(excelFilePath + "  " + ReadExcel.getSheetName(excelFilePath, i) + "  处理完成");
            }
            printWriter.close();//记得关闭输入流
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String quotationEscape(String str) {
        str = str.replace("\"", "\\\"");
        return str.replace("\'", "\\\'");
    }

    public static void main(String[] args) {
        ReadExcelTest readExcelTest = new ReadExcelTest();
        String excelFileDirection = "F:\\Downloads\\ChromeDownload\\DouBanSpider-master";
        File file = new File(excelFileDirection);
        for (File listFile : Objects.requireNonNull(file.listFiles())) {
            String fileName = listFile.getName();
            if (fileName.length() >= 5 && ".xlsx".equals(fileName.substring(fileName.length() - 5)) && fileName.charAt(0) != '~') {
                String sqlFilePath = "C:\\Users\\mabyo\\Desktop\\sql" + fileName + ".txt";
                readExcelTest.dealDoubanBook(excelFileDirection + "\\" + fileName, sqlFilePath);
            }
        }
    }
}
