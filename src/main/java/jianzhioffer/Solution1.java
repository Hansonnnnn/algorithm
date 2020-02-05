package jianzhioffer;

/**
 * ��ά�������� - ������������
 * ����һ����
 * ˼·�������ϽǷ����½���
 * ÿ�ν���Χ��Сһ�л���һ��
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
