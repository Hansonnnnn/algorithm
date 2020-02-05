package jianzhioffer;

/**
 * 二维有序数组 - 行有序、列有序
 * 搜索一个数
 * 思路：从右上角放左下角找
 * 每次将范围缩小一行或者一列
 */
public class Solution1 {
    public boolean Find(int target, int [][] array) {
        int i = 0;
        int j = array[0].length-1;
        while (i < array.length && j >= 0) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().Find(7, new int[][] {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}}));
    }
}
