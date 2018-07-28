package com.shreeda.example.javabasiccoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Random;

//@SpringBootApplication
public class AllSortsOfSorts {

    public static void main(String[] args) {
        int size = 80; //800000;
        int attempts = 5;

        for (int a = 0; a <= attempts; a++) {
            Random randGenerator = new Random();
            ArrayList<Integer> unsortedSeries = new ArrayList<Integer>();
            for (int i = 1; i <= size / 4; i++) {
                unsortedSeries.add(randGenerator.nextInt(size));
            }
            //System.out.println(unsortedSeries);
            long start = System.nanoTime();
            //Collections.sort(unsortedSeries);
            // bubbleSort(unsortedSeries);
            //selectionSort(unsortedSeries);
            //insertionSort(unsortedSeries);
            ArrayList<Integer> sortedSeries = mergeSort(unsortedSeries);
            //quickSort(unsortedSeries);
            // External sorting - https://github.com/marceldiass/java-external-sorting
            long end = System.nanoTime();
            //System.out.println("Sorted " + size / 4 + " in " + (end - start) / 1000 + "ms");
            //System.out.println(unsortedSeries);
            System.out.println(sortedSeries);
        }
    }

    public static void bubbleSort(ArrayList<Integer> unsortedSeries) {
        for (int i = 0; i < unsortedSeries.size(); i++) {
            for (int j = 0; j < unsortedSeries.size() - i - 1; j++)
                if (unsortedSeries.get(j) > unsortedSeries.get(j + 1)) {
                    Integer temp = unsortedSeries.get(j);
                    unsortedSeries.set(j, unsortedSeries.get(j + 1));
                    unsortedSeries.set(j + 1, temp);
                }
        }
    }

    public static void selectionSort(ArrayList<Integer> unsortedSeries) {
        int length = unsortedSeries.size();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < length - 1; i++) {
            // Find the minimum element in unsorted array
            int minimumIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (unsortedSeries.get(j) < unsortedSeries.get(minimumIndex)) {
                    minimumIndex = j;
                }
            }
            // Swap the found minimum element with the first
            // element
            int temp = unsortedSeries.get(minimumIndex);
            unsortedSeries.set(minimumIndex, unsortedSeries.get(i));
            unsortedSeries.set(i, temp);
        }
    }

    public static void insertionSort(ArrayList<Integer> unsortedSeries) {
        int length = unsortedSeries.size();

        // One by one, move boundary of unsorted subarray
        for (int i = 0; i < length-1; i++) {
            // Find the minimum element in unsorted array
            int key = unsortedSeries.get(i+1);
            int j = i;

            while (j >= 0 && unsortedSeries.get(j) > key)
            {
                unsortedSeries.set(j+1, unsortedSeries.get(j));
                j = j-1;
            }
            unsortedSeries.set(j+1, key);
        }
    }

    /*
     * ************************************************************************************************
     * BEGIN: MERGE SORT
     * ************************************************************************************************
     */
    /*
     * Entry point
     * Divides input into half until sizes reach 2 or less
     */
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> unsortedSeries) {
        int length = unsortedSeries.size();

        if (length < 2) {
            return unsortedSeries;
        }

        ArrayList<Integer> left = mergeSort(new ArrayList<Integer>(unsortedSeries.subList(0, length/2)));
        ArrayList<Integer> right = mergeSort(new ArrayList<>(unsortedSeries.subList(length/2, length)));
        ArrayList<Integer> mergedSorted = merge(left, right);

        return mergedSorted;

    }

    private static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> sortedSeries = new ArrayList<Integer>();
        int leftIndex=0, rightIndex=0;
        boolean checkRightOnly=false, checkLeftOnly=false;
        for (int i = 0; i < left.size() + right.size(); i++) {
            if (leftIndex == left.size()){
                checkRightOnly = true;
            } else if (rightIndex == right.size()) {
                checkLeftOnly = true;
            }
            if (!checkLeftOnly && !checkRightOnly && left.get(leftIndex) < right.get(rightIndex)){
                sortedSeries.add(i, left.get(leftIndex));
                leftIndex++;
            } else if (!checkLeftOnly){
                sortedSeries.add(i, right.get(rightIndex));
                rightIndex++;
            } else {
                sortedSeries.add(i, left.get(leftIndex));
                leftIndex++;
            }
        }
        return sortedSeries;
    }
    /*
     * ************************************************************************************************
     * END: MERGE SORT
     * ************************************************************************************************
     */

    /*
     * ************************************************************************************************
     * BEGIN: QUICK SORT
     * ************************************************************************************************
     */
    public static ArrayList<Integer> quickSort(ArrayList<Integer> unsortedSeries) {
        quickSort(unsortedSeries, 0, unsortedSeries.size() - 1);
        return unsortedSeries;
    }

    public static void quickSort(ArrayList<Integer> unsortedSeries, int start, int end) {
        int i = start, j = end;
        Integer temp = 0;
        Integer pivot = unsortedSeries.get((start + end) / 2);   //Not the best method since pivot is too deterministic.

        /** partition **/
        while (i <= j)
        {
            while (unsortedSeries.get(i) < pivot)
                i++;
            while (unsortedSeries.get(j) > pivot)
                j--;
            if (i <= j)
            {
                /** swap **/
                temp = unsortedSeries.get(i);
                unsortedSeries.set(i, unsortedSeries.get(j));
                unsortedSeries.set(j, temp);
                i++;
                j--;
            }
        }

        /** recursively sort lower half **/
        if (start < j)
            quickSort(unsortedSeries, start, j);
        /** recursively sort upper half **/
        if (i < end)
            quickSort(unsortedSeries, i, end);
    }

    /*
     * ************************************************************************************************
     * END: QUICK SORT
     * ************************************************************************************************
     */

//    public static void main(String[] args) {
//        //SpringApplication.run(AllSortsOfSorts.class, args);
//    }
}
