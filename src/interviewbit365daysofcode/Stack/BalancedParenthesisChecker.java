package interviewbit365daysofcode.Stack;

import java.util.*;

public class BalancedParenthesisChecker {

    public int solve(String A) {
        HashMap<Character, Character> pair = new java.util.HashMap<>();
        pair.put('}', '{');
        pair.put(')', '(');
        pair.put(']', '[');

        // Use a stack to keep track of opening brackets
        Deque<Character> stack = new ArrayDeque<>();


        for (char ch : A.toCharArray()) {
            if (pair.containsValue(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || stack.peek() != pair.get(ch)) {
                    return 0;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        BalancedParenthesisChecker checker = new BalancedParenthesisChecker();

        // Test cases
        String[] testCases = {
                "{}[]()",   // Balanced
                "{[()]}",   // Balanced
                "{[(])}",   // Not balanced
                "{{[[(())]]}}"  // Balanced
        };

        for (String testCase : testCases) {
            int result = checker.solve(testCase);
            if (result == 1) {
                System.out.println(testCase + " is balanced.");
            } else {
                System.out.println(testCase + " is not balanced.");
            }
        }
    }

}
