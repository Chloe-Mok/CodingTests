import java.util.Arrays;

class Solution {

    public String solution(String my_string) {
        String answer = "";

        // [ 1. answer += str 사용 ]
        String[] strArr = my_string.toLowerCase().split("");
        Arrays.sort(strArr);
        for(String str : strArr) {
            answer += str;
        }

        // [ 2. new String(char[]) 사용 ]
        char[] charArr = my_string.toLowerCase().toCharArray();
        Arrays.sort(charArr);
        answer = new String(charArr);

        return answer;
    }
}