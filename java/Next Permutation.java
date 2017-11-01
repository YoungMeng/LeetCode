/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place, do not allocate extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */

public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2)
            return;

        int i = nums.length - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int j = i + 1;
                while (j < nums.length && nums[j] > nums[i]) {
                    j++;
                }
                swap(nums, i, j - 1);
                reverseArray(nums, i + 1, nums.length - 1);
                break;
            }
        }

        if (i < 0)//说明数组完全降序排列
            reverseArray(nums, 0, nums.length - 1);

    }

    //反转数组
    public void reverseArray(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);

            left++;
            right--;
        }
    }

    //交换元素
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
