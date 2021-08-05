package de.termitehuegel.QuickSort;

/**
 * @author termitehuegel
 */
public class QuickSort<T extends Comparable<T>> {

    public void quickSort(T[] array ,int begin, int end) {
        //finished if less than 2 Elements need to be sorted (-> 1 or 0)
        if (begin < end) {
            //get position of a pivot and sort the rest left if it's lower and right if it's bigger
            int pivotIndex = findPivot(array, begin, end);

            //Sort everything lower than the last Pivot
            quickSort(array, begin, pivotIndex-1);
            //Sort everything bigger than the last Pivot
            quickSort(array, pivotIndex+1, end);
        }
    }

    private int findPivot(T[] array, int begin, int end) {
        //The last element shall be the pivot
        T pivot = array[end];
        //the item lastLowerThanPivot is on the first Element -1
        int lastLowerThanPivot = (begin - 1);

        //compare all elements to the pivot
        for (int counter = begin; counter < end; counter++) {
            //if element<=pivot
            if (array[counter].compareTo(pivot) <= 0) {
                lastLowerThanPivot++;

                //Swap The element on counter with the element on lastLowerThanPivot
                T swapTemp = array[lastLowerThanPivot];
                array[lastLowerThanPivot] = array[counter];
                array[counter] = swapTemp;
            }
        }

        //swap the pivot (last Item) with the item after the lastLowerThanPivot Element
        T swapTemp = array[lastLowerThanPivot+1];
        array[lastLowerThanPivot+1] = array[end];
        array[end] = swapTemp;

        //return the index of the Pivot
        return lastLowerThanPivot+1;
    }
}
