package basic;

import java.util.Arrays;
import java.util.List;

public class CollectionTest {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        String[] strs = new String[]{"","","",""};
        List<String> list = Arrays.asList(strs);
//        list.add("a");
        System.out.println(list.toString());
    }
}
