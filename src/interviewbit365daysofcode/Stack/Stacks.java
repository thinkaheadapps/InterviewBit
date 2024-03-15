package interviewbit365daysofcode.Stack;

import java.util.LinkedList;

public class Stacks {

    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addFirst(10);
        stack.addFirst(20);
        stack.addFirst(30);
        stack.addFirst(40);

        System.out.println(stack.removeFirst());
        System.out.println(stack.removeFirst());


    }

}
