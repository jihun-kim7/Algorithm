import java.io.*;
import java.util.Stack;

public class Main {

    static int N;
    static Stack<int[]> stack = new Stack<>();
    static long answer;

    public static void main(String[] args) throws IOException {
        // N이 50만이기 때문에 웬만해선 O(N)이나 O(logN) 으로 해결해야함 . 
        // stack

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            // h => 키
            int h = Integer.parseInt(br.readLine());
            // cnt => 연속된 동일값 개수
            int cnt = 1;

            // 자신의 키와 스택에 쌓인 사람들의 키를 비교한다.
            // 만약 자신의 키가 스택에 있는 사람의 키보다 크다면 스택에서 사람을 지운다. (자신의 키가 더 크면 기존 스택에 있던 것들은 무용지물. 앞으로 나올 값들과 쌍이 될 수 없기 때문에 )
            // 스택은 내림차순으로 유지된다.
            while (!stack.isEmpty() && h > stack.peek()[0]) {
                int[] pop = stack.pop();
                answer += pop[1];
            }

            // 자신의 키와 스택에 있는 사람의 키가 같을 때.
            // 스택의 값을 없애고, 스택의 cnt만큼 현재 cnt에 추가한다.
            if (!stack.isEmpty() && h == stack.peek()[0]) {
                int[] pop = stack.pop();

                // 기존 스택 값을 없애기 때문에 answer에 더해준다.
                answer += pop[1];
                cnt += pop[1];
            }

            // 스택안에 사람이 있을 때. 쌍이 되므로 1을 더해줌
            if (!stack.isEmpty()) {
                answer++;
            }

            stack.push(new int[]{h, cnt});
        }

        bw.write(answer + "\n");
        bw.flush();
    }
}
