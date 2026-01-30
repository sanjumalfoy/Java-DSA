public class findValueInRotatedArray {
    public static void main(String arg[]) {
        int[] nums = { 5, 1, 3 };
        int target = 5;
        int peak = findPeak(nums);
        if (nums.length == 1) {
            System.out.println(nums[0] == target ? 0 : -1);
        } else if (findAns(nums, target, 0, peak) != -1) {
            System.out.println(findAns(nums, target, 0, peak));
        } else {
            System.out.println(findAns(nums, target, peak + 1, nums.length - 1));

        }

    }

    static int findPeak(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else if (nums[start] > nums[mid]) {
                end=mid-1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    static int findAns(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
