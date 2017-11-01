/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * <p>
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 */
/**
 先排序，采用夹逼的方式，过滤到重复元素
 */

import java.util.Arrays;
import java.util.ArrayList;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null) return null;

        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (nums.length < 4) return lists;

        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    int data = target - nums[left] - nums[right] - nums[i] - nums[j];
                    if (data == 0) {
                        if (left > j + 1 && nums[left] == nums[left - 1]) {
                            left++;
                            continue;
                        }
                        if (right < len - 1 && nums[right] == nums[right + 1]) {
                            right--;
                            continue;
                        }

                        ArrayList<Integer> item = new ArrayList<Integer>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[left]);
                        item.add(nums[right]);
                        lists.add(item);
                        left++;
                        right--;
                    } else if (data > 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return lists;
    }
}
