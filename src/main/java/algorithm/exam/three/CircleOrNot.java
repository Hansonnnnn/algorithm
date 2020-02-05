package algorithm.exam.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ÄÜ·ñ³É»·
 * Description
 * Given an array of strings A[ ], determine if the strings can be chained together to form a circle. A string X can be chained together with another string Y if the last character of X is same as first character of Y. If every string of the array can be chained, it will form a circle. For example, for the array arr[] = {"for", "geek", "rig", "kaf"} the answer will be Yes as the given strings can be chained as
 * "for", "rig", "geek" and "kaf".
 * for rig kaf geek
 *
 * Input
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
 *
 * The first line of each test case contains a positive integer N, denoting the size of the array.
 *
 * The second line of each test case contains a N space seprated strings, denoting the elements of the array A[ ].
 *
 * 1 <= T
 *
 * 0 < N
 *
 * 0 < A[i]
 *
 * Output
 * If chain can be formed, then print 1, else print 0.
 */
public class CircleOrNot {
    public static void main(String[] args) {
        CircleOrNot circleOrNot = new CircleOrNot();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        while(scanner.hasNext()) {
            scanner.nextLine();
            String[] array = scanner.nextLine().split(" ");
            System.out.println(circleOrNot.findCircle(array));
        }
    }
    private int findCircle(String[] strings) {
        if(strings.length == 1) return 1;
        List<Integer> usedIndexes = new ArrayList<>();
        boolean findNext = false;
        for(int i = 0;i < strings.length;i++) {
            usedIndexes.add(i);
            findNext = findNext(strings, usedIndexes, strings[usedIndexes.get(usedIndexes.size()-1)]);
            while (findNext && usedIndexes.size() < strings.length) {
                findNext = findNext(strings, usedIndexes, strings[usedIndexes.get(usedIndexes.size()-1)]);
            }
            if(findNext) {
                String lastStr = strings[usedIndexes.get(usedIndexes.size()-1)];
                findNext = lastStr.charAt(lastStr.length()-1) == strings[i].charAt(0);
                return findNext ? 1 : 0;
            }
            usedIndexes.clear();
        }
        return 0;
    }

    private boolean findNext(String[] strings, List<Integer> usedIndexes, String target) {
        for(int i = 0;i < strings.length;i++) {
            if(!usedIndexes.contains(i)) {
                if(strings[i].charAt(0) == target.charAt(target.length()-1)) {
                    usedIndexes.add(i);
                    return true;
                }
            }
        }
        return false;
    }
}
