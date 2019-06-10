package LeetCode.Dynamic;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */
public class Candy {
    public int candy(int[] ratings) {
        int num = ratings.length;
        int[] candy = new int[num];
        for (int i = 0; i < num; i++) {
            candy[i] = 1;
        }
        for (int i = 0; i < num - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                candy[i + 1] = candy[i] + 1;
            }
        }
        for (int i = num - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i] && candy[i - 1] <= candy[i]) {
                candy[i - 1] = candy[i] + 1;
            }
        }
        int sum = 0;
        for (int item : candy) {
            sum += item;
        }
        return sum;
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        int[] ratings = new int[]{4, 2, 3, 4, 1};
        candy.candy(ratings);
    }
}
