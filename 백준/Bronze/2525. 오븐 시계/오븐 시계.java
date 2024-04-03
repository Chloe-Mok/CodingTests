import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException { //
		// 현재시간 시 A(0~23) " " 분B(0~59)
		// 요리하는데 필요한 시간 : C 0 ~ 1000
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine(), " "); //
		int a = Integer.parseInt(stn.nextToken());
		int b = Integer.parseInt(stn.nextToken());
		int c = Integer.parseInt(br.readLine()); //
		br.close();
        
		c += (a * 60) + b;
		a = (c / 60) % 24;
		b = c % 60;
	
		System.out.println(a + " " + b);
	}

}
