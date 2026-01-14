package coplit.dailyCoding.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Sort {
    // =========================
    // 0) 실행 엔트리
    // =========================
    public static void main(String[] args) {
        demoIntArraySort();
        demoInt2DSort();
        demoStringSort();
        demoString2DSort();
        demoClassSort();
    }

    // =========================
    // 1) int[] 정렬 (기본/내림차순/커스텀)
    // =========================
    private static void demoIntArraySort() {
        System.out.println("===== int[] SORT =====");
        int[] arr = {5, 1, 4, 2, 3};

        int[] a1 = arr.clone();
        sortIntAsc(a1);
        System.out.println("asc      : " + Arrays.toString(a1));

        int[] a2 = arr.clone();
        sortIntDesc(a2);
        System.out.println("desc     : " + Arrays.toString(a2));

        // 예: 절대값 기준 오름차순, 같으면 실제 값 오름차순
        int[] a3 = { -3, 2, -2, 1, 3, 0 };
        sortIntByAbsAscThenValueAsc(a3);
        System.out.println("abs->val : " + Arrays.toString(a3));
        System.out.println();
    }

    // int[] 오름차순
    static void sortIntAsc(int[] arr) {
        Arrays.sort(arr);
    }

    // int[] 내림차순: int[]는 Comparator를 직접 못 넣으므로 boxing해서 처리(코테에서도 자주 씀)
    static void sortIntDesc(int[] arr) {
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, (a, b) -> Integer.compare(b, a));
        for (int i = 0; i < arr.length; i++) arr[i] = boxed[i];
    }

    // int[] 절대값 오름차순 -> 값 오름차순
    static void sortIntByAbsAscThenValueAsc(int[] arr) {
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, (a, b) -> {
            int c = Integer.compare(Math.abs(a), Math.abs(b));
            if (c != 0) return c;
            return Integer.compare(a, b);
        });
        for (int i = 0; i < arr.length; i++) arr[i] = boxed[i];
    }

    // =========================
    // 2) int[][] 정렬 (2차원 배열: 좌표/다중키)
    // =========================
    private static void demoInt2DSort() {
        System.out.println("===== int[][] SORT =====");
        int[][] points = {
                {3, 4},
                {1, 7},
                {1, 3},
                {2, 2},
                {3, 1}
        };

        int[][] p1 = deepCopy(points);
        sortInt2DByColAsc(p1, 0); // 0열(x) 오름차순
        System.out.println("col0 asc:");
        print2D(p1);

        int[][] p2 = deepCopy(points);
        sortInt2DByColDesc(p2, 1); // 1열(y) 내림차순
        System.out.println("col1 desc:");
        print2D(p2);

        int[][] p3 = deepCopy(points);
        sortInt2DByTwoKeys(p3, 0, true, 1, true); // col0 asc, col1 asc
        System.out.println("col0 asc, col1 asc:");
        print2D(p3);

        int[][] p4 = deepCopy(points);
        sortInt2DByTwoKeys(p4, 0, true, 1, false); // col0 asc, col1 desc
        System.out.println("col0 asc, col1 desc:");
        print2D(p4);

        System.out.println();
    }

    // int[][] 특정 컬럼 오름차순
    static void sortInt2DByColAsc(int[][] arr, int col) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[col], b[col]));
    }

    // int[][] 특정 컬럼 내림차순
    static void sortInt2DByColDesc(int[][] arr, int col) {
        Arrays.sort(arr, (a, b) -> Integer.compare(b[col], a[col]));
    }

    // int[][] 두 키 정렬: (key1 asc/desc) -> (key2 asc/desc)
    static void sortInt2DByTwoKeys(int[][] arr, int col1, boolean asc1, int col2, boolean asc2) {
        Arrays.sort(arr, (a, b) -> {
            int c = asc1 ? Integer.compare(a[col1], b[col1]) : Integer.compare(b[col1], a[col1]);
            if (c != 0) return c;
            return asc2 ? Integer.compare(a[col2], b[col2]) : Integer.compare(b[col2], a[col2]);
        });
    }

    // =========================
    // 3) String[] 정렬 (사전순/IgnoreCase/길이/숫자 문자열)
    // =========================
    private static void demoStringSort() {
        System.out.println("===== String[] SORT =====");
        String[] words = {"banana", "Apple", "apple", "car", "Car", "bar"};

        String[] w1 = words.clone();
        sortStringLexAsc(w1);
        System.out.println("lex asc         : " + Arrays.toString(w1));

        String[] w2 = words.clone();
        sortStringLexDesc(w2);
        System.out.println("lex desc        : " + Arrays.toString(w2));

        String[] w3 = words.clone();
        sortStringIgnoreCaseThenLex(w3);
        System.out.println("ignoreCase->lex : " + Arrays.toString(w3));

        String[] w4 = words.clone();
        sortStringLenAscThenLex(w4);
        System.out.println("len->lex        : " + Arrays.toString(w4));

        // 숫자 문자열 정렬
        String[] nums = {"2", "10", "1", "20", "3"};
        String[] n1 = nums.clone();
        sortNumericStringAsc(n1);
        System.out.println("numeric asc     : " + Arrays.toString(n1));

        System.out.println();
    }

    // String[] 사전순 오름차순(기본)
    static void sortStringLexAsc(String[] arr) {
        Arrays.sort(arr);
    }

    // String[] 사전순 내림차순
    static void sortStringLexDesc(String[] arr) {
        Arrays.sort(arr, (a, b) -> b.compareTo(a));
    }

    // String[] 대소문자 무시 -> 동률이면 원본 사전순(안정적인 tie-break)
    static void sortStringIgnoreCaseThenLex(String[] arr) {
        Arrays.sort(arr, (a, b) -> {
            int c = a.compareToIgnoreCase(b);
            if (c != 0) return c;
            return a.compareTo(b);
        });
    }

    // String[] 길이 오름차순 -> 사전순 오름차순
    static void sortStringLenAscThenLex(String[] arr) {
        Arrays.sort(arr, (a, b) -> {
            int c = Integer.compare(a.length(), b.length());
            if (c != 0) return c;
            return a.compareTo(b);
        });
    }

    // 숫자 문자열을 "숫자 기준" 오름차순 정렬
    static void sortNumericStringAsc(String[] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(Integer.parseInt(a), Integer.parseInt(b)));
    }

    // =========================
    // 4) String[][] 정렬 (다중키 + 숫자필드 파싱)
    // =========================
    private static void demoString2DSort() {
        System.out.println("===== String[][] SORT =====");
        // [name, score(문자열), dept]
        String[][] people = {
                {"kim", "90",  "dev"},
                {"lee", "90",  "qa"},
                {"park","100", "dev"},
                {"choi","70",  "dev"},
                {"lee", "80",  "dev"}
        };

        System.out.println("original:");
        print2D(people);

        // 점수 desc -> 이름 asc -> 부서 asc
        sortString2DByScoreDescNameAscDeptAsc(people);

        System.out.println("sorted (score desc -> name asc -> dept asc):");
        print2D(people);
        System.out.println();
    }

    static void sortString2DByScoreDescNameAscDeptAsc(String[][] arr) {
        Arrays.sort(arr, (a, b) -> {
            int scoreA = Integer.parseInt(a[1]);
            int scoreB = Integer.parseInt(b[1]);

            int c = Integer.compare(scoreB, scoreA); // score desc
            if (c != 0) return c;

            c = a[0].compareTo(b[0]); // name asc
            if (c != 0) return c;

            return a[2].compareTo(b[2]); // dept asc
        });
    }

    // =========================
    // 5) 클래스 정렬 (배열/리스트 모두)
    // =========================
    private static void demoClassSort() {
        System.out.println("===== CLASS SORT =====");

        Person[] arr = {
                new Person("kim",  90, 3),
                new Person("lee",  90, 2),
                new Person("park", 100,1),
                new Person("choi", 70, 5),
                new Person("lee",  80, 4),
        };

        System.out.println("original:");
        System.out.println(Arrays.toString(arr));

        // score desc -> name asc -> id asc
        sortPersonArray(arr);

        System.out.println("sorted array:");
        System.out.println(Arrays.toString(arr));

        // 리스트도 동일하게
        List<Person> list = new ArrayList<>(Arrays.asList(
                new Person("kim",  90, 3),
                new Person("lee",  90, 2),
                new Person("park", 100,1),
                new Person("choi", 70, 5),
                new Person("lee",  80, 4)
        ));

        sortPersonList(list);
        System.out.println("sorted list:");
        System.out.println(list);

        System.out.println();
    }

    static void sortPersonArray(Person[] arr) {
        Arrays.sort(arr, (a, b) -> {
            int c = Integer.compare(b.score, a.score); // score desc
            if (c != 0) return c;

            c = a.name.compareTo(b.name); // name asc
            if (c != 0) return c;

            return Integer.compare(a.id, b.id); // id asc
        });
    }

    static void sortPersonList(List<Person> list) {
        list.sort((a, b) -> {
            int c = Integer.compare(b.score, a.score);
            if (c != 0) return c;

            c = a.name.compareTo(b.name);
            if (c != 0) return c;

            return Integer.compare(a.id, b.id);
        });
    }

    // =========================
    // Utils
    // =========================
    static int[][] deepCopy(int[][] arr) {
        int[][] copy = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) copy[i] = arr[i].clone();
        return copy;
    }

    static void print2D(int[][] arr) {
        for (int[] row : arr) System.out.println(Arrays.toString(row));
    }

    static void print2D(String[][] arr) {
        for (String[] row : arr) System.out.println(Arrays.toString(row));
    }

    static class Person {
        String name;
        int score;
        int id;

        Person(String name, int score, int id) {
            this.name = name;
            this.score = score;
            this.id = id;
        }

        @Override
        public String toString() {
            return "{name=" + name + ", score=" + score + ", id=" + id + "}";
        }
    }
}
