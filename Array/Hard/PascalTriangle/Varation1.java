import java.util.Scanner;

public class Varation1 {

    static long nCr(int n,int r){
        int res = 1;

        for(int i=0;i<r;i++){
            res= res* (n-i);
            res = res / (i+1);
        }
        return res;
    }

    static int pascalTriangle(int r,int c){
         int res = (int) nCr(r-1, c-1);
         return res;
    }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the row number (r): ");
        int r = sc.nextInt();
        System.out.print("Enter the column number (c): ");
        int c = sc.nextInt();
        int element = pascalTriangle(r, c);
        System.out.println("The element at position (r,c) is: " + element);
    }
}
