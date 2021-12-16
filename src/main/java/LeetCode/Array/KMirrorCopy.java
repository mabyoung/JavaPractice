package LeetCode.Array;

public class KMirrorCopy {

    public String getK(long num, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        while (num > 0) {
            stringBuilder.append(num % k);
            num /= k;
        }
        return stringBuilder.reverse().toString();
    }

    public boolean isMirror(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        KMirrorCopy kMirror = new KMirrorCopy();
        int count = 0;
        for (long i = 1; i < Long.MAX_VALUE; i++) {
            if (kMirror.isMirror(String.valueOf(i)) && kMirror.isMirror(kMirror.getK(i, 7))) {
                System.out.println(i);
                count++;
            }
            if (count >= 30) {
                System.out.println("finish");
                break;
            }
        }
    }
}
