package de.termitehuegel.QuickSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] s = {"zz", "aa", "xw", "lk", "k", "la"};
        QuickSort<String> quickSort = new QuickSort<>();
        quickSort.quickSort(s, 0, s.length-1);
        System.out.println(Arrays.toString(s));
    }
}

