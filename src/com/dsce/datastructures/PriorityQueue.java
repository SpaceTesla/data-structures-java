package com.dsce.datastructures;

import java.util.Comparator;

public class PriorityQueue<T> {
    private static class Node<T> {
        T data;
        int priority;
        Node<T> next;

        Node(T data, int priority) {
            this.data = data;
            this.priority = priority;
            this.next = null;
        }
    }

    private Node<T> front;
    private int size;
    private Comparator<Integer> priorityComparator;

    public PriorityQueue() {
        this.front = null;
        this.size = 0;
        // Default comparator: higher integer values have higher priority
        this.priorityComparator = Comparator.reverseOrder();
    }

    public PriorityQueue(Comparator<Integer> priorityComparator) {
        this.front = null;
        this.size = 0;
        this.priorityComparator = priorityComparator;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(T data, int priority) {
        Node<T> newNode = new Node<>(data, priority);
        if (isEmpty() || priorityComparator.compare(priority, front.priority) >= 0) {
            newNode.next = front;
            front = newNode;
        } else {
            Node<T> current = front;
            while (current.next != null && priorityComparator.compare(priority, current.next.priority) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority Queue is empty");
        }
        T data = front.data;
        front = front.next;
        size--;
        return data;
    }

    public void display() {
        Node<T> temp = front;
        while (temp != null) {
            System.out.print(temp.data + "(" + temp.priority + ") ");
            temp = temp.next;
        }
        System.out.println();
    }
}
