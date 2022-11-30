package coplit.dailyCoding.Programmers.기타.Lv1;

public class 핸드폰번호가리기 {
    public String solution(String phone_number) {
        int len = phone_number.length();
        return "*".repeat((len - 4)) + phone_number.substring(len-4);
    }
}
