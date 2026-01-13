package coplit.dailyCoding.syntax;

import java.util.ArrayList;
import java.util.Arrays;

public class ListTest {
    public static void main(String[] args) {


        String[] strArr = new String[]{"A","B","C","D","E","F"};
        System.out.println(Arrays.toString(strArr));

        ArrayList<String> list = new ArrayList<>(Arrays.asList(strArr));
        System.out.println(list);

        strArr = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(strArr));
    }
}
