package interviewbit365daysofcode.Stack;

import java.util.*;

public class ValidParentheses {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of testcases
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String s = sc.nextLine().trim(); // Input string
            System.out.println(isBalanced(s) ? 1 : 0);
        }
    }
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
