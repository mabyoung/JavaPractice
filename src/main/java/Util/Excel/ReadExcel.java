package Util.Excel;

import java.io.*;

import jxl.Sheet;
import jxl.Workbook;

public class ReadExcel {
    public static void main(String[] args) {
        ReadExcel obj = new ReadExcel();
        // 此处为我创建Excel路径：E:/zhanhj/studysrc/jxl下
        File file = new File("F:\\Downloads\\ChromeDownload\\DouBanSpider-master\\book_list-计算机-机器学习-linux-android-数据库-互联网.xls");
        obj.readExcel(file);
        System.out.println("list中的数据打印出来");
    }

    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
    public void readExcel(File file) {
        try {
            File sqlFile = new File("C:\\Users\\mabyo\\Desktop\\sql.txt");//传入文件/目录的路径
            if (sqlFile.exists()) {
                boolean delete = sqlFile.delete();
                if (!delete) {
                    System.out.println("删除文件失败！！！直接退出");
                    return;
                }
            }
            PrintWriter printWriter = new PrintWriter(new FileWriter(sqlFile, true), true);//第二个参数为true，从文件末尾写入 为false则从开头写入

            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            for (int index = 0; index < sheet_size; index++) {
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 1; i < sheet.getRows(); i++) {
                    // sheet.getColumns()返回该页的总列数
                    String sql = new String("insert into book(book_name, score, evaluator_num, author, publishing_house, published_date, price, book_type) values (\"$1\", $2, $3, \"$4\", \"$5\", \"$6\", \"$7\", \"$8\");");
                    sql = sql.replace("$1", quotationEscape(sheet.getCell(1, i).getContents()));
                    sql = sql.replace("$2", sheet.getCell(2, i).getContents());
                    sql = sql.replace("$3", sheet.getCell(3, i).getContents());
                    sql = sql.replace("$4", quotationEscape(sheet.getCell(4, i).getContents()));
                    String publishInfo = sheet.getCell(5, i).getContents();
                    String[] split = publishInfo.split("/");
                    if (split.length < 3) {
                        continue;
                    }
                    sql = sql.replace("$5", quotationEscape(split[0].trim()));
                    sql = sql.replace("$6", quotationEscape(split[1].trim()));
                    sql = sql.replace("$7", quotationEscape(split[2].trim()));
                    sql = sql.replace("$8", quotationEscape(sheet.getName()));
                    printWriter.println(sql);
                }
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
}