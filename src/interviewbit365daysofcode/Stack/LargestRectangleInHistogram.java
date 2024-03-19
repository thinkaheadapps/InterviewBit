package interviewbit365daysofcode.Stack;

import  java.util.*;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] A) {
    int n=A.length;
    int left[]=new int[n];
    int right[]=new int[n];
    Stack<Integer> st=new Stack<Integer>();// Stack-1 for Left
        for(int i=0;i<n;i++){
        while(st.size()!=0 && A[st.peek()]>A[i])
            st.pop();
        if(st.size()==0)
            left[i]=-1;
        else
            left[i]=st.peek();
        st.push(i);
    }
    Stack<Integer> st1=new Stack<Integer>(); // Stack-2 for Right
        for(int i=n-1;i>=0;i--){
        while(st1.size()!=0 && A[st1.peek()]>=A[i])
            st1.pop();
        if(st1.size()==0)
            right[i]=n;
        else
            right[i]=st1.peek();
        st1.push(i);
    }
    int area=0;
        for(int i=0;i<n;i++){
        int h=A[i];
        int w=right[i]-left[i]-1;
        area=Math.max(area,h*w);
    }
        return area;
}

    public static void main(String[] args) {
        // Create an instance of Solution class
        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();

        // Example input array
        //int[] inputArray = {2, 1, 5, 6, 2, 3};
        int[] inputArray = {2};

        // Calculate the largest rectangle area using the largestRectangleArea method
        int result = solution.largestRectangleArea(inputArray);

        // Print the result
        System.out.println("Largest Rectangle Area: " + result);
    }

}
