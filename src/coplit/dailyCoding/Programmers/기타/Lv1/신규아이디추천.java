package coplit.dailyCoding.Programmers.기타.Lv1;

public class 신규아이디추천 {
    public String solution(String new_id) {
        //1
        new_id = new_id.toLowerCase();
        //2
        new_id = new_id.replaceAll("[^a-z\\d-_.]","");
        //3
        new_id = new_id.replaceAll("\\.{2,}",".");
        //4
        new_id = new_id.replaceAll("^[.]|[.]$","");
        //5
        if (new_id.isEmpty()) new_id = "a";
        //6
        if (new_id.length() > 15)
            new_id = new_id.substring(0,15);
        new_id = new_id.replaceAll("[.]$","");
        //7
        while(new_id.length() < 3)
            new_id += new_id.charAt(new_id.length()-1);

        return new_id;
    }

    public static void main(String[] args) {
        신규아이디추천 c = new 신규아이디추천();
        c.solution("aAAbb");
    }
}
