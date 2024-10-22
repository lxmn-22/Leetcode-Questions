/*
 * Given an integer array sorted in non-decreasing order, there is exactly one
 * integer in the array that occurs more than 25% of the time, return that
 * integer.
 * 
 * Example 1:
 * Input: arr = [1,2,2,6,6,6,6,7,10]
 * Output: 6
 * 
 * Example 2:
 * Input: arr = [1,1]
 * Output: 1
 */
class ElementsAppearingMoreThanTwentyFivePercentSortedArray {

    enum Direction {
        LEFT, RIGHT
    };

    public static int findSpecialInteger(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }
        List<Integer> list = Arrays.asList(arr[n / 4], arr[n / 2], arr[3 * n / 4]);
        for (int num : list) {
            int firstPosition = getPosition(arr, num, Direction.LEFT);
            int lastPosition = getPosition(arr, num, Direction.RIGHT);
            if (lastPosition - firstPosition + 1 > n / 4) {
                return num;
            }
        }
        return -1;
    }

    private int getPosition(int[] nums, int num, Direction direction) {
        int left = 0;
        int right = nums.length - 1;
        int idx = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == num) {
                idx = mid;
                if (direction == Direction.LEFT) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return idx;
    }
}