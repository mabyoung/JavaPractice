package OldExams2016.String;

public class StringFormat {
    public String formatString(String A, int n, char[] arg, int m) {
        int argIndex = 0;
        StringBuilder result = new StringBuilder();
        char[] chars = A.toCharArray();
        for (int i = 1; i <= chars.length; i++) {
            if (i < chars.length && chars[i - 1] == '%' && chars[i] == 's') {
                result.append(arg[argIndex++]);
            } else if (!(i > 1 && chars[i - 2] == '%' && chars[i - 1] == 's')) {
                result.append(chars[i - 1]);
            }
        }
        for (int i = argIndex; i < arg.length; i++) {
            result.append(arg[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        StringFormat stringFormat = new StringFormat();
        String result = stringFormat.formatString("A%sC%sE", 7, new char[]{'B', 'D', 'F'}, 7);
        System.out.println(result);
    }
}
