import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // arr은 결과값이다. M만큼 채워졌을 때, print한다.

    static int[] arr;
    static boolean[] visited;
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N];

        dfs(0);
        System.out.print(sb);
    }

    public static void dfs(int depth) {

        if (depth == M) {
            for (int j : arr) {
                sb.append(j).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i=0; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i+1;
                dfs(depth+1);
                visited[i] = false;
                arr[depth] = 0;
            }
        }

    }
}
