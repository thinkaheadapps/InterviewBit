package interviewbit365daysofcode.Stack;

import java.util.Stack;

public class NextGreater {

    public int[] nextGreater(int[] A) {

        int N = A.length;
        int[] ans = new int[N];
        Stack<Integer> st = new Stack<>();

        for (int i = A.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && A[st.peek()] <= A[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                ans[i] = A[st.peek()];
            } else {
                ans[i] = -1;
            }
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        NextGreater solution = new NextGreater();

        // Example usage
        int[] input = {4, 5, 2, 10};
        int[] result = solution.nextGreater(input);

        System.out.println("Next greater elements array:");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
