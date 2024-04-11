import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        // 역순 정렬 시
        /*
        Integer[] scoreList = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(scoreList, Comparator.reverseOrder());
        
        for(int i = 0; i < scoreList.length; i++) {
            // if(i % m == 2) {
        	if((i + 1) % m == 0) {
                answer += (scoreList[i] * m);
            }
        }
        */
        
        // 일반 정렬 시
        Arrays.sort(score);
        // 배열 max길이에서 m씩 차감하며 반복
        for(int i = score.length; i >= m; i -= m) {
            answer += (score[i - m] * m);
        }
        
        return answer;
    }
}