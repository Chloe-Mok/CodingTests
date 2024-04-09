class Solution {
    public int[] solution(int n, String[] words) {
        
        // 탈락하는 단어의 인덱스 넘버를 찾기
        int wrongAnswerIndex = 0;
        // (length - 1)번 반복
        for(int i = 1; i < words.length; i++) {
            // 단어 끝&시작 알파벳이 잘못되었을 경우
            char endingAlphabet = words[i - 1].charAt(words[i - 1].length() - 1);
            char startingAlphabet = words[i].charAt(0);
            
            if(endingAlphabet != startingAlphabet) {
                wrongAnswerIndex = i;
                break;
            }
            
            // 이미 나온 단어일 경우
            for(int j = 0; j < i; j++) {
                if(words[i].equals(words[j])) {
                    wrongAnswerIndex = i;
                    break;
                }
            }
            
            // 오답을 찾았을 경우 반복문 탈출
            if(0 != wrongAnswerIndex) {
                break;
            }
        }
        
        // 틀린 사람, 틀린 라운드
        int person = 0;
        int round = 0;
        
        if(wrongAnswerIndex != 0) {
            // 틀린 사람
            int wrongAnswerNum = wrongAnswerIndex + 1;
            person = wrongAnswerNum < n ? wrongAnswerNum : ((wrongAnswerNum % n) != 0 ? wrongAnswerNum % n : n);

            // 오답이 어느 round에 속해있는지 확인
            int totalRound = words.length / n;
            for(int i = 1; i < totalRound + 1; i++) {
                if(wrongAnswerIndex < (i * n)) {
                    round = i;
                    break;
                }
            }   
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
        System.out.println("Hello Java");
        int[] answer = {person, round};
        return answer;
    }
}