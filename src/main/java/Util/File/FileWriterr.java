package Util.File;

import java.io.*;

public class FileWriterr {
    public boolean ReName(String path,String newname) {//文件重命名
        //Scanner scanner=new Scanner(System.in);
        File file=new File(path);
        if(file.exists()) {
            File newfile=new File(file.getParent()+File.separator+newname);//创建新名字的抽象文件
            if(file.renameTo(newfile)) {
                System.out.println("重命名成功！");
                return true;
            }
            else {
                System.out.println("重命名失败！新文件名已存在");
                return false;
            }
        }
        else {
            System.out.println("重命名文件不存在！");
            return false;
        }

    }
    public void writeFile() throws Exception {
        File file=new File("C:\\Users\\mabyo\\Desktop");//传入文件/目录的路径

        PrintWriter printWriter =new PrintWriter(new FileWriter(file,true),true);//第二个参数为true，从文件末尾写入 为false则从开头写入
        printWriter.println("I am your father");
        printWriter.close();//记得关闭输入流
    }
}
