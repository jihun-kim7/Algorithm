package coplit.dailyCoding.syntax;

public class StringBuilderTest {
    public static void main(String[] args) {
        System.out.println("=== StringBuilder Demo ===");

        StringBuilder sb = new StringBuilder();

        // 문자열 추가
        sb.append("Hello World");
        System.out.println("append: " + sb); // Hello World

        // 특정 인덱스에 문자 삽입
        sb.insert(2, "kk");
        System.out.println("insert(2,\"kk\"): " + sb); // Hekkllo World

        // 문자열 삭제
        sb.delete(0, 2);
        System.out.println("delete(0,2): " + sb); // kkllo World

        // 특정 인덱스의 문자 삭제
        sb.deleteCharAt(3);
        System.out.println("deleteCharAt(3): " + sb); // kklo World

        // 특정 인덱스의 문자를 치환
        sb.setCharAt(1, 'c');
        System.out.println("setCharAt(1,'c'): " + sb); // kclo World

        // 문자열 뒤집기
        sb.reverse();
        System.out.println("reverse: " + sb); // dlroW olck

        // 문자열 길이 줄이기
        sb.setLength(3);
        System.out.println("setLength(3): " + sb); // dlr

        // 문자열 길이 늘리기 (빈 공간은 '\u0000' → 출력 시 공백처럼 보임)
        sb.setLength(4);
        System.out.println("setLength(4): [" + sb + "]"); // dlr + 공백(널문자)

        // String으로 변환
        String result = sb.toString();
        System.out.println("toString: \"" + result + "\"");

        System.out.println("=== End ===");
    }
}
