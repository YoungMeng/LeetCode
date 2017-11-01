/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */

public class Solution {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        candy[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            candy[i] = ratings[i] > ratings[i - 1] ? candy[i - 1] + 1 : 1;
        }

        int total = candy[ratings.length - 1];
        for (int j = ratings.length - 2; j >= 0; j--) {
            candy[j] = (ratings[j] > ratings[j + 1] && candy[j + 1] + 1 > candy[j]) ?
                    candy[j + 1] + 1 : candy[j];
            total += candy[j];
        }

        return total;
    }
}
