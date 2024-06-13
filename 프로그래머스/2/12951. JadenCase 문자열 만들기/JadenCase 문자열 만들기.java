class Solution {
    public String solution(String s) {
        
        boolean setUpperCase = true;
        
        String answer = "";
        
        for (int i=0; i<s.length(); i++) {
            if (setUpperCase) {
                if (Character.isLetter(s.charAt(i))) {
                    answer += String.valueOf(s.charAt(i)).toUpperCase();
                    setUpperCase = false;
                    continue;
                } else if (s.charAt(i) != ' '){
                    setUpperCase = false;
                }
                answer += s.charAt(i);
            } else {
                if (Character.isLetter(s.charAt(i))) {
                    answer += String.valueOf(s.charAt(i)).toLowerCase();
                    continue;
                } else if (s.charAt(i) == ' ') {
                    setUpperCase = true;
                } 
                answer += s.charAt(i);
            }
        }
        
        return answer;
    }
}