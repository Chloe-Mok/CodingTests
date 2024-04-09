class Solution {
    public int[] solution(int n, String[] words) {
        
        // 탈락하는 단어의 인덱스 넘버를 찾기
        int wrongAnswerIndex = 0;
        char endingCh;
        char startingCh;
        
        // (length - 1)번 반복
        for(int i = 1; i < words.length; i++) {
            // 단어 끝&시작 알파벳이 잘못되었을 경우
            endingCh = words[i - 1].charAt(words[i - 1].length() - 1);
            startingCh = words[i].charAt(0);
            
            if(endingCh != startingCh) {
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
        
        
        
        /*
            HashSet사용 풀이
            
            int[] answer = { 0, 0 };
            char chEnd = words[0].charAt(words[0].length() - 1);
            char chStart;
            System.out.print(chEnd + " ");
            HashSet<String> log = new HashSet<>();
            log.add(words[0]);
            for (int i = 1; i < words.length; i++) {
                chStart = words[i].charAt(0);
                log.add(words[i]);
                if (chEnd != chStart || log.size() != i + 1) {
                    System.out.print(i + 1 + "!");
                    answer[0] = (i % n)+1;
                    answer[1] = (i / n) + 1;
                    break;
                }

                chEnd = words[i].charAt(words[i].length() - 1);
                System.out.print(chEnd + " ");
            }
            System.out.println();
            System.out.println("(" + answer[0] + ", " + answer[1] + ")");
            return answer;
        */
        
    }
}