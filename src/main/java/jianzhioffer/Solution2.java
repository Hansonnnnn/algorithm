package jianzhioffer;

/**
 * ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 */
public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        char[] source = str.toString().toCharArray();
        int blank = 0;
        for (char c : source) {
            if (c == ' ') blank++;
        }
        char[] result = new char[source.length + blank*2];
        int sPointer = source.length-1, rPointer = result.length-1;
        for (;sPointer >= 0;sPointer--) {
            if (source[sPointer] == ' ') {
                result[rPointer--] = '0';
                result[rPointer--] = '2';
                result[rPointer--] = '%';
            } else {
                result[rPointer--] = source[sPointer];
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("hello world");
        System.out.println(new Solution2().replaceSpace(buffer));
    }
}
