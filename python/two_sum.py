class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        d = {}
        i = 0
        for num in nums:
            if target - num in d:
                return d[target - num], i
            d[num] = i
            i += 1