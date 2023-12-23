import java.util.Arrays;

public class Day1 {
    /**
     * 704 Binary Search
     * <p>
     * Given an array of integers nums which is sorted in ascending order, and an integer target,
     * write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
     * You must write an algorithm with O(log n) runtime complexity.
     * <p>
     * Example 1
     * Input: nums = [-1,0,3,5,9,12], target = 9
     * Output: 4
     * Explanation: 9 exists in nums and its index is 4
     * <p>
     * Example 2
     * Input: nums = [-1,0,3,5,9,12], target = 2
     * Output: -1
     * Explanation: 2 does not exist in nums so return -1
     */
    // The range is [left, right]
    // Time complexity is O(log(n)), space complexity is O(1)
    public static int search_v1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (left <= right) {
            middle = Math.round((left + right) / 2);
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else return middle;
        }
        return -1;
    }

    //The range is [left, right)
    public static int search_v2(int[] nums, int target) {
        int left = 0;
        int right = nums.length; //No need to minus one
        int middle;
        while (left < right) { // left side cannot be equal to right side at this time
            middle = Math.round((left + right) / 2);
            if (nums[middle] > target) {
                right = middle; // Because the middle value is the same as the right side. right)
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else return middle;
        }
        return -1;
    }


    /**
     * 27
     * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
     * The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
     * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
     * 	• Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
     * 	The remaining elements of nums are not important as well as the size of nums.
     * 	• Return k.
     * Custom Judge:
     * The judge will test your solution with the following code:
     * int[] nums = [...]; // Input array
     * int val = ...; // Value to remove
     * int[] expectedNums = [...]; // The expected answer with correct length.
     *                             // It is sorted with no values equaling val.
     * int k = removeElement(nums, val); // Calls your implementation
     * assert k == expectedNums.length;
     * sort(nums, 0, k); // Sort the first k elements of nums
     * for (int i = 0; i < actualLength; i++) {
     *     assert nums[i] == expectedNums[i];
     * }
     * If all assertions pass, then your solution will be accepted.
     *
     * Example 1:
     * Input: nums = [3,2,2,3], val = 3
     * Output: 2, nums = [2,2,_,_]
     * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     *
     * Example 2:
     * Input: nums = [0,1,2,2,3,0,4,2], val = 2
     * Output: 5, nums = [0,1,4,0,3,_,_,_]
     * Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
     * Note that the five elements can be returned in any order.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     */
    public static int removeElement(int[] nums, int val){
        int slow = 0;
        for(int fast = 0; fast < nums.length ; fast++){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    /**
     * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
     *
     * Example 1:
     * Input: nums = [-4,-1,0,3,10]
     * Output: [0,1,9,16,100]
     * Explanation: After squaring, the array becomes [16,1,0,9,100].
     * After sorting, it becomes [0,1,9,16,100].
     *
     * Example 2:
     * Input: nums = [-7,-3,2,3,11]
     * Output: [4,9,9,49,121]
     *
     * Constraints:
     * 	• 1 <= nums.length <= 104
     * 	• -104 <= nums[i] <= 104
     * 	• nums is sorted in non-decreasing order.
     */

    //Simple solution
    public static int[] sortedSquares_v1(int[] nums) {
        for(int i = 0; i< nums.length; i++){
            int temp = nums[i];
            nums[i] = temp * temp;
            System.out.println(nums[i]);
        }
        Arrays.sort(nums);
        return nums;
    }

    public int[] sortedSquares_v2(int[] nums) {
        int n = nums.length-1;
        int[] squares = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for(int i = n; i >=0 ; i--){ // IMPORTANT: Loop from backwards in order not to miss any element.
            if(nums[left] * nums[left] < nums[right] * nums[right]){
                squares[i] = nums[right] * nums[right];
                right --;
            }
            else{
                squares[i] = nums[left] * nums[left];
                left++;
            }
        }
        return squares;
    }
}
