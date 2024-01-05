package com.dsce.datastructures;

public class Deque<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public Deque() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addToFront(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
    }

    public void addToRear(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T removeFromFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        T data = front.data;
        front = front.next;
        if (front != null) {
            front.prev = null;
        } else {
            rear = null; // Reset rear when the last element is removed from the front
        }
        size--;
        return data;
    }

    public T removeFromRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        T data = rear.data;
        rear = rear.prev;
        if (rear != null) {
            rear.next = null;
        } else {
            front = null; // Reset front when the last element is removed from the rear
        }
        size--;
        return data;
    }

    public void display() {
        Node<T> temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
