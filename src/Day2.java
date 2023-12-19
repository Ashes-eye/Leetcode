public class Day2 {
    /**
     * Given an array of positive integers nums and a positive integer target, return the minimal length of a
     * subarray
     *  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
     *
     * Example 1:
     * Input: target = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
     * Example 2:
     * Input: target = 4, nums = [1,4,4]
     * Output: 1
     * Example 3:
     * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
     * Output: 0
     *
     * Constraints:
     * 	• 1 <= target <= 109
     * 	• 1 <= nums.length <= 105
     * 	• 1 <= nums[i] <= 104
     *
     * Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
     */
    //Time complexity: O(n)
    public int minSubArrayLen(int target, int[] nums) {
        int result = nums.length + 1;
        int i = 0;
        int sum = 0;
        for(int j=0; j < nums.length; j++){
            sum += nums[j];
            while(sum >= target){
                int subL = j-i+1;
                result = Math.min(result,subL);
                sum = sum - nums[i];
                i++;
            }
        }
        //Better way to code : return result == nums.length + 1 ? 0 : result;
        if(result == nums.length + 1){
            return 0;
        }
        else{
            return result;
        }
    }


    //Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
    public int[][] generateMatrix(int n) {
        int res[][] = new int[n][n];
        int startx = 0;
        int starty = 0;
        int loop = n/2;
        int mid = n/2;
        int count = 1;
        int offset = 1;
        int i,j;
        while (loop-- > 0){
            i = startx;
            j = starty;
            //Start to fill the upper row
            for(; j < n-offset; j++){
                res[i][j] = count++;
            }

            //Start to fill in the rightest column
            for(;i < n-offset; i++){
                res[i][j] = count++;
            }

            //Start to fill in the lowest row
            for(;j > starty; j--){
                res[i][j] = count++;
            }

            //Start to fill in the left column
            for(;i > startx; i--){
                res[i][j] = count++;
            }

            startx++;
            starty++;
            offset++;
        }

        if(n % 2 == 1){
            res[mid][mid] = count;
        }
        return res;

    }

    /**
     * 35. Search Insert Position
     *
     * Given a sorted array of distinct integers and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * You must write an algorithm with O(log n) runtime complexity.
     *
     * Example 1:
     * Input: nums = [1,3,5,6], target = 5
     * Output: 2
     * Example 2:
     * Input: nums = [1,3,5,6], target = 2
     * Output: 1
     * Example 3:
     * Input: nums = [1,3,5,6], target = 7
     * Output: 4
     */

    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right = nums.length - 1;
        int middle;
        while(left <= right){
            middle = (right + left) / 2;

            if(nums[middle] < target){

                left = middle + 1;
            }
            else if(nums[middle] > target){
                right = middle - 1;
            }
            else return middle;
        }
        return left;
    }

    /**
     * 34. Find First and Last Position of Element in Sorted Array
     * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
     * If target is not found in the array, return [-1, -1].
     * You must write an algorithm with O(log n) runtime complexity.
     *
     * Example 1:
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * Example 2:
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     * Example 3:
     * Input: nums = [], target = 0
     * Output: [-1,-1]
     *
     * Constraints:
     * 	• 0 <= nums.length <= 105
     * 	• -109 <= nums[i] <= 109
     * 	• nums is a non-decreasing array.
     * 	• -109 <= target <= 109
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        result[0] = findBound(nums, target, true);

        if (result[0] == -1) {
            return result;
        }

        result[1] = findBound(nums, target, false);
        return result;
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1, bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                bound = mid;
                if (isFirst) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
        }
        return bound;
    }

    /**
     * 69. Sqrt(x)
     * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
     * The returned integer should be non-negative as well.
     * You must not use any built-in exponent function or operator.
     * 	• For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
     *
     * Example 1:
     * Input: x = 4
     * Output: 2
     * Explanation: The square root of 4 is 2, so we return 2.
     * Example 2:
     * Input: x = 8
     * Output: 2
     * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
     */

    public int mySqrt(int x) {
        if (x == 0 || x == 1){
            return x;
        }

        long left = 1;
        long right = x/2;

        while(left <= right){
            long middle = left + (right-left)/2;
            long squared = middle * middle;

            if (squared < x){
                left = middle + 1;
            }
            else if(squared > x){
                right = middle - 1;
            }
            else return (int)middle;
        }
        return (int)right;
    }
}
