package com.github;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static com.github.PyBuiltin.*;

public class JUnitTest {


    @Test
    public void test1() {
        print("xjj");
        print("helloworld");
        Collection<Integer> c = null;
        print(Math.pow(2, 2/3));
    }

    @Test
    public void test2() {
        Collection<String> source = new ArrayList<>();
        source.add("dfdkj");
        source.add("apdfj");
        Collection<String> result = filter(s -> s.startsWith("a"), source);
        print(result);
        Collection<String> resultmap = map(String::toUpperCase, source);
        print(resultmap);
    }

    @Test
    public void test3() {
        BigDecimal a = new BigDecimal("2");
        BigDecimal b = new BigDecimal("3");
        double result = pow(a, b);
        print(result);

    }

    @Test
    public void test4() {
        B b = new B();
        print(hasattr(b, "name", true));
    }

    @Test
    public void testSorted1() {
        Set<Integer> a = new HashSet<>();
        a.add(1);
        a.add(22);
        a.add(345);
        a.add(43);
        print(a);
        Set<Integer> afterSort = sorted(a, false);
        print(a);
        print(afterSort);
    }
    @Test
    public void testSorted2() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(22);
        a.add(345);
        a.add(43);
        print(a);
        List<Integer> afterSort = sorted(a);
        print(a);
        print(afterSort);
    }

    public class A {
        public String name;

        @Override
        public String toString() {
            return name;
        }

    }
    class B extends A {
        public int age;
    }
}
