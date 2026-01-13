package coplit.dailyCoding.syntax;

public class CharTest {
    public static void main(String[] args) {
        System.out.println("=== Char Demo ===");

        char c = 'A';
        char n1 = 'a';
        char n2 = 'c';

        // char -> String
        String cStr = Character.toString(c);
        System.out.println("Character.toString('A') = " + cStr);

        // 비교 (같으면 0, 다르면 n1-n2)
        int cmp = Character.compare(n1, n2);
        System.out.println("Character.compare('a','c') = " + cmp); // -2

        // 대소문자 판단
        System.out.println("isUpperCase('A') = " + Character.isUpperCase(c)); // true
        System.out.println("isLowerCase('A') = " + Character.isLowerCase(c)); // false

        // 숫자인지 판단
        System.out.println("isDigit('5') = " + Character.isDigit('5')); // true
        System.out.println("isDigit('A') = " + Character.isDigit('A')); // false

        // 알파벳인지 판단
        System.out.println("isAlphabetic('A') = " + Character.isAlphabetic('A')); // true
        System.out.println("isAlphabetic('1') = " + Character.isAlphabetic('1')); // false

        // 문자를 숫자로 변환 (a=0, b=1,...)
        char a = 'a';
        char b = 'b';
        int aValue = a - 'a';
        int bValue = b - 'a';
        System.out.println("'a' -> " + aValue + ", 'b' -> " + bValue);
        System.out.println("'a' -> " + (int) a);

        // 숫자를 문자로 변환 (0→'a', 1→'b', 2→'c'...)
        int cValue = 2;
        char cChar = (char) ('a' + cValue);
        System.out.println("2 -> '" + cChar + "'");

        System.out.println("=== End ===");



    }
}
