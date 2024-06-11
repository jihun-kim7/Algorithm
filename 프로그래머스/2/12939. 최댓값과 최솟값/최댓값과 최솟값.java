class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] arr = s.split(" ");
        int maxVal = Integer.parseInt(arr[0]);
        int minVal = Integer.parseInt(arr[0]);
        int x = 0;
        for (String e : arr) {
            x = Integer.parseInt(e);
            if (x > maxVal) {
                maxVal = x;
            }

            if (x < minVal) {
                minVal = x;
            }
        }
        
        return answer + minVal + " " + maxVal;
    }
}