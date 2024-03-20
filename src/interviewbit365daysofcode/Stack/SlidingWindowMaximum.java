package interviewbit365daysofcode.Stack;

import java.util.*;

public class SlidingWindowMaximum {

    public int[] slidingMaximum(final int[] A, int B) {
        if (A == null || A.length == 0 || B <= 0) {
            return new int[0];
        }

        int N = A.length;
        int[] result = new int[N - B + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            // Remove elements out of range B from the front of the deque
            while (!deque.isEmpty() && deque.peekFirst() < i - B + 1) {
                deque.pollFirst();
            }

            // Remove elements smaller than current element from the back of the deque
            while (!deque.isEmpty() && A[deque.peekLast()] < A[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // Add maximum element from the front of the deque to result array
            if (i >= B - 1) {
                result[i - B + 1] = A[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] A = {1, 3, -1, -3, 5, 3, 6, 7};
        int B = 3;
        int[] slidingMax = solution.slidingMaximum(A, B);
        System.out.println("Sliding Maximum: " + Arrays.toString(slidingMax));
    }
}
