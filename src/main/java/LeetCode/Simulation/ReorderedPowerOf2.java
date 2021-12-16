package LeetCode.Simulation;

public class ReorderedPowerOf2 {
    public boolean reorderedPowerOf2(int n) {
        String now = String.valueOf(n);
        long pow = 1;
        int length = now.length();
        while (length > 0) {
            pow *= length;
            length--;
        }
        while (pow-- >= 0) {
            if (!now.startsWith("0") && isPowerOf2(Integer.parseInt(now))) {
                return true;
            }
            now = getNext(now);
        }
        return false;
    }

    public boolean isPowerOf2(int n) {
        while (n > 1) {
            if (n % 2 != 0) {
                return false;
            }
            n /= 2;
        }
        return true;
    }

    public String getNext(String str) {
        char[] chars = str.toCharArray();
        int index = chars.length - 1;
        while (index > 0) {
            if (chars[index] > chars[index - 1]) {
                break;
            }
            index--;
        }
        if (index == 0) {
            return new String(revert(chars, 0, chars.length - 1));
        }
        int targetIndex = index - 1;
        while (index < chars.length) {
            if (chars[index] <= chars[targetIndex]) {
                break;
            }
            index++;
        }
        char tmp = chars[targetIndex];
        chars[targetIndex] = chars[index - 1];
        chars[index - 1] = tmp;
        return new String(revert(chars, targetIndex + 1, chars.length - 1));
    }

    public char[] revert(char[] chars, int left, int right) {
        while (left < right) {
            char tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }
        return chars;
    }

    public static void main(String[] args) {
        ReorderedPowerOf2 reorderedPowerOf2 = new ReorderedPowerOf2();
        System.out.println(reorderedPowerOf2.reorderedPowerOf2(56635));
    }
}
