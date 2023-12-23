public class Day3 {
    /**
     * 367. Valid Perfect Square
     * Given a positive integer num, return true if num is a perfect square or false otherwise.
     * A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.
     * You must not use any built-in library function, such as sqrt.
     * <p>
     * Example 1:
     * Input: num = 16
     * Output: true
     * Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
     * Example 2:
     * Input: num = 14
     * Output: false
     * Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.
     */
    public boolean isPerfectSquare(int num) {

        if (num < 0) {
            return false;
        }

        if (num == 0) {
            return false;
        }

        long left = 1;
        long right = num;
        long middle;

        while (left <= right) {
            middle = left + (right - left) / 2;
            long squared = middle * middle;

            if (squared < num) {
                left = middle + 1;
            } else if (squared > num) {
                right = middle - 1;
            } else {
                return true;
            }
        }
        return false;
    }


    /**
     * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
     * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
     * • Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
     * • Return k.
     * Example 1:
     * Input: nums = [1,1,2]
     * Output: 2, nums = [1,2,_]
     * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     * Example 2:
     * Input: nums = [0,0,1,1,1,2,2,3,3,4]
     * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
     * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     */

    public int removeDuplicates_v1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0; //Two pointers, one fast and one slow.
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) { //When they are not equal, it means that there's one unique element
                slow++;
                nums[slow] = nums[fast]; //update the index slow to go through the array
            }
        }
        return slow + 1;
    }

    /**
     * 80. Remove Duplicates from Sorted Array II
     * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
     * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
     * Return k after placing the final result in the first k slots of nums.
     * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
     * Example 1:
     * Input: nums = [1,1,1,2,2,3]
     * Output: 5, nums = [1,1,2,2,3,_]
     * Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     * Example 2:
     * Input: nums = [0,0,1,1,1,1,2,3,3]
     * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
     * Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     */

    public int removeDuplicates_v2(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int slow = 1;
        for (int fast = 2; fast < nums.length; fast++) {
            /**
             * This condition checks whether the current element nums[fast] is different from the element that is one position before where slow is pointing.
             * Since slow is always at the position for the next unique or second occurrence, slow - 1 is the position of the first or second occurrence of the previous unique element.
             * If nums[fast] is different from nums[slow - 1], it means one of two things:
             * a) nums[fast] is a new unique element not seen before.
             * b) nums[fast] is the second occurrence of the current element (because if it were the third or more occurrence, it would be equal to nums[slow - 1]
             */
            if (nums[fast] != nums[slow - 1]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    /**
     * 283. Move Zeroes
     * Easy
     * 15.8K
     * 410
     * Companies
     * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * Note that you must do this in-place without making a copy of the array.
     *
     * Example 1:
     * Input: nums = [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * Example 2:
     * Input: nums = [0]
     * Output: [0]
     * @param nums
     */

    public void moveZeroes(int[] nums) {
        int count = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[count] = nums[i];
                count++;
            }
        }

        for(int i = count; i < nums.length; i++){
            nums[i] = 0;
        }
    }
    
}
