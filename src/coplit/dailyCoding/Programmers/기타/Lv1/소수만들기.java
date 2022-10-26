package coplit.dailyCoding.Programmers.기타.Lv1;

public class 소수만들기 {
    public int solution(int[] nums) {
        boolean[] visited = new boolean[3001];
        int answer = 0;

        for (int i = 2; i <= Math.sqrt(3000); i++) {
            if (!visited[i]) {
                for (int j = 2*i; j <= visited.length; j+=i) {
                    visited[j] = true;
                }
            }
        }

        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    if (!visited[num]) {answer++;}
                }
            }
        }

        return answer;
    }

    /** 이렇게도 할 수 있다. 시간복잡도는 위에 코드가 더 빠름. 위에 꺼 쓰자
   public int solution(int[] nums) {
        int ans = 0;

        for(int i = 0; i < nums.length - 2; i ++){
            for(int j = i + 1; j < nums.length - 1; j ++){
                for(int k = j + 1; k < nums.length; k ++ ){
                    if(isPrime(nums[i] + nums[j] + nums[k])){
                        ans += 1;
                    }
                }
            }
        }
        return ans;
    }
    public Boolean isPrime(int num){
        for(int i = 2; i <= (int)Math.sqrt(num); i ++){
            if(num % i == 0) return false;
        }
        return true;
    }
     **/
}
