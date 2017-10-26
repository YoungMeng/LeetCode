class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        len1 = len(nums1)
        len2 = len(nums2)
        if (len1 + len2) % 2 == 0:
            return (self.findKth(nums1, nums2, (len1 + len2) / 2) + self.findKth(nums1, nums2, (len1 + len2) / 2 + 1)) * 0.5
        else:
            return self.findKth(nums1, nums2, (len1 + len2) / 2 + 1)

    def findKth(self, A, B, k):
        lena = len(A)
        lenb = len(B)
        if lena > lenb:
            return self.findKth(B, A, k)
        if lena == 0:
            return B[k - 1]
        if k == 1:
            return min(A[0], B[0])

        pa = min(k / 2, lena)
        pb = k - pa
        if A[pa - 1] <= B[pb - 1]:
            return self.findKth(A[pa:], B, pb)
        else:
            return self.findKth(A, B[pb:], pa)
