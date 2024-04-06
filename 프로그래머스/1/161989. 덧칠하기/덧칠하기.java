class Solution {
    public int solution(int n, int m, int[] section) {
            
        // 칠을 했다
        // => ((section[i] + m) - 1) 블록까지 칠함
        // => (section[i] + m)블록 = continuingPoint
        //    continuingPoint부터 칠이 필요한지 체크 필요
        
        // section[i] 값이 continuingPoint와 같거나 크다면 칠해야함
        // section[i] 값이 continuingPoint보다 작다면 칠할 필요 없음
        
        // 칠한 횟수
        int paintingCount = 0;
        // 섹션1번째 값 == 칠하기 시작할 지점
        int continuingPoint = section[0];
        
        
        for(int i = 0; i < section.length; i++) {
            if(section[i] < continuingPoint) {
                continue;
            }
            paintingCount++;
            continuingPoint = section[i] + m;
        }
       
        return paintingCount;
    }
}