package ru.mirea.pr6;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void quickSort(int[] source, int leftBorder, int rightBorder) {

        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];

        do {

            while (source[leftMarker] < pivot) {
                leftMarker++;
            }

            while (source[rightMarker] > pivot) {
                rightMarker--;
            }

            if (leftMarker <= rightMarker) {

                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }

                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);


        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }

        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }

    public static void main(String[] args) {
        Random r = new Random();
        Scanner in = new Scanner(System.in);
        System.out.print("Введите колличество Студентов: ");
        int n = in.nextInt();
        String[] mass = new String[n];
        System.out.println("Введите Студентов");
        for (int i = 0; i < n; i++) {
            Scanner sc = new Scanner(System.in);
            String a = sc.nextLine();
            mass[i] = a;
        }
        int[] Result = new int[n];
        System.out.println("Введите ID");
        for (int k = 0; k < n; k++) {
            Result[k] = in.nextInt();
        }
        quickSort(Result, 0, n-1);
        System.out.println("\n");

        Revers.revers(Result, n);

        for (int j = 0; j < mass.length; j++) {
            System.out.println("Студент " + (j + 1) + " баллы : " + Result[j]);
        }






        class Student {
            private String name;
            private int point;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getPoint() {
                return point;
            }

            public void setPoint(int point) {
                this.point = point;
            }
        }
    }
}

class Revers {

    public static void revers(int mass[], int n) {

        int i, k, t;

        for (i = 0; i < n / 2; i++) {

            t = mass[i];

            mass[i] = mass[n - i - 1];

            mass[n - i - 1] = t;

        }
    }

}