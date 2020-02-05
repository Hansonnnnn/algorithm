package algorithm.exam.three;

import java.util.Scanner;

public class MaxConDescendingString {
    public static void main(String[] args) {
        MaxConDescendingString maxConDescendingString = new MaxConDescendingString();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        while(scanner.hasNext()){
            String element = scanner.nextLine();
            maxConDescendingString.printWantedStr(element);
        }
    }

    private void printWantedStr(String string) {
        boolean[] array = new boolean[26];
        char[] s = string.toCharArray();
        for(int i = 0; i<s.length; i++)
            array[s[i]-'A'] = true;
        String res = "";
        for(int i = 1; i<26; i++) {
            for(int j = 25; j>=0; j--) {
                if(array[j]) {
                    String temp = "";
                    temp+=(char)('A'+j);
                    for(int k = j-i; k>=0; k-=i) {
                        if(array[k])
                            temp+=(char)('A'+k);
                        else
                            break;
                    }
                    if(temp.length()>res.length())
                        res = temp;
                }
            }
        }
        System.out.println(res);
    }
}
