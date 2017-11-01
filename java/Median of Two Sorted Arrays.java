/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int lengthA = A.length;
        int lengthB = B.length;
        int lengthAB = lengthA + lengthB;
        if (lengthAB % 2 == 0)
            return (findKth(A, 0, lengthA - 1, B, 0, lengthB - 1, lengthAB / 2)
                    + findKth(A, 0, lengthA - 1, B, 0, lengthB - 1, lengthAB / 2 + 1)) / 2;
        else
            return findKth(A, 0, lengthA - 1, B, 0, lengthB - 1, lengthAB / 2 + 1);
    }


    public double findKth(int[] A, int startA, int endA, int[] B, int startB, int endB, int k) {
        int lenA = endA - startA + 1;
        int lenB = endB - startB + 1;
        if (lenA > lenB)
            return findKth(B, startB, endB, A, startA, endA, k);
        if (lenA == 0)
            return B[startB + k - 1];
        if (k == 1)
            return A[startA] < B[startB] ? A[startA] : B[startB];

        int pA = k / 2 < lenA ? k / 2 : lenA;
        int pB = k - pA;
        if (A[startA + pA - 1] < B[startB + pB - 1])
            return findKth(A, startA + pA, endA, B, startB, endB, k - pA);
        else if (A[startA + pA - 1] > B[startB + pB - 1])
            return findKth(A, startA, endA, B, startB + pB, endB, k - pB);
        else
            return A[startA + pA - 1];
    }
}
