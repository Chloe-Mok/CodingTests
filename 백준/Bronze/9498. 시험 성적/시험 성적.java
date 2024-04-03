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