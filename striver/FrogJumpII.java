import java.util.Arrays;

public class FrogJumpII {
    public static void main(String[] args) {
        int[] arr = {40, 10, 20, 70, 80, 10, 20, 70, 80, 60};
        int k = 4;
        int n = arr.length;

        int[] mem = new int[n+1];
        Arrays.fill(mem, -1);

        int res = helper(arr, mem, k, n-1);

        System.out.println("res: " + res);

    }

    public static int helper(int[] arr, int[] mem, int k, int n)
    {
        if(n == 0) return 0;

        int minStep = Integer.MAX_VALUE;
        if(mem[n] != -1) return mem[n];

        for(int i=1; i<=k; i++)
        {
            if(n-i>=0)
            {
                int jump= helper(arr, mem, k, n-i) +  Math.abs(arr[n-i] - arr[n]);
                minStep = Math.min(jump, minStep);
            }
        }

        return mem[n] = minStep;
    }
}
