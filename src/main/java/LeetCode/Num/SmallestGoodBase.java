package LeetCode.Num;

public class SmallestGoodBase {
    public String smallestGoodBase(String n) {
        Long num = Long.valueOf(n);
        for (long i = 2; i < num; i++) {
            if (isGoodBase(num, i)){
                return String.valueOf(i);
            }
        }
        return null;
    }

    public boolean isGoodBase(long num, long base){
        while(num != 1){
            if (num %base != 1){
                return false;
            }
            num /= base;
        }
        return true;
    }

    public static void main(String[] args) {
        SmallestGoodBase smallestGoodBase = new SmallestGoodBase();
        String result = smallestGoodBase.smallestGoodBase("1000000000000000000");
        System.out.println(result);
    }
}
