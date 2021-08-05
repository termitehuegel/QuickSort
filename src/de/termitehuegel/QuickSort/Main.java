package de.termitehuegel.QuickSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] s = {"zz", "aa", "xw", "lk", "k", "la"};
        QuickSort<String> quickSort = new QuickSort<>(s);
        quickSort.run();
        System.out.println(Arrays.toString(s));
    }
}

