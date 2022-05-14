import java.util.Arrays;

public class LB4_SearchAlgorithms {
    public static void main(String[] args) {
        int size = 50000;
        int max = 10000;
        int X = 4567;

        int[] A = new int[size];

        for (int i = 0; i < size; i++) {
            A[i] = (int) (Math.random() * max);
        }

        long timeStart1 = System.nanoTime();
        Sort.lineUnsorted(A, X);
        long timeEnd1 = System.nanoTime();

        long timeStart2 = System.nanoTime();
        Sort.fastLineUnsorted(A, X);
        long timeEnd2 = System.nanoTime();

        Arrays.sort(A);

        long timeStart3 = System.nanoTime();
        Sort.fastLineSorted(A, X);
        long timeEnd3 = System.nanoTime();

        long timeStart4 = System.nanoTime();
        Sort.binSorted(A, X);
        long timeEnd4 = System.nanoTime();

        long timeStart5 = System.nanoTime();
        Sort.blockSorted(A, X);
        long timeEnd5 = System.nanoTime();


        System.out.println("\nВремя выполнения алгоритмов для " + size + " элементов\n");
        System.out.println("Неупорядоченного линейного: " + (timeEnd1 - timeStart1) / 1000 + " mks");
        System.out.println("Неупорядоченного быстрого линейного: " + (timeEnd2 - timeStart2) / 1000 + " mks\n");
        System.out.println("Упорядоченного быстрого линейного: " + (timeEnd3 - timeStart3) / 1000 + " mks");
        System.out.println("Упорядоченного бинарного: " + (timeEnd4 - timeStart4) / 1000 + " mks");
        System.out.println("Упорядоченного блочного: " + (timeEnd5 - timeStart5) / 1000 + " mks");
    }
}
