import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException, NumberFormatException, NullPointerException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(stn.nextToken());
        int B = Integer.parseInt(stn.nextToken());
        br.close();
        System.out.print((double)A / B);
    }
}