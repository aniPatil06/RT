import java.util.Scanner;

public class RM2{
    static int count=0;

    public static double solve(int n, int a, int b, int k){
        count++;

        if(n<=1){
            return 1;
        }

        double work=Math.pow(n,k);
        for(int i=0;i<a;i++){
            work+=solve(n/b, a, b, k);
        }

        return work;
    }

    public static boolean isPower(int n,int b){
        while(n>1 && n%b==0){
            n=n/b;
        }
        return n==1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter values of n,a,b and k: ");
        int n=sc.nextInt();
        int a=sc.nextInt();
        int b=sc.nextInt();
        int k=sc.nextInt();

        if( n<1 || a<1 || b<2 || k<0 || !isPower(n,b)){
            System.out.println("Invalid input: ");
            return;
        }

        double result=solve(n, a, b, k);

        System.out.println("Total work done= "+result);
        System.out.println("Total number of recursive calls= "+count);
    }
}