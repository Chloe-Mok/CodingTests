import java.util.Arrays;

// 주석버전
class Solution {

    public int solution(int x, int y, int n) {
        // 문제에서 1 ≤ x ≤ y ≤ 1,000,000이므로
        if(x == y) {
            return 0;
        }

        // dp 배열 선언 => Integer.MAX_VALUE, dp[x]에 0 대입
        // -1이나 MIN_VALUE 등 초기화 시 Math.min()에서 항상 해당 숫자가 반환되어버리므로 MAX_VALUE 사용
        int[] dp = new int[y + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        /*
        혹은 아래의 코드
        for (int i = x + 1; i <= y; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        혹은 아예 아래 반복문 내부에서 조건을 추가해 -1이나 유효값을 대입하는 방법
        */
        
        for(int i = x; i <= y; i++) {
            // dp[i]에 도달할 방법이 있는 경우(dp[x]포함)에만 수행문 실행
            // 현재 반복에서 사용할 정보들은 변수화 (가독성 및 중복코드 제거)
            // added, doubled, tripled => 세가지 연산의 결과(점프할 인덱스)
            if(dp[i] != Integer.MAX_VALUE) {
                int increasedCount = dp[i] + 1;

                // [Case1] i + n 연산의 경우
                // (added <= y) : 저장할 필요가 있는 값인지 판별, dp[y]일 때 반복을 제외하면 무조건 한번의 비교연산(<)만 일어난다
                int added = i + n;
                if(added <= y) {
                    dp[added] = Math.min(increasedCount, dp[added]);
                }

                // [Case2] i * 2 연산의 경우
                int doubled = i * 2;
                if(doubled <= y) {
                    dp[doubled] = Math.min(increasedCount, dp[doubled]);
                }

                // [Case3] i * 3 연산의 경우
                int tripled = i * 3;
                if(tripled <= y) {
                    dp[tripled] = Math.min(increasedCount, dp[tripled]);
                }
            }
        }
        // 최종 y까지 도달하기 위한 연산의 횟수
        return (dp[y] == Integer.MAX_VALUE) ? -1 : dp[y];
    }
    
    // 문제
    /*
        자연수 x를 y로 변환
        x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return하는 메소드 작성
        x를 y로 만들 수 없다면 -1을 return

        1 ≤ x ≤ y ≤ 1,000,000
        1 ≤ n < y

        x에 사용할 수 있는 연산은 세가지
        + n
        *2
        *3

        매개변수 : 자연수 x, y, n
    */

    // 풀이 계획 : 경우의 수를 구하여 나중에 대소비교할 것임
    // 최소 연산 횟수가 몇인지만 알면 되기때문에 그 결과를 저장
    // 시작하기 전에 효율, 가독성, 안정성의 밸런스를 생각 => 방향성
    /*
        1) x에서 x로 도달하기위한 연산 횟수는 항상 0이므로 고려할 필요 없음
            => 이 문제는 수천줄의 코드가 아니므로 dp[x]는 int[dp]배열 선언 시 초기화된 0을 유지,
               기타 위협요소나 사람의 실수 등 변경 가능성이 없을것

        2) dp의 목적 생각

        3) 조건문 뭐로세우지
            1. i가 x와 같은가 아닌가 => 초기화 여부를 알기위해 필요 / 첫 루프 말고는 확인할 필요 없는 조건
            2. 저장할 필요가 있는 값인가 아닌가 => dp[i]에 의미있는 값이 있는가 아닌가
                dp[i]의 값이 1보다 작다면 dp[i]에 도달할 방법이 없다는 의미 => 끊긴 길이므로 이후 로직 수행할 필요 없다
                dp[i]에 값이 1보다 크다면 도달할 수 있다는 의미            => 이후 로직을 수행하면 된다

        4) 반복에서 사용할 변수 added, doubled, tripled
            원시자료형임 => 구조적 안정성과 가독성을 포기하며 외부에 선언해야하는가?
            
        5) for루프 i 초기화식, 반복에 사용할 조건식 등
            반복문 자체 안정성 증가, 가독성 증가, 약간의 비효율성
            <->
            약간의 효율성, 변경 가능성에 구조적으로 대응 불가(코테가 아니라면 접근자 등으로 개선)   
    */
    
    // 참고 : DP알고리즘

    // Note. 그냥 많이 풀어보자
}