/*
else if 혹은 switch~case문을 이용하였다.
String은 immutable한 참조자료형이기 때문에
2바이트짜리 primitive type char를 사용
사치부리지 않고 티끌만큼이라도 자원을 아껴보려고 했다.
제일 첫 조건문에 60 미만의 경우의 수를 배제해 조금 더 효율적일 수 있도록 작성했다.
*/
// 시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        sc.close();
        
        char grade = ' ';
        if(score < 60) {
            grade = 'F';
        } else if(score < 70) {
            grade = 'D';
        } else if(score < 80) {
            grade = 'C';
        } else if(score < 90) {
            grade = 'B';
        } else {
            grade = 'A';
        }
        System.out.print(grade);
    } 
}
