import java.util.Stack;

public class MaxAreaInHisto {
    public static void maxArea(int height[]) {
        int maxArea = 0;
        int nsr[] = new int[height.length];
        int nsl[] = new int[height.length];

        // NEXT SMALLER RIGHT
        // in sb mein indices of next smaller right store hoga
        // aur kisi ke liye nsr agr nhi hai tb array ki total length store hogi !!
        Stack<Integer> s = new Stack<>();
        for (int i = height.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && height[s.peek()] >= height[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = height.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        // NEXT SMALLER LEFT
        // in sb mein indices of next smaller left store hoga
        // aur kisi ke liye nsl agr nhi hai tb -1 store hoga !!
        s = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!s.isEmpty() && height[s.peek()] >= height[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        // Current Area--> width:i-j-1=nsr[i]-nsl[i]-1
        for (int i = 0; i < height.length; i++) {
            int ht = height[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = ht * width;
            maxArea = Math.max(maxArea, currArea);
        }
        System.out.println(maxArea);
    }

    public static void main(String[] args) {
        int height[] = { 2, 1, 5, 6, 2, 3 };
        maxArea(height);
    }
}
