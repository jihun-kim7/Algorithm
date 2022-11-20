class Solution {
    public String solution(int a, int b) {
        String[] day = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int[] Month = {31,29,31,30,31,30,31,31,30,31,30,31};
        int date = 0;
        
        for (int i=0; i<a-1; i++) {
            date += Month[i];
        }
        
        date += b;
        
        return day[date%7];
    }
}