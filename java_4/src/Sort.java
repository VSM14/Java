import java.util.Arrays;

public class Sort {

    //линейный для несортированного
    public static boolean lineUnsorted(int[] arr, int key) {
        for (int value : arr) {
            if (value == key) {
                return true;
            }
        }
        return false;
    }

    //быстрый линейный для несортированного
    public static void fastLineUnsorted(int[] arr, int key) {
        if (arr[arr.length - 1] == key) return;
        int temp = arr[arr.length - 1];
        arr[arr.length - 1] = key;
        int i = 0;
        while (arr[i] != key) {
            i++;
            if (i != (arr.length - 1)) {
                arr[arr.length - 1] = temp;
                return;
            }
        }
        arr[arr.length - 1] = temp;
    }

    //быстрый линейный для сортированного
    public static void fastLineSorted(int[] arr, int key) {
        if (arr[arr.length - 1] == key) return;
        int temp = arr[arr.length - 1];
        arr[arr.length - 1] = key;

        int i = 0;
        while (arr[i] <= key) {
            if (arr[i] == key) {
                arr[arr.length - 1] = temp;
                break;
            }
            i++;
        }

        if (i != (arr.length - 1)) return;
        arr[arr.length - 1] = temp;
    }

    //бинарный для сортированного
    public static void binSorted(int[] arr, int key) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (arr[middleIndex] == key) {
                return;
            } else if (arr[middleIndex] < key)
                firstIndex = middleIndex + 1;
            else if (arr[middleIndex] > key)
                lastIndex = middleIndex - 1;
        }
    }

    //блочный для сортированного
    public static boolean blockSorted(int[] arr, int key) {
        int div = 10;
        int int_amount = arr.length / div;
        int rem = arr.length % div;

        if (int_amount == 0) {
            return Sort.lineUnsorted(arr, key);
        }
        for (int i = 0; i < div; i++) {
            if (arr[int_amount * i + int_amount - 1] == key)
                return true;
            if (arr[int_amount * i + int_amount - 1] > key) {
                int[] newArr = Arrays.copyOf(Arrays.copyOfRange(arr, int_amount * i, arr.length), int_amount);
                return Sort.blockSorted(newArr, key);
            }
            if (rem != 0) {
                int[] newArr = Arrays.copyOf(Arrays.copyOfRange(arr, div * int_amount, arr.length), rem);
                if (Sort.blockSorted(newArr, key)) {
                    return true;
                }
            }
        }
        return false;
    }
}