package coplit.dailyCoding.syntax;

import java.util.Arrays;

public class StringTest {

    public static void main(String[] args) {
        final String original = "Hello World!";  // 예제 원문
        System.out.println("=== String API Quick Demo ===");
        System.out.println("original = \"" + original + "\"\n");

        // 1) 길이, 빈 문자열
        int len = original.length();
        boolean isEmpty = original.isEmpty();
        System.out.println("[length / isEmpty]");
        System.out.println("length = " + len);          // 12
        System.out.println("isEmpty = " + isEmpty);     // false
        System.out.println();

        // 2) 문자/인덱스 찾기
        char firstChar = original.charAt(0);
        int idxH = original.indexOf("H");
        int lastIdxL = original.lastIndexOf("l");
        System.out.println("[charAt / indexOf / lastIndexOf]");
        System.out.println("charAt(0) = " + firstChar);     // H
        System.out.println("indexOf(\"H\") = " + idxH);     // 0
        System.out.println("lastIndexOf(\"l\") = " + lastIdxL); // 9
        System.out.println();

        // 3) 부분 문자열
        int fromIndex = 0, toIndex = 5;
        String head = original.substring(fromIndex, toIndex); // [0,5) = "Hello"
        String tailFrom5 = original.substring(toIndex);       // " World!"
        System.out.println("[substring]");
        System.out.println("substring(0,5) = \"" + head + "\"");
        System.out.println("substring(5)   = \"" + tailFrom5 + "\"");
        System.out.println();

        // 4) 치환 (replace / replaceFirst)
        String replacedWorld = (original+"World!World").replace("World", "Java");
        String replaceFirstLowerL = original.replaceFirst("l", "L"); // 첫 'l'만
        System.out.println("[replace / replaceFirst]");
        System.out.println("replace(\"World\",\"Java\") = \"" + replacedWorld + "\"");
        System.out.println("replaceFirst(\"l\",\"L\")   = \"" + replaceFirstLowerL + "\"");
        System.out.println();


        String text = "Hello 123, this is 456 and also 789.";

        // 숫자 모두를 "#"으로 치환
        String onlyDigits = text.replaceAll("\\d+", "#");
        System.out.println("숫자 치환: " + onlyDigits);
        // 결과: Hello #, this is # and also #.

        // 공백 2개 이상을 하나의 공백으로 줄이기
        String multiSpaces = "Hello    Java   World!";
        String singleSpace = multiSpaces.replaceAll("\\s+", " ");
        System.out.println("공백 줄이기: " + singleSpace);
        // 결과: Hello Java World!

        // 단어 경계(\b) 기준으로 "is" → "was" 치환
        String sentence = "This is island. It is fine.";
        String replacedWord = sentence.replaceAll("\\bis\\b", "was");
        System.out.println("단어 'is' 치환: " + replacedWord);
        System.out.println();

        // 5) 비교/대소문자 무시 비교/사전순 비교
        boolean eqExact = original.equals("Hello World!");
        boolean eqIgnoreCase = original.equalsIgnoreCase("hello world!");
        int cmpLexi = original.compareTo("Hello world!"); // 대소문자/문자코드 영향
        System.out.println("[equals / equalsIgnoreCase / compareTo]");
        System.out.println("equals(\"Hello World!\")        = " + eqExact);
        System.out.println("equalsIgnoreCase(\"hello world!\") = " + eqIgnoreCase);
        System.out.println("compareTo(\"Hello world!\")     = " + cmpLexi);
        System.out.println();

        // 6) 포함 여부
        boolean hasHello = original.contains("Hello");
        System.out.println("[contains]");
        System.out.println("contains(\"Hello\") = " + hasHello);
        System.out.println();

        // 7) 분리 (split)
        String[] bySpace = original.split(" "); // 공백 기준
        System.out.println("[split]");
        System.out.println("split(\" \") -> " + Arrays.toString(bySpace)); // ["Hello","World!"]
        System.out.println();

        // 8) char[] 변환
        char[] chars = original.toCharArray();
        System.out.println("[toCharArray]");
        System.out.println("toCharArray -> " + Arrays.toString(chars));
        System.out.println();

        // 9) 숫자 <-> 문자열
        String strFromIntA = String.valueOf(3);   // "3" (null 안전: String.valueOf(null) -> "null")
        String strFromIntB = Integer.toString(3); // "3"
        int parsed = Integer.parseInt("3");       // 3
        System.out.println("[number <-> string]");
        System.out.println("String.valueOf(3)   = \"" + strFromIntA + "\"");
        System.out.println("Integer.toString(3) = \"" + strFromIntB + "\"");
        System.out.println("Integer.parseInt(\"3\") = " + parsed);
        // 참고: Integer.toString(null)은 사용할 수 없음(오버로드가 없고 NPE/컴파일 오류)
        System.out.println();

        // 10) 배열 연결 출력
        String[] tokens = {"a", "b", "c"};
        String joined = String.join(", ", tokens); // "a, b, c"
        System.out.println("[String.join]");
        System.out.println("join(\", \", {a,b,c}) = \"" + joined + "\"");
        System.out.println();

        // 11) 대소문자 변환
        String upper = original.toUpperCase();
        String lower = original.toLowerCase();
        System.out.println("[toUpperCase / toLowerCase]");
        System.out.println("toUpperCase = \"" + upper + "\"");
        System.out.println("toLowerCase = \"" + lower + "\"");
        System.out.println();

        // 12) 트림 & 공백 처리 (Java 8)
        String spaced = "   Hi  ";
        String trimmed = spaced.trim();
        boolean emptyAfterTrim = trimmed.isEmpty(); // "Hi" -> false
        System.out.println("[trim]");
        System.out.println("before: \"" + spaced + "\"");
        System.out.println("after : \"" + trimmed + "\" (isEmpty=" + emptyAfterTrim + ")");
        System.out.println();

        System.out.println("=== End ===");


        // reverse() 문자열 뒤집기
        StringBuilder reverse = new StringBuilder(original).reverse();
        System.out.println("StringBuilder reverse : " + reverse.toString());

        // 직접 reverse() 구현
        int mid = original.length()/2;
        int length = original.length();

        char[] charArray = original.toCharArray();

        for (int i=0; i<mid; i++) {
            char tmp = charArray[i];
            charArray[i] = charArray[length-1-i];
            charArray[length-1-i] = tmp;
        }

        String string = String.valueOf(charArray);
        System.out.println("reverse() 직접구현 : " + string);


    }
}
