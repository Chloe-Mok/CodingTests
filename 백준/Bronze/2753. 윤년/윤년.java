import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 윤년은 1 아니면 0 출력
// 윤년 : 연도가 4의 배수이면서 100의 배수가 아님 / 혹은 400의 배수임 => 1출력
class Main {
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());
		br.close();
		
		int i = 0;
		if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			i = 1;
		}
		System.out.println(i);
	}
}