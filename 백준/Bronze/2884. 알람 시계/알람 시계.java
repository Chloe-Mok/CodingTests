import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();
        sc.close();
        
        if(M < 45) {
            H = (0 < H) ? --H : 23;
            M += 15;
        } else {
            M -= 45;
        }
        System.out.print(H + " " + M);
    }
}