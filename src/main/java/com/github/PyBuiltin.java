package com.github;

public class PyBuiltin {

    public static void print(Object o) {
        print(o, "\n");
    }

    public static void print(Object o, String end) {
        System.out.print(String.valueOf(o) + end);
    }


}
