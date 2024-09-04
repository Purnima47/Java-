
//AUXILIARY ARRAYS
import java.util.*;

public class TrappingRainwater {
    public static void trap(int height[], int n) {
        // RIGHT MAX
        int right[] = new int[n];
        right[0] = height[0];
        for (int i = 1; i < n; i++) {
            right[i] = Math.max(right[i - 1], height[i]);
        }

        // LEFT MAX
        int left[] = new int[n];
        left[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            left[i] = Math.max(height[i], left[i + 1]);
        }

        // MIN OF BOTH
        int vol = 0;
        for (int i = 0; i < n; i++) {
            vol += Math.min(right[i], left[i]) - height[i];
        }
        System.out.println(vol);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        int n = height.length;
        trap(height, n);
    }
}
