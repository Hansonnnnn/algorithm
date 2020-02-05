package algorithm.exam;

import java.util.*;

public class MinimumTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNum = Integer.valueOf(scanner.nextLine());
        String[] inputs = new String[caseNum];
        int j = 0;
        while(caseNum > 0) {
            scanner.nextLine();
            inputs[j++] = scanner.nextLine();
            caseNum--;
        }
        for (int k = 0;k < inputs.length;k++) {
            String[] numArr = inputs[k].split(" ");
            int[] arr1 = new int[numArr.length];
            List<Integer> sortedList = new ArrayList<>();
            for (int arr1i = 0;arr1i < numArr.length;arr1i++) {
                arr1[arr1i] = Integer.valueOf(numArr[arr1i]);
                sortedList.add(arr1[arr1i]);
            }

            Collections.sort(sortedList);
            int time = 0;
            for (int i = 0;i < sortedList.size();i++) {
                int curNum = sortedList.get(i);
                int index = indexOf(arr1,curNum);
                int otherNum = sortedList.get(index);
                if (curNum != otherNum) {
                    arr1[i] = curNum;
                    arr1[index] = otherNum;
                    time++;
                }
            }
//            if (k != inputs.length - 1) {
//                System.out.println(time);
//            }else{
//                System.out.print(time);
//            }
            System.out.println(time);

            time = 0;
        }
    }

    private static int indexOf(int[] a,int b){
        int res = 0;
        for (int i=0;i<a.length;i++){
            if (a[i]==b){
                res = i;
            }
        }
        return res;
    }

}
