import java.util.Arrays;

public class FrogJumpI {
    public static void main(String[] args) {
        int n = 8 ;
        int[] arr = {7, 4, 4, 2, 6, 6, 3, 4 };

        int mem[] = new int[8];

        //memoization
        // Arrays.fill(mem, -1);
        // int res = f(arr, mem, n);

        // System.out.println("min energy taken by from is: " + res);

        //tabulazation
        mem[0] = 0;

        for(int i=1; i<n; i++)
        {
            int right = Integer.MAX_VALUE;
            int left = mem[i-1] + Math.abs(arr[i] - arr[i-1]);
            if(i>1)
            {
                right = mem[i-2] + Math.abs(arr[i] - arr[i-2]);
            }
            mem[i] = Math.min(left, right);
        }

        System.out.println(" result: " + mem[n-1]);

    }

    public static int f(int[] arr, int[] mem, int n)
    {
        int right = Integer.MAX_VALUE;

        if(n==0) return 0;

        if(mem[n] != -1) return mem[n];
        
        int left = f(arr, mem, n-1) + Math.abs(arr[n] - arr[n-1]);
        if(n>1)
        {
            right = f(arr, mem, n-2) + Math.abs(arr[n] - arr[n-2]);
        }
        mem[n] = Math.min(left, right);
        return mem[n];

    }
}


