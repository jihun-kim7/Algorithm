import java.util.*;
// import java.util.stream.*;

class Solution
{
    public int solution(int []A, int []B)
    {   
        // 올림차순
        Arrays.sort(A);
        
        // 내림차순
        // 올림차순으로 하고 맨 뒤 요소부터 곱할 수 있지만 그냥 내림차순 만듬
        // 1.
        // Integer[] array = Arrays.stream(B).boxed().toArray(Integer[]::new);
        // Arrays.sort(array, Collections.reverseOrder());
        
        // 2.
        // B = IntStream.of(B).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        
        // 3.
        // B = Arrays.stream(B).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();     
        
        // 1,2,3 은 시간초과 남
        
        Arrays.sort(B);
        
        int answer = 0;
        int len = A.length;
        for (int i=0; i<len; i++) {
            answer += A[i]*B[len-1-i];
        }
        
        return answer;
    }
}