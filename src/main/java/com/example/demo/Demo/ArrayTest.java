package com.example.demo.Demo;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        System.out.println(list.size());
        shorten(list,9);
        System.out.println(list.size());
        System.out.println(9.0/2);
        System.out.println((int)Math.ceil(9.0/2)*2);
    }

    public static void shorten(ArrayList<String> xs, int n)
    {
        for (int k = 0; k < n; k++)
            if (k % 2 == 0)
            {
                xs.remove(0);
                xs.remove(0);
            }
    }
}
