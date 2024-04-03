/*
최대한 BufferedReader와 BufferedWriter, StringTokenizer, StringBuilder의
사용을 익히고 메소드들도 알아보는걸 목표로 했다.

입력값 int n은 BufferedReader로 읽어 Integer클래스의 parseInt()메소드로 파싱했다.

구구단을 n * 1, n * 2 이런 식으로 출력할 것이기 때문에
for문에서 제어변수 i는 1로 초기화하고 i < 10번을 반복했다.

각 반복마다 (n + " * " + i + " = " + (n*i) + "\n")를 BufferedWriter로 출력하는데
n*i의 경우 괄호로 묶어 먼저 int형 연산이 일어난 후 문자열로 이어지도록 했다.

그리고 flush()하고 close()해서 소중한 자원을 돌려줬다.
*/

import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 1; i < 10; i++) {
        	bw.write(n + " * " + i + " = " + (n * i) + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
}