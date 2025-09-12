

import java.io.*;
import java.util.*;

public class Practice {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        sb.append("abc"); // 문자열 추가
        sb.insert(2, "dd"); // 인덱스 2 위치에 dd 추가

//        sb.delete(0, 2); // 0~1 사이 인덱스에 위치한 문자열 삭제
//        sb.deleteCharAt(2); // 인덱스 2에 위치한 문자열 삭제

        sb.setCharAt(0, 'f'); // 인덱스 0에 위치한 문자를 f로 변경

        System.out.println("sb = " + sb);

        sb.reverse(); // 문자열 뒤집기

        System.out.println("sb = " + sb);

        sb.setLength(2); // 문자열 길이를 2로 줄인다 -> "ab"로 바뀜
        sb.setLength(4); // 문자열 길이를 4로 늘린다 -> 뒤가 공백으로 채워짐
    }

}
