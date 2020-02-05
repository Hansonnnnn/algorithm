package algorithm.exam;

import java.util.*;

public class OrderByCharNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNum = Integer.valueOf(scanner.nextLine());
        String[] inputs = new String[caseNum];
        int index = 0;
        while(caseNum > 0) {
            scanner.nextLine();
            inputs[index++] = scanner.nextLine();
            caseNum--;
        }
        for (int j = 0;j < inputs.length;j++) {
            String[] arrayStr = inputs[j].split(" ");
            int[] array = new int[arrayStr.length];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0;i < array.length;i++) {
                array[i] = Integer.valueOf(arrayStr[i]);
                map.put(array[i], map.getOrDefault(array[i],0) + 1);
            }
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    if (o1.getValue().intValue() == o2.getValue().intValue()) return o1.getKey() - o2.getKey();
                    return o2.getValue() - o1.getValue();
                }
            });
            Iterator<Map.Entry<Integer, Integer>> iterator = list.listIterator();
            String result = "";
            while(iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                int num = entry.getValue();
                for (int i = 0;i < num;i++) {
                    result += entry.getKey() + " ";
                }
            }
            result = result.substring(0, result.length()-1);
            System.out.print(result);
            if (j != inputs.length-1) {
                System.out.println();
            }
        }
    }
}
