import java.util.regex.*;

class Solution {
    public String solution(String s) {
        
//         boolean setUpperCase = true;
        
//         String[] arr = s.toLowerCase().split("");
        
//         String answer = "";
        
//         for (String str : arr) {
//             answer += setUpperCase ? str.toUpperCase() : str;
//             setUpperCase = str.equals(" ") ? true : false;
//         }
        
//         return answer;
        
        Matcher m = Pattern.compile("\\b([\\w])([\\w]*)").matcher(s);
        while (m.find()) {
            s = s.replaceAll("\\b" + m.group(), m.group(1).toUpperCase() + m.group(2).toLowerCase());
        }
        return s;
    }
}