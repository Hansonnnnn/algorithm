package algorithm.exam.three;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LargestNumDividedBy17 {
    public static void main(String[] args) {
        LargestNumDividedBy17 largestNumDividedBy17 = new LargestNumDividedBy17();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        while(scanner.hasNext()) {
            String num = scanner.nextLine();
            largestNumDividedBy17.getLargestNum(num);
        }
    }

    private void getLargestNum(String num) {
        //生成所有子序列
        Set<String> fullSort = new HashSet<>();
        getFullSort(fullSort, num.toCharArray(), 0, num.length()-1);
        Set<Integer> resultSet = new HashSet<>();
        for(String str : fullSort) {
            resultSet.add(Integer.valueOf(str));
        }
        int result = 0;
        for(Integer i : resultSet) {
            if(i % 17 == 0 && i > result) {
                result = i;
            }
        }
        if(result == 0) {
            System.out.println("Not Possible");
        }else{
            System.out.println(result);
        }
    }

    private void getFullSort(Set<String> result, char[] arr, int start, int end) {
        if(start == end) {
            result.add(new String(arr));
        }
        for(int i = start;i <= end;i++) {
            swap(arr, i, start);
            getFullSort(result, arr, start+1, end);
            swap(arr, i, start);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
