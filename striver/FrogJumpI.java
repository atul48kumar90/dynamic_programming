import java.util.Arrays;

public class FrogJumpI {
    public static void main(String[] args) {
        int n = 7;
        int[] arr = {7, 4, 4, 2, 6, 6, 3, 4 };
        System.out.println("array: " + arr);

        int mem[] = new int[8];
        Arrays.fill(mem, -1);
        int res = f(arr, mem, n);

        System.out.println("min energy taken by from is: " + res);
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

