package interviewbit365daysofcode.Hashing;

import java.util.*;

public class TwoOutOfThree {

    public int[] solve(int[] A, int[] B, int[] C) {
        boolean[] a = new boolean[100001];
        boolean[] b = new boolean[100001];
        boolean[] c = new boolean[100001];

        for (int i : A)
            a[i] = true;
        for (int i : B)
            b[i] = true;
        for (int i : C)
            c[i] = true;

        List<Integer> resList = new ArrayList<>();
        for (int i = 1; i < 100001; i++) {
            if ((a[i] ? 1 : 0) + (b[i] ? 1 : 0) + (c[i] ? 1 : 0) > 1)
                resList.add(i);
        }

        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        TwoOutOfThree solution = new TwoOutOfThree();

        int[] A = {1, 2, 3, 4, 5};
        int[] B = {4, 5, 6, 7};
        int[] C = {5, 7, 8};

        int[] result = solution.solve(A, B, C);

        System.out.println("Common elements in at least two arrays:");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
