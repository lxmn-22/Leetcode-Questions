/*
(This problem is an interactive problem.)
You may recall that an array arr is a mountain array if and only if: arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. 
If such an index does not exist, return -1.
You cannot access the mountain array directly. You may only access the array using a MountainArray interface:
MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. 
Also, any solutions that attempt to circumvent the judge will result in disqualification.
 */

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
public class FindInMountainArray {
    // O(logN)time
    // O(1)space
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int maxIndex = getMaxValueIndex(mountainArr);
        int res = find(target, mountainArr, 0, maxIndex + 1, true);
        if (res == -1) {
            res = find(target, mountainArr, maxIndex, mountainArr.length(), false);
        }
        return res;
    }
    static int getMaxValueIndex(MountainArray mountainArr) {
        int n = mountainArr.length();
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r) >>> 1;
            int m = mountainArr.get(mid);
            int left = mid > 0 ? mountainArr.get(mid - 1) : -1;
            int right = mid + 1 < n ? mountainArr.get(mid + 1) : -1;
            if (left == -1) {
                return m > right ? 0 : 1;
            } 
            else if (right == -1) {
                return m > left ? n - 1 : n - 2;
            } 
            else if (m > left && m < right) {
                l = mid + 1;
            } 
            else if (m < left && m > right) {
                r = mid;
            }   
            else if (m > left && m > right) {
                return mid;
            }
        }
        return 0;
    }
    static int find(int target, MountainArray mountainArr, int l, int r, boolean left) {
        while (l < r) {
            int mid = (l + r) >>> 1;
            int m = mountainArr.get(mid);
            if (m > target) {
                if (left) {
                    r = mid;
                } 
                else {
                    l = mid + 1;
                }
            } 
            else if (m < target) {
                if (left) {
                    l = mid + 1;
                }
                else {
                    r = mid;
                }
            } 
            else {
                return mid;
            }
        }
        return -1;
    }
}