package org.dz19;

public class ArrayUtils {

    public static int[] getMergeSorted(int[] array) {
        mergeSort(array);
        return array;
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (array[middle] == target) {
                return middle;
            }

            if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }

    /* Private methods */

    private static void mergeSort(int[] array)
    {
        if (array == null || array.length <= 1) {
            return;
        }
        int mid = array.length / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[array.length - mid];
        System.arraycopy(array, 0, leftArr, 0, leftArr.length);
        System.arraycopy(array, mid, rightArr, 0, rightArr.length);
        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(array, leftArr, rightArr);
    }

    private static void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int i = 0, j = 0, k = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
    }
}
