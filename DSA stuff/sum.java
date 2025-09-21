import java.util.Scanner;

class sum{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            Summation(a, b, n);
        }
        in.close();
    }
    
    public static void Summation(int a, int b, int n) {
        int sum = a;
        for (int i = 0; i < n; i++) {
            sum += b * Math.pow(2, i);
            System.out.print(sum + " ");
        }
        System.out.print("\n");
    }
    
    
}