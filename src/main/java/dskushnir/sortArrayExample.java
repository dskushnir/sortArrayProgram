package dskushnir;

public class sortArrayExample {
    public static void main(String[] args) {
        int[] array = new int[100];
        initRandomArray(array, 1, 50);
        printArray(array);
        quickSortArray(array, 0, array.length - 1);
        printArray(array);
    }

    private static void initRandomArray(int[] array, int a, int b) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (b - a + 1) + a);
        }
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

   private static int separator(int[] array, int left, int right) {
       int count = left;
        for (int i = left; i < right; i++) {
            if (array[i] < array[right]) {
                int temp = array[count];
                array[count] = array[i];
                array[i] = temp;
                count++;
            }
        }
        int temp = array[right];
        array[right] = array[count];
        array[count] = temp;
        return count;
    }

    private static void quickSortArray(int[] array, int left, int right) {
        if (right <= left) return;
        int pivot = separator(array, left, right);
        quickSortArray(array, left, pivot-1);
        quickSortArray(array, pivot+1, right);
    }
}
