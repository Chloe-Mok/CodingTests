import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // 검사자 답변
        int tempChoice;

        // 배점표와 인덱스
        int tempScoreIndex;
        int[] scores = {3, 2, 1, 0, 1, 2, 3};

        // 결과 해시맵
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < survey.length; i++) {
            tempChoice = choices[i];
            if(tempChoice != 4) {
                char alphabet = (tempChoice < 4) ? survey[i].charAt(0) : survey[i].charAt(1);
                map.put(alphabet, (map.getOrDefault(alphabet, 0) + scores[tempChoice - 1]));
            }
        }

        return new StringBuilder()
                   .append((map.getOrDefault('R', 0) >= map.getOrDefault('T', 0)) ? 'R' : 'T')
                   .append((map.getOrDefault('C', 0) >= map.getOrDefault('F', 0)) ? 'C' : 'F')
                   .append((map.getOrDefault('J', 0) >= map.getOrDefault('M', 0)) ? 'J' : 'M')
                   .append((map.getOrDefault('A', 0) >= map.getOrDefault('N', 0)) ? 'A' : 'N')
                   .toString();
        
    }
}