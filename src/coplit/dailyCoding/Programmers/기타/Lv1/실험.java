package coplit.dailyCoding.Programmers.기타.Lv1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class 실험 {
    public static void main(String[] args) {
//        String s = "....aa1234..2.";
//        String s1 = s.replaceAll("[\\d]+", "zz");
//        System.out.println(s1);

        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();


        ArrayList<String> a = hashMap.getOrDefault("a", new ArrayList<>(10));
        a.add("hihi");

        System.out.println(a.hashCode());

        a.add("byby");

        System.out.println(a.hashCode());
        a.add("byby");
        System.out.println(a.hashCode());
        a.add("byby");
        System.out.println(a.hashCode());
        a.add("byby");
        System.out.println(a.hashCode());
        a.add("byby");
        a.add("byby");
        System.out.println(a.hashCode());
        System.out.println(a);


        ArrayList<String> list = new ArrayList<>();
//        list.add("Abcda");
//        for (String s : list) {
//            String[] split = s.split("");
//        }
//
//
//        for (String s : list) {
//            String[] split = s.split("");
//        }
        int size = list.size();
        System.out.println(size);


    }
}
