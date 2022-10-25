package coplit.dailyCoding.Programmers.기타.Lv1;

public class 문자열다루기기본 {
    public boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6) {
            try {
                Integer.parseInt(s);
                return true;
            } catch(NumberFormatException e) {
                return false;
            }
        }

        return false;
    }
}
