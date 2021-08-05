package de.termitehuegel.QuickSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        if (args.length != 0) {
            int[] array = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                array[i] = Integer.parseInt(args[i]);
            }
            quickSort(array, 0, array.length-1);
            System.out.println(Arrays.toString(array));
        }
    }

    public static void quickSort(int[] array, int begin, int end) {
        //End if less den 2 Elements need to be sorted (-> 1 or 0)
        if (begin < end) {
            //get position of a pivot and sort the rest left if it's lower and right if it's bigger
            int partitionIndex = partition(array, begin, end);

            //Sort everything lower than the last Pivot
            quickSort(array, begin, partitionIndex-1);
            //Sort everything bigger than the last Pivot
            quickSort(array, partitionIndex+1, end);
        }
    }

    private static int partition(int[] array, int begin, int end) {
        //The last element shall be the pivot
        int pivot = array[end];
        //the item lastLowerThanPivot is on the first Element -1
        int lastLowerThanPivot = (begin-1);

        for (int counter = begin; counter < end; counter++) {
            if (array[counter] <= pivot) {
                lastLowerThanPivot++;

                //Swap The element on counter with the element on lastLowerThanPivot
                int swapTemp = array[lastLowerThanPivot];
                array[lastLowerThanPivot] = array[counter];
                array[counter] = swapTemp;
            }
        }

        //swap the pivot (last Item) with the item after the lastLowerThanPivot Element
        int swapTemp = array[lastLowerThanPivot+1];
        array[lastLowerThanPivot+1] = array[end];
        array[end] = swapTemp;

        //return the index of the Pivot
        return lastLowerThanPivot+1;
    }

}

