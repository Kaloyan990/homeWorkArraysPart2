
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class javaTasks {
    public static void main(String[] args) {

        createMagicSquare(); //TASK1
        sumOfOdds(); //TASK 2
        semesterGrades(); //TASK 3
    }

    private static void semesterGrades() {
        int marks[] = new int[6];
        int i = 0;
        float total=0, avg = 0;
        Scanner scanner = new Scanner(System.in);

        averageValueOfMarks(marks, total, scanner);
        getMax(marks);
        getMin(marks);

        int max = getMax(marks);
        System.out.println("Най-висока оценка: " + max);
        int min = getMin(marks);
        System.out.println("Най-ниска оценка: " + min);

    }



    private static int getMin(int[] inputMarks) {
        int minValue = inputMarks[0];
        for (int index = 1; index < inputMarks.length; index++) {
            if (inputMarks[index] < minValue){
                minValue = inputMarks[index];
            }
        }
        return minValue;
    }



    private static int getMax(int[] inputMarks) {
        int maxValue = inputMarks[0];
        for (int index = 1; index < inputMarks.length; index++) {
            if (inputMarks[index] > maxValue){
                maxValue = inputMarks[index];
            }
        }

        return maxValue;
    }


    private static int averageValueOfMarks(int[] marks, float total, Scanner scanner) {
        int indexMarks;
        float avg;
        for(indexMarks=0; indexMarks<6; indexMarks++) {
            System.out.print("Въведи точки по предмет от 0 до 100: " + (indexMarks+1) + ":");
            marks[indexMarks] = scanner.nextInt();
            total = total + marks[indexMarks];
        }

        avg = total / 6;
        System.out.println("Оценката е: ");
        if(avg>=80)
        {
            System.out.println("Отличен");
        }
        else if(avg>=60 && avg<80)
        {
            System.out.println("Много добър");
        }
        else if(avg>=40 && avg<60)
        {
            System.out.println("Добър");
        }
        else if(avg>=20 && avg<40)
        {
            System.out.println("Среден");
        }
        else
        {
            System.out.println("Слаб");
        }
        return indexMarks;
    }


    private static void sumOfOdds() {
        int rows, cols, sumCol;
        int[][] matrixOfNumbers = {
                {11, 12, 13, 14, 15, 16},
                {21, 22, 23, 24, 25, 26},
                {31, 32, 33, 34, 35, 36},
                {41, 42, 43, 44, 45, 46},
                {51, 52, 53, 54, 55, 56},
                {61, 62, 63, 64, 65, 66}
        };
        rows = matrixOfNumbers.length;
        cols = matrixOfNumbers[0].length;

        for (int i = 0; i < cols; i++) {
            sumCol = 0;
            for (int j = 0; j < rows; j++) {
                if (matrixOfNumbers[j][i] % 2 != 0) {
                    sumCol = sumCol + matrixOfNumbers[j][i];
                } else { break;
                }
            }
            System.out.println("Sum of " + (i + 1) + " column: " + sumCol);
        }
    }

    private static void createMagicSquare() {
        int[][] arr = new int[4][4];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter the values for the magic square. Input for the " + (i + 1) + " row: ");
            for (int j = 0; j < 4; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(inputCheck(arr));
        if (equalSumRowsColumns(arr, 0) && equalSumDiagonals(arr)) {
            System.out.println("It is a magic square.");
        } else {
            System.out.println("Wrong.");
        }
        in.close();

    }

    public static int[] removeValue(int[] arr, int a) {
        for (int i = a + 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr = Arrays.copyOf(arr, arr.length - 1);
        return arr;

    }

    public static int[] remains(int n, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                removeValue(arr, i);
                arr = Arrays.copyOf(arr, arr.length - 1);
                break;
            }
        }
        return arr;
    }

    public static boolean inputCheck(int[][] arr) {
        boolean correctInput = false;
        int expectedArr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                expectedArr = remains(arr[i][j], expectedArr);
            }
        }
        if (expectedArr.length < 1 || expectedArr == null) {
            correctInput = true;
        }
        return correctInput;
    }

    public static int sumOfRow(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int sumOfColumn(int[][] arr, int a) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][a];
        }
        return sum;
    }

    public static boolean equalSumRowsColumns(int[][] arr, int a) {
        if (a == arr.length) {
            return true;
        }
        return equalSumRowsColumns(arr, a + 1) && sumOfRow(arr[a]) == sumOfColumn(arr, a);
    }

    public static boolean equalSumDiagonals(int[][] arr) {
        int sum1 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i][i];
        }
        int sum2 = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum2 += arr[i][i];
        }
        return sum1 == sum2;
    }
}