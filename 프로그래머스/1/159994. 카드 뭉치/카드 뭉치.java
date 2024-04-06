class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
           
        // goal의 문장을 읽으며
        // goal의 단어가 cards1, card2에 포함되는지 확인
        // 끝까지 성공하면 문장이 완성된다는 의미
        int indexOne = 0;
        int indexTwo = 0;
        for(String targetStr : goal) {
            if(indexOne < cards1.length && targetStr.equals(cards1[indexOne])) {     
                indexOne++;
            } else if (indexTwo < cards2.length && targetStr.equals(cards2[indexTwo])) {
                indexTwo++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}