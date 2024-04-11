import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
	
		// 맵 : <String, Integer> => "name", yearning
        // 사진 : [photo1 키세트]. [photo2 키세트]...
		HashMap<String, Integer> people = new HashMap<>();
		for(int i = 0; i < name.length; i++) {
			people.put(name[i], yearning[i]);
		}
		
		for(int i = 0; i < photo.length; i++) {
			for(int j = 0; j < photo[i].length; j++) {
				if(null != people.get(photo[i][j])) {
					answer[i] += people.get(photo[i][j]);
				}
			}
		}     
                
        return answer;
    }
}