import java.util.Arrays;

public class MaxSumNonAdjacentElement {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};
        int n = arr.length;

        int[] mem = new int[n+1];
        Arrays.fill(mem, -1);

        int res = f(arr, mem, n-1);

        System.out.println(" res: " + res);
    }

    public static int f(int[] arr, int[] mem, int n)
    {
        if(n == 0) return arr[n];
        if(n<0) return 0;

        if(mem[n] != -1) return mem[n];

        int pick = arr[n] + f(arr, mem, n-2);
        int not_pick = 0 + f(arr, mem, n-1);

        return mem[n] = Math.max(pick, not_pick);
    }
}
