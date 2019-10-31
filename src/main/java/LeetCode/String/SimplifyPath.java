package LeetCode.String;

import java.util.LinkedList;

/**
 * 请简化给出的Unix样式的文件绝对路径，也就是转换成规范路径
 * 在Unix样式的文件系统中， .代表当前目录，.. 表示将目录向上移动一级，更多的介绍可以查看 Absolute path vs relative path in Linux/Unix
 * 请注意，返回的规范路径必须以斜杠“/”开头，并且两个目录名之间只能有一个斜杠“/”开头。如果存在的最后一级目录的话不能以“/”结尾。另外，转化出的规范路径必须是能表示给出的绝对路径的最短字符串。
 * 例如：
 * 文件路径 = "/home/", =>"/home"
 * 文件路径 = "/a/./b/../../c/", =>"/c"
 * 特殊样例：
 * 你有考虑过样例 文件路径 ="/../"吗? 这个样例应该返回"/".
 * 另一种特殊样例是路径中可能相邻的有多个“/”，例如“/home//foo/”。这种情况下应该忽略多余的“/”，这个样例应该返回"/home/foo".
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        LinkedList<String> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        for (String s : path.split("/")) {
            if ("..".equals(s)) {
                if (!queue.isEmpty()){
                    queue.removeLast();
                }
            } else if (!".".equals(s) && !"".equals(s)) {
                queue.addLast(s);
            }
        }
        while (!queue.isEmpty()) {
            result.append("/").append(queue.pollFirst());
        }
        if ("".contentEquals(result)){
            result.append("/");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/.."));
        System.out.println(simplifyPath.simplifyPath("/home/"));
        System.out.println(simplifyPath.simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath.simplifyPath("/home/foo/"));
        System.out.println(simplifyPath.simplifyPath("///"));
    }
}
