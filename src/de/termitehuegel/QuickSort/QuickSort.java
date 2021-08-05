package de.termitehuegel.QuickSort;

/**
 * @author termitehuegel
 */
public class QuickSort<T extends Comparable<T>> {

    public void quickSort(T[] array) {
        quickSort(array, 0, array.length-1);
    }
    /**
     * Sorts an array
     * @param array that will be sorted
     * @param begin index of the part that will be sorted
     * @param end index of the part that will be sorted
     */
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

    /**
     * Sorts all lower elements left and all bigger right of the pivot
     * @param array the array that is sorted
     * @param begin the index from the beginning of the part that is to be sorted
     * @param end the end index of the part that is to be sorted
     * @return the index of the pivot element
     */
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
                swap(array, lastLowerThanPivot, counter);
            }
        }

        //swap the pivot (last Item) with the item after the lastLowerThanPivot Element
        swap(array, lastLowerThanPivot+1, end);

        //return the index of the Pivot
        return lastLowerThanPivot+1;
    }

    /**
     * Swaps the positions of the values at e1 and e2
     * @param array the array e1 and e2 are part of
     * @param e1 the first elements index
     * @param e2 the second elements index
     */
    private void swap(T[] array, int e1, int e2) {
        T temp = array[e1];
        array[e1] = array[e2];
        array[e2] = temp;
    }
}
