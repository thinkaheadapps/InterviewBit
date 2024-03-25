package interviewbit365daysofcode.Arrays;

public class MaxMin {

    public int solve(int[] A) {
        int n = A.length;
        int maxm = A[0];
        int minm = A[0];

        for (int i = 1; i < n; i++) {
            if (A[i] > maxm) {
                maxm = A[i];
            } else if (A[i] < minm) {
                minm = A[i];
            }
        }

        return maxm + minm;
    }

    public static void main(String[] args) {
        // Example array of integers
        int[] numbers = {3, 5, 1, 7, 2};

        // Create an instance of the Solution class
        MaxMin solution = new MaxMin();

        // Call the solve method and print the result
        int result = solution.solve(numbers);
        System.out.println("Max + Min = " + result);
    }
}
