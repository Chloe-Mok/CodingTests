import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // n을 10으로 나눈 나머지(현재 1의 자리)를 answer에 더함
        // => 현재 n이 10 미만인지 확인
        // n을 10으로 나누어 방금 더한 1의 자리를 없앰
        while(true) {
            answer += (n % 10);
            if(n < 10) {
                break;
            } else {
                n = (n / 10);                
            }
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}