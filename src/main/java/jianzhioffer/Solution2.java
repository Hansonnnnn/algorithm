package jianzhioffer;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
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
