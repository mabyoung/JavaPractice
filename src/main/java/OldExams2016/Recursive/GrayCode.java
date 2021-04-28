package OldExams2016.Recursive;

public class GrayCode {
    public String[] getGray(int n) {
        if (n == 1) {
            return new String[]{"0", "1"};
        }
        int pow = (int) Math.pow(2, n);
        String[] result = new String[pow];
        String[] gray = getGray(n - 1);
        for (int i = 0; i < gray.length; i++) {
            result[i] = "0" + gray[i];
            result[pow - 1 - i] = "1" + gray[i];
        }
        return result;
    }

    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        String[] result = grayCode.getGray(4);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
