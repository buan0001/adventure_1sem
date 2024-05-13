package kea.exercise;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Person[] people = {
            new Person("Alice", 25),
            new Person("Bob", 20),
            new Person("Charlie", 30)
        };
        System.out.println("Before sorting:");
        System.out.println(Arrays.toString(people));
        java.util.Arrays.sort(people);
        System.out.println("After sorting:");
        System.out.println(java.util.Arrays.toString(people));
    }
}