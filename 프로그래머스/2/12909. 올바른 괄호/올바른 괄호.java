class Solution {
    boolean solution(String s) {
        int wait = 0;
        
        for (int i=0; i<s.length(); i++) {
            if (wait == 0) { 
                if (s.charAt(i) == '(') {
                    wait++;
                    continue;
                } else {
                    return false;
                }
            } else {
                if (s.charAt(i) == '(') {
                    wait++;
                    continue;
                } else {
                    wait--;
                    continue;
                }
            }
        }
        
        if (wait == 0) {
            return true;
        } else {
            return false;
        }
    }
}