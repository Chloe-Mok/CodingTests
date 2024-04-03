import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	// StringTokenizer 빈문자열 구분자 인식 안함 / 지정안해도 공백문자(\s, \t, \n)해줌
	// String클래스 split(delimiter here) / 문자열 배열!로 반환 / 여러 구분자는 |로 이어 씀(근데 just a single parameter) / 메타문자는 \\붙이기 \\.
	// StringTokenizer랑 비교해서 속도는 걍 depends on
	public static void main(String[] args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine()); // 출력X
		
		String[] strArr;
		for(int i = 0; i < t; i++) {
			strArr = (br.readLine()).split(" "); // 배열로옴
			sb.append((Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[1])) + "\n");
		}
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}

}
