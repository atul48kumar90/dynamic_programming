import java.util.Arrays;

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        int n = arr.length;

        if (n == 1) {
            System.out.println(" res: " + arr[0]); // If only one house, return its value
            return;
        }

        int[] temp1 = Arrays.copyOfRange(arr, 0, n - 1); // Exclude last house
        int[] temp2 = Arrays.copyOfRange(arr, 1, n);     // Exclude first house

        int res = Math.max(rob(temp1), rob(temp2)); // Get max of both cases
        System.out.println(" res: " + res);
    }

    public static int rob(int[] arr) {
        int n = arr.length;
        int[] mem = new int[n]; // Memoization array
        Arrays.fill(mem, -1);
        return f(arr, mem, n - 1);
    }

    public static int f(int[] arr, int[] mem, int n) {
        if (n < 0) return 0;
        if (n == 0) return arr[0];

        if (mem[n] != -1) return mem[n];

        int pick = arr[n] + f(arr, mem, n - 2);
        int not_pick = f(arr, mem, n - 1);

        return mem[n] = Math.max(pick, not_pick);
    }
}
