import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main{
    static int[] checkArr;
	static int[] myArr;
	static int checkSecret;

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		 // 풀이 시작
		 StringTokenizer st = new StringTokenizer(br.readLine());

		 int S = Integer.parseInt(st.nextToken()); // 문자열 길이
		 int P =  Integer.parseInt(st.nextToken()); // 비밀번호로 사용할 부분 문자열의 길이

		 int result = 0;

		 char[] DNA = new char[S];

		 checkArr =  new int[4]; // 비밀번호 체크 배열
		 myArr = new int[4]; // 현재 상태 배열
		 checkSecret = 0; // 몇 개의 문자가 개수 조건을 충족했는지 나타내는 변수

		 DNA = br.readLine().toCharArray();
		 st = new StringTokenizer(br.readLine());
		 for(int i = 0; i < 4; i++){
			  checkArr[i] = Integer.parseInt(st.nextToken());
			  if(checkArr[i] == 0){
					checkSecret++;
			  }
		 }

		 for(int i = 0; i < P; i++){ // 초기 P 부분 문자열 처리
			  Add(DNA[i]);
		 }
		 if(checkSecret == 4)
			  result++;

		 for(int i = P ; i < S; i++){
			  int j = i - P;
			  Add(DNA[i]);
			  Remove(DNA[j]);
			  if(checkSecret == 4)
					result++;
		 }

		 bw.write(String.valueOf(result));

		 bw.flush();
		 bw.close();
	}

	// 새로 들어온 문자를 처리
	private static void Add(char c){
		 switch (c){
			  case 'A':
					myArr[0]++;
					if(myArr[0] == checkArr[0])
						 checkSecret++;
					break;
			  case 'C':
					myArr[1]++;
					if(myArr[1] == checkArr[1])
						 checkSecret++;
					break;
			  case 'G':
					myArr[2]++;
					if(myArr[2] == checkArr[2])
						 checkSecret++;
					break;
			  case 'T':
					myArr[3]++;
					if(myArr[3] == checkArr[3])
						 checkSecret++;
					break;
		 }
	}

	// 제거되는 문자 처리
	private static void Remove(char c){
		 switch (c){
			  case 'A':
					if(myArr[0] == checkArr[0])
						 checkSecret--;
					myArr[0]--;
					break;
			  case 'C':
					if(myArr[1] == checkArr[1])
						 checkSecret--;
					myArr[1]--;
					break;
			  case 'G':
					if(myArr[2] == checkArr[2])
						 checkSecret--;
					myArr[2]--;
					break;
			  case 'T':
					if(myArr[3] == checkArr[3])
						 checkSecret--;
					myArr[3]--;
					break;
		 }
	}  
}