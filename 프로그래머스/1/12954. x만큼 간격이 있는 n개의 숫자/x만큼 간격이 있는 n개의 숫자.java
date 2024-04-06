class Solution {
    public long[] solution(int x, int n) {
        // n개 길이 long배열
        long[] answer = new long[n];
        
        // 배열 요소 대입
        for(int i = 0; i < n; i++) {
            answer[i] = (long) x * (i + 1);
        }
        
        // 아맞다 오버플로우
        // int범위 둘 곱해지면 overflow => long형 연산
        
        return answer;
    }
}