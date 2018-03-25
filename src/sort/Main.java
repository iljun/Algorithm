package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        int[] list = new int[]{3, 5, 7, 9, 0, 1, 10, 2, 8, 4, 6};

        Sort sort = new Sort();

        System.out.println("bubbleSort");
        sort.bubbleSort(list);

        System.out.println("selectionSort");
        sort.selectSort(list);

        System.out.println("insertionSort");
        sort.insertionSort(list);

        System.out.println("mergeSort");
//        sort.mergeSort(list, list.length);

        System.out.println(Arrays.toString(list));
        System.out.println("quickSort");
        sort.quickSort(list, 0, list.length - 1);

        System.out.println("heapSort");
        sort.heapSort(list);

        System.out.println("radixSort");
//        sort.radixSort(list);
    }

}

class Sort {

    public void bubbleSort(int[] arr) {

        int[] list = arr.clone();
        for (int i = list.length - 1; 0 <= i; i--) {
            for (int j = 0; j < i; j++) {
                if (list[j + 1] < list[j]) {
                    int tmp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(list));
    }

    public void selectSort(int[] list) {

        int[] arr = list.clone();

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }

        System.out.println(Arrays.toString(arr));
    }

    public void insertionSort(int[] list) {

        int[] arr = list.clone();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int tmp = arr[i];
                    for (int k = i; k > j; k--) {
                        arr[k] = arr[k - 1];
                    }
                    arr[j] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }


    public void mergeSort(int[] list, int length) {

        int mid = length / 2;

        int[] leftList = new int[mid];
        int[] rightList = new int[length - mid];

        if (length == 1)
            return;

        for (int i = 0; i < leftList.length; i++) {
            leftList[i] = list[i];
        }

        for (int i = 0; i < rightList.length; i++) {
            rightList[i] = list[mid + i];
        }

        mergeSort(leftList, leftList.length);
        mergeSort(rightList, rightList.length);
        merge(leftList, rightList, list);

    }

    private void merge(int[] left, int[] right, int[] list) {
        int l = 0;
        int r = 0;
        int m = 0;

        while (left.length != l && right.length != r) {
            if (left[l] < right[r]) {
                list[m++] = left[l++];
            } else {
                list[m++] = right[r++];
            }
        }


        while (right.length != r) {
            list[m++] = right[r++];
        }

        while (left.length != l) {
            list[m++] = left[l++];
        }


    }

    public void quickSort(int[] list, int left, int right) {

        if (left < right) {
            int partition = partition(list, left, right);
            quickSort(list, left, partition - 1);
            quickSort(list, partition + 1, right);
        }

    }

    public int partition(int[] list, int begin, int end) {
        int left = begin;
        int right = end;

        int pivot = list[(left + right) / 2];//비교 pivot값

        while (left < right) {
            while (list[left] < pivot)//pivot보다 큰값이 나올때까지
                left++;

            while (pivot < list[right])//pivot보다 작은값이 나올때까지
                right--;

            if (left < right) {
                int tmp = list[left];
                list[left] = list[right];
                list[right] = tmp;
            }
        }
        System.out.println(Arrays.toString(list));
        return left;

    }


    public void heapSort(int[] list) {
        List<Integer> result = new ArrayList<>();
        List<Integer> arr = Arrays.stream(list).boxed().collect(Collectors.toList());
        for (int i = 0; i < list.length; i++) {
            arr = heapify(arr);
            result.add(arr.get(0));
            arr.remove(0);
        }
        System.out.println(result.toString());
    }

    private List<Integer> heapify(List<Integer> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i) < list.get(i / 2)) {
                int tmp = list.get(i);
                list.set(i, list.get(i / 2));
                list.set(i / 2, tmp);
            }
        }
        return list;
    }

    public void radixSort(int[] list) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.length; i++) {
            if (list[i] > max)
                max = list[i];
        }

        int count = 0;
        while (max > 0) {
            max = max % 10;
            count++;
        }

        for (int k = count; k >= 0; k--) {
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i] % (k * 10) > list[i + 1] % (k * 10)) {
                    int tmp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(list));
    }
}
