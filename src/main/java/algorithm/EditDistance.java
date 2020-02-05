package algorithm;

/**
 * Edit Distance
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 *      a) Insert a character
 *      b) Delete a character
 *      c) Replace a character
 */
public class EditDistance {
    public static void main(String[] args) {
        System.out.println(editDistance("abc", "acc"));
    }
    private static int editDistance(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();

        int[][] dp = new int[length1+1][length2+1];
        for (int i = 0;i < length1+1;i++) {//
            dp[i][0] = i;
        }
        for (int j = 0;j < length2+1;j++) {//
            dp[0][j] = j;
        }

        for (int i = 0;i < length1;i++) {
            char a = str1.charAt(i);
            for (int j = 0;j < length2;j++) {
                char b = str2.charAt(j);
                if (a==b){
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    int insert = dp[i+1][j] + 1; //对str1加一个字符
                    int delete = dp[i][j+1] + 1; //
                    int replace = dp[i+1][j+1] + 1;
                    int min = insert < delete ? insert : delete;
                    min = replace < min ? replace : min;
                    dp[i+1][j+1] = min;
                }
            }
        }

        for (int i = 0;i < length1 + 1;i++ ) {
            System.out.print("[");
            for (int j = 0;j < length2 + 1;j++) {
                System.out.print(dp[i][j] + ",");
            }
            System.out.println("]");
        }

        return dp[length1][length2];
    }
}
