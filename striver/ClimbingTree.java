import java.util.Arrays;

class ClimbingTree {
    public int climbStairs(int n) {
        int[] mem = new int[n+1];
        Arrays.fill(mem, -1);
        return f(n, mem);
    }

    public int f(int n, int[] mem)
    {
        if(n==0) return 1;
        if(n==1) return 1;

        if(mem[n] !=-1) return mem[n];
        int left = f(n-1, mem);
        int right = f(n-2, mem);
        mem[n] =  left + right;

        return mem[n];
    }
}