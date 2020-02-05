package jianzhioffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 在旋转数组中找到最小值
 *
 * 关键 r - 1 ，即循环停下来的条件
 */
public class Solution6 {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {return 0;}
        int l = 0, r = array.length-1;
        int mid = 0;
        while (l < (r - 1)) {
            mid = (l+r)/2;
            if (array[mid] > array[0]) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (array[mid] < array[r]) {
            return array[mid];
        }
        return array[r];
    }
}
