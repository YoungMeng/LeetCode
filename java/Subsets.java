/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * <p>
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,3], a solution is:
 * <p>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */

import java.util.Arrays;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();

        if (nums == null)
            return ret;

        Arrays.sort(nums);
        subsets(ret, path, 0, nums);

        return ret;
    }

    public void subsets(List<List<Integer>> ret, List<Integer> path, int step, int[] nums) {
        if (step == nums.length) {
            ret.add(new ArrayList<Integer>(path));
            return;
        }

        //不选nums[step]
        subsets(ret, path, step + 1, nums);

        //选nums[step]
        path.add(nums[step]);
        subsets(ret, path, step + 1, nums);
        path.remove(path.size() - 1);
    }
}
