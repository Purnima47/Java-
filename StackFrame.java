import java.util.*;

public class StackFrame {
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static String reverse(String str) {
        Stack<Character> s = new Stack<>();
        int i = 0;
        while (i < str.length()) {
            s.push(str.charAt(i));
            i++;
        }

        StringBuilder result = new StringBuilder();
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }

        return result.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void printStack(Stack<Integer> s) {
        if (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void main(String[] args) {
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);

        // pushAtBottom(s, 5);

        // while (!s.isEmpty()) {
        // System.out.println(s.peek());
        // s.pop();
        // }

        // String str="HEYYYY";
        // String result=reverse(str);
        // System.out.println(result);

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        reverseStack(s);
        printStack(s);

    }
}
