/*
주사위 3개 외에도 4개, 5개의 경우(1 ~ 5등)가 생기면 어떨까하고
최대한 실제 게임/로터리라고 생각하면서 작성하려고 했다.
그래서 상수 대신 변수를 사용한다든가 해서 유연하게 만들고 싶었는데
궁금한게 생겨도 주위에 피드백이나 팁 줄 사람도 없고 ㅁ?ㄹ
나같은 찐따는 지식도 자급자족해야한다.

getDuplicatedValue은 중복되는 값을 찾는 메소드로
중첩for문 코드가 길어 가독성이 너무 떨어지길래 따로 메소드화했다.
실패 시 -10을 리턴하는 이유는 일단 뭐라도 리턴해야 했는데
해당 prize계산 식에 -10이 리턴될 때 0원이 산출되기 때문이었다.
아직 쪼렙이라 상상력이 부족해서 '저기까지 도달할 경우가 있을까?' 싶었지만 방어적으로 작성했다.
근데 실제 주사위/로터리에서 마지막 return이 작동한다면 그냥 기능이..
아니 기관 자체가 망한거 아닐까?
------------------------------------------------------
prize계산식의 경우 문제의 계산식을 방정식으로 정리해 공통된 부분은 변수처리하고
해당 계산식을 각각 등수(조건문)마다 배치했다.

미래에 입력값이 3개 이상이 들어올 수 있다 상상하고 ArrayList에 담았다.
왜 ArrayList를 선택했냐면 이제 그건 지금부터 알아봐야한다.
LinkedList와 비교하는 글을 봤는데 모르는 개념이 많아 무슨 원리인지 모르겠다.
어쨌든 초보자의 나뭇가지같은 나의 버팀목 ArrayList를 토큰으로 초기화했다.

deduplicated(중복 제거 후 남은 숫자 개수)는
어레이리스트를 해쉬셋으로 변환해 중복값을 제거하고, size()를 구해 대입했다.

deduplicated가 ArrayList의 size()와 같다면 중복이 전혀 존재하지 않았다는 의미이고
숫자가 1 ~ n이라 가정했을 때 들어올 수 있는 경우의 수는 첫번째 n, 두번째 n-1, 세번째 n-2개이다.
n이 증가할수록 확률은 1에 수렴하고 다른 어떤 경우보다 높다.
그래서 제일 첫 조건문은 3등(마지막 등수)의 경우로 선택해 prize를 계산했다.
조건문은 이후로도 확률 순서로 배치했다.

1등과 꼴등 외 등수는 (deduplicated - 1), (deduplicated - 2)식으로 확장되게 만드려다 그냥 2를 썼다.
이유는 진짜 그냥.. Because because...

1등은 모든 숫자가 중복이어야 하기때문에 set에 한개의 값만 존재하고, 그렇기때문에 size()가 1일 수 밖에 없다.

BufferedReader()가 더 빠르다고 비교한 표를 봐서 한번 사용해봤다.
Scanner와 System.out.print를 쓸 때보다 채점 상 소요시간이 많이 줄어들었다.
flush()의 경우 어짜피 close()를 호출하면 자동으로 되는데 왜 쓸까 궁금해서 검색해봤는데
close()사용 전 버퍼에 남아있는 데이터를 비워야 할 때 제어권을 갖고 혹시 모를 오류에도 대비한다는 내용이었다.
그래서 습관을 들이려고 flush()도 사용했다.

BufferedWriter는 System.out.print시리즈처럼 입력값에 따른 overloading이 되어있지 않다.
그래서 String.valueOf()를 사용하지 않으면 이상한 문자가 출력된다.
------------------------------------------------------
메소드들을 이것저것 많이 찾아봤다.
read(), readLine(), skip(n) // writer(str), newLine() // flush(), close()
Collections.frequency()나 retainAll()같은 것도 있고
Map으로도 받고 List로도 받고 List는 Arrays.asList()도 있고 List.of()도 있고
또 메소드 하나 까보면 여기서 저기 호출하고 얘는 쟤를 호출하고 난리나고 엄청나게 방대하다.
보다보니 시간/공간 복잡도나 프레임워크에 대한 공부를 안하면 이해할 수 없는 내용들같았다.
다행히 좋은 무료 인프런 강의를 찾았다.
*/

// read(), readLine(), skip(n) // writer(str), newLine() // flush(), close()
// Collections.frequency
import java.io.*;
import java.util.*;

public class Main {
	
	public static int getDuplicatedValue(List<String> pipsList) { // 중복되는 값
    	for(int i = 0; i < pipsList.size(); i++) {
    		for(int j = 0; j < i; j++) {
    			if(pipsList.get(i).equals(pipsList.get(j))) {
    				return Integer.parseInt(pipsList.get(i));
    			}
    		}
    	}
    	return -10;
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		

		int prize = 0;
		int deduplicatedSize = 0; // 중복 제거 후 남은 숫자 개수
		ArrayList<String> pipsList = null;
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    StringTokenizer stn = new StringTokenizer(br.readLine()); // 입력
	    
	    pipsList = new ArrayList();
	    while(stn.hasMoreTokens()) {
	    	pipsList.add(stn.nextToken());
	    }
	    
	    deduplicatedSize = new HashSet(pipsList).size();
	    
	    if(deduplicatedSize == pipsList.size()) {
	    	prize = Integer.parseInt(Collections.max(pipsList)) * 100;
	    } else if(deduplicatedSize == 2) {
	    	prize = ((10 + getDuplicatedValue(pipsList) * 1) * 100);
	    	
	    } else if(deduplicatedSize == 1) {
	    	prize = ((10 + Integer.parseInt(pipsList.get(0))) * 10) * 100;
	    }
	    
	    bw.write(String.valueOf(prize)); // 출력
	    
	    bw.flush();
	    bw.close();
	    br.close();
	}
	
}
