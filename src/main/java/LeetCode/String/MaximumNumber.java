package LeetCode.String;

public class MaximumNumber {
    public String maximumNumber(String num, int[] change) {
        char[] nums = num.toCharArray();
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i] - '0';
            if (change[value] > value) {
                nums[i] = (char) (change[value] + '0');
                flag = true;
            } else if (flag && change[value] < value) {
                break;
            }
        }
        return new String(nums);
    }

    public static void main(String[] args) {
        MaximumNumber maximumNumber = new MaximumNumber();
        String result = maximumNumber.maximumNumber("214010", new int[]{6, 7, 9, 7, 4, 0, 3, 4, 4, 7});
        System.out.println(result);
    }
}
