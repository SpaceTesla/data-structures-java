package com.dsce.datastructures;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<T> {
    private final ArrayList<T> stackList;

    public Stack() {
        stackList = new ArrayList<>();
    }

    public void push(T element) {
        stackList.add(element);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackList.remove(stackList.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            throw new EmptyStackException();
        }
        return stackList.get(stackList.size() - 1);
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    public int size() {
        return stackList.size();
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack: ");
        for (T element : stackList) {
            System.out.print(element + " ");

        }
        System.out.println("<- Top");
    }
}

