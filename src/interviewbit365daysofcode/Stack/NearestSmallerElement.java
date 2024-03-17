package interviewbit365daysofcode.Stack;

import  java.util.*;

public class NearestSmallerElement {

    public int[] prevSmaller(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
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
        NearestSmallerElement nse = new NearestSmallerElement();
        int[] A = {4, 5, 2, 10, 8};
        int[] result = nse.prevSmaller(A);
        System.out.println("Input array: " + Arrays.toString(A));
        System.out.println("Nearest smaller elements: " + Arrays.toString(result));
    }

}
