package coplit.dailyCoding.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Sort {
    public static void main(String[] args) {

        int[] arr = new int[]{1,7,4,3,5,8,2};

        basicSort(arr.clone());
        reverseSort(arr.clone());
        listSort(arr.clone());
    }

    public static void basicSort(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void reverseSort(int[] arr) {

        Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedArr, Collections.reverseOrder());
        System.out.println(Arrays.toString(boxedArr));
    }

    public static void listSort(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        Collections.sort(list);
        System.out.println(list);

        list.sort(Collections.reverseOrder());
        System.out.println(list);
    }

}
