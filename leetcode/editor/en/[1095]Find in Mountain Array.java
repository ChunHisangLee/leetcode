
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

class Solution {
    MountainArray mountainArray;

    public int findInMountainArray(int target, MountainArray mountainArr) {
        this.mountainArray = mountainArr;
        int length = mountainArr.length();
        int peakIndex = binarySearch(1, length - 2, target, 1);
        int left = binarySearch(0, peakIndex, target, 2);

        if (mountainArr.get(left) == target) {
            return left;
        }

        left = binarySearch(peakIndex + 1, length - 1, target, 3);

        if (mountainArr.get(left) == target) {
            return left;
        }

        return -1;
    }

    private int binarySearch(int left, int right, int target, int type) {
        while (left != right) {
            int mid = (left + right) >> 1;
            int value = mountainArray.get(mid);

            switch (type) {
                case 1:
                    int nextValue = mountainArray.get(mid + 1);
                    if (value < nextValue) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                    break;
                case 2:
                    if (value < target) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                    break;
                case 3:
                    if (value > target) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                    break;
            }
        }

        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
Binary find peak in the mountain.
852. Peak Index in a Mountain Array
Binary find the target in strict increasing array
Binary find the target in strict decreasing array
Tip
Personally,
If I want find the index, I always use while (left < right)
If I may return the index during the search, I'll use while (left <= right)


    int findInMountainArray(int target, MountainArray A) {
        int n = A.length(), l, r, m, peak = 0;
        // find index of peak
        l  = 0;
        r = n - 1;
        while (l < r) {
            m = (l + r) / 2;
            if (A.get(m) < A.get(m + 1))
                l = peak = m + 1;
            else
                r = m;
        }
        // find target in the left of peak
        l = 0;
        r = peak;
        while (l <= r) {
            m = (l + r) / 2;
            if (A.get(m) < target)
                l = m + 1;
            else if (A.get(m) > target)
                r = m - 1;
            else
                return m;
        }
        // find target in the right of peak
        l = peak;
        r = n - 1;
        while (l <= r) {
            m = (l + r) / 2;
            if (A.get(m) > target)
                l = m + 1;
            else if (A.get(m) < target)
                r = m - 1;
            else
                return m;
        }
        return -1;
    }
 */