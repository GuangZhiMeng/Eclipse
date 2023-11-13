package project01;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        while (n -- > 0){//n：执行次数 递减
            int x = sc.nextInt();
            boolean ifPrime = true;
            for(int i = 2; i * i <= x; i++){
                if(x % i == 0){
                    ifPrime = false;
                    break;
                }
            }
            
            if(ifPrime){
                System.out.printf("%d is prime\n", x);
            }else{
                System.out.printf("%d is not prime\n", x);
            }
        }
	}
}
