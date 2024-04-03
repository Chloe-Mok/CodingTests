import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		br.close();
        
		int result = 0;
		if(0 < x) {
			result = 0 < y ? 1 : 4;
		} else {
			result = 0 < y ? 2 : 3;
		}
		
        System.out.println(result);
	}
}