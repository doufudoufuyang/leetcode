class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        if (size % 2 != 0){
            return 1.0 * findKSmallestInSortedArrays(nums1, nums2, 0, 0, size / 2 + 1);
        }
        return (findKSmallestInSortedArrays(nums1, nums2, 0, 0, size / 2 + 1) + findKSmallestInSortedArrays(nums1, nums2, 0, 0, size / 2)) / 2.0;
    }

    private int findKSmallestInSortedArrays(int[] one, int[] two, int oneLeft, int twoLeft, int k){
        if (oneLeft >= one.length){
            return two[twoLeft + k - 1];
        }
        if (twoLeft >= two.length){
            return one[oneLeft + k - 1];
        }
        if (k == 1){
            return Math.min(one[oneLeft], two[twoLeft]);
        }

        int oneValue = oneLeft + k / 2 - 1 >= one.length ? Integer.MAX_VALUE : one[oneLeft + k / 2 - 1];
        int twoValue = twoLeft + k / 2 - 1 >= two.length ? Integer.MAX_VALUE : two[twoLeft + k / 2 - 1];

        if (oneValue >= twoValue){
            return findKSmallestInSortedArrays(one, two, oneLeft, twoLeft + k / 2, k - k / 2);
        }
        return findKSmallestInSortedArrays(one, two, oneLeft + k / 2, twoLeft, k - k / 2);
    }
}