package LeetCode.Array;

public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int index = getIndex(letters, target);
        if (index == -1) {
            return letters[0];
        }
        return letters[index];
    }

    public int getIndex(char[] letters, char target) {
        if (letters[letters.length - 1] <= target) {
            return -1;
        }
        int left = 0;
        int right = letters.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
