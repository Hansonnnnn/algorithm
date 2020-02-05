package dsAndA;

import java.util.Random;

public class Chapter2 {
    public static void main(String[] args) {
//        Random random = new Random();
//        int[] nums = new int[10000];
//        for (int i = 0;i < nums.length;i++) {
//            nums[i] = random.nextInt(10000) - 5000;
//            System.out.print(nums[i]+",");
//        }
//        int[] nums = new int[]{-1,-2,-3,-4};
//        maxSubArray1(nums);
//        maxSubArray2(nums);
//        maxSubArray3(nums);
//        maxSubArray4(nums);

//        int[] nums = new int[]{1,2,3,4,5};
//        System.out.println(binarySearch(nums, 3));

        System.out.println(pow(2,0));
    }

    /**
     * O(n^3)
     * 暴力破解
     * 每一个元素到后面每一个元素之间的所有元素的和
     * i，j确定两个下标，计算两者之间所有元素的和
     */
    private static void maxSubArray1(int[] nums) {
        long time1 = System.currentTimeMillis();
        int max = Integer.MIN_VALUE;
        int sum;
        for (int i = 0;i < nums.length;i++) {
            for (int j = i;j < nums.length;j++) {
                sum = 0;
                for (int k = i;k <= j;k++) {
                    sum += nums[k];
                }
                if (sum > max) max = sum;
            }
        }
        System.out.println(max);
        long time2 = System.currentTimeMillis();
        System.out.println((time2 - time1) + "ms");
    }

    /**
     * O(n^2)
     */
    private static void maxSubArray2(int[] nums) {
        long time1 = System.currentTimeMillis();
        int max = Integer.MIN_VALUE;
        int sum;
        for (int i = 0;i < nums.length;i++) {
            sum = 0;
            for (int j = i;j < nums.length;j++) {
                sum += nums[j];
                if (sum > max) max = sum;
            }
        }
        System.out.println(max);
        long time2 = System.currentTimeMillis();
        System.out.println((time2 - time1) + "ms");
    }

    /**
     * O(n)
     */
    private static void maxSubArray3(int[] nums) {
        long time1 = System.currentTimeMillis();
        if (nums.length <= 0) return;
        int currentSum = nums[0];
        int sum = nums[0];
        for (int i = 1;i < nums.length;i++) {
            if (currentSum < 0) currentSum = nums[i];
            else currentSum += nums[i];

            if(currentSum > sum) sum = currentSum;
        }
        System.out.println(sum);
        long time2 = System.currentTimeMillis();
        System.out.println((time2 - time1) + "ms");
    }

    /**
     * O(N*logN) 分治法 - 递归
     * @param nums
     */
    private static void maxSubArray4(int[] nums) {
        long time1 = System.currentTimeMillis();
        if (nums.length <= 0) return;
        System.out.println(maxSubArrayDivideAndConquer(nums, 0, nums.length-1));
        long time2 = System.currentTimeMillis();
        System.out.println((time2 - time1) + "ms");
    }

    private static int maxSubArrayDivideAndConquer(int[] nums, int left, int right) {
        if (left == right)return nums[left];
        int center = (right - left) / 2 + left;
        int leftMaxSum = maxSubArrayDivideAndConquer(nums, left, center);
        int rightMaxSum = maxSubArrayDivideAndConquer(nums, center+1, right);

        int leftBorderMaxSum = Integer.MIN_VALUE, leftBorderSum = Integer.MIN_VALUE;
        for (int i = center;i >= left;i--) {
            leftBorderSum += nums[i];
            if (leftBorderSum > leftBorderMaxSum) {
                leftBorderMaxSum = leftBorderSum;
            }
        }

        int rightBorderMaxSum = Integer.MIN_VALUE, rightBorderSum = Integer.MIN_VALUE;
        for (int j = center + 1;j <= right;j++) {
            rightBorderSum += nums[j];
            if (rightBorderSum > rightBorderMaxSum) {
                rightBorderMaxSum = rightBorderSum;
            }
        }

        int maxResult = leftMaxSum > (leftBorderMaxSum + rightBorderMaxSum) ? leftMaxSum : (leftBorderMaxSum + rightBorderMaxSum);
        maxResult = maxResult > rightMaxSum ? maxResult : rightMaxSum;
        return maxResult;
    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private static long pow(long x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        else if (n % 2 == 0) return pow(x * x, n / 2);
        else return pow(x * x, n / 2) * x;
    }
}
