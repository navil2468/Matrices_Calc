import java.util.Arrays;
import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("How many rows would you like in your array?");
    int rows = sc.nextInt();
    System.out.println("How many colummns would you like in your array?");
    int columns = sc.nextInt();
    int[][] test = new int[rows][columns];
    System.out.println("What operation would you like to do to the matrices? 1 - addition, 2 - subtraction, 3 - multiplication.");
    int choice = sc.nextInt();
    if (choice == 1){
        int[][] arrA = new int[rows][columns];
        arrA = generate(arrA, test);
        display(arrA, 'A');
        int[][] arrB = new int[rows][columns];
        arrB = generate(arrB, arrA);
        display(arrB, 'B');
        int[][] arrC = new int[3][3];
        arrC = matrixAdd(arrA, arrB);
        System.out.println("Resulting array is " );
        display(arrC, 'C');
    } else if (choice == 2){
        int[][] arrA = new int[rows][columns];
        arrA = generate(arrA, test);
        display(arrA, 'A');
        int[][] arrB = new int[rows][columns];
        arrB = generate(arrB, arrA);
        display(arrB, 'B');
        int[][] arrC = new int[3][3];
        arrC = matrixMinus(arrA, arrB);
        System.out.println("Resulting array is " );
        display(arrC, 'C');
    } else if (choice == 3){
        int[][] arrA = new int[rows][columns];
        arrA = generate(arrA, test);
        display(arrA, 'A');
        int[][] arrB = new int[columns][rows];
        arrB = generate(arrB, arrA);
        display(arrB, 'B');
        int[][] arrC = new int[3][3];
        arrC = matrixMul(arrA, arrB);
        System.out.println("Resulting array is " );
        display(arrC, 'C');
    } else{
        System.out.println("What");
    }
  }
  public static int[][] matrixAdd(int[][] a, int[][] b){
    if (a.length == 0){
      return a;
    }
    int[][] c = a;
    for (int i = 0; i < a.length; i++){
      for (int j = 0; j < a[0].length; j++){
        c[i][j] += b[i][j];
      }
    }
    return c;
  }
  public static int[][] matrixMinus(int[][] a, int[][] b){
    if (a.length == 0){
      return a;
    }
    int[][] c = a;
    for (int i = 0; i < a.length; i++){
      for (int j = 0; j < a[0].length; j++){
        c[i][j] -= b[i][j];
      }
    }
    return c;
  }
  public static int[][] matrixMul(int[][] a, int[][] b){
    int[][] c = new int [a.length][b[0].length];
    for (int i = 0; i < a.length; i++){
      for (int j = 0; j < b[0].length; j++){
        for (int k = 0; k < b.length; k++){
          c[i][j] += a[i][k] * b[k][j];
        }
      }
    }
    return c;
  }
  public static int[][] generate(int[][] arr, int [][] arr2){
    for (int i = 0; i < arr.length; i++){
      for (int j = 0; j < arr[i].length; j++){
        arr[i][j] = (int)(Math.random() * 99) + 1;
        for (int x = 0; x < arr2.length; x++){
          for (int y = 0; y < arr2[x].length; y++){
            if (arr[i][j] == arr2[x][y]){
              arr[i][j] = (int)(Math.random() * 99) + 1;
            }
          }
        }
      }
    }
    return arr;
  }
  public static void display(int[][] arr, char letter){
    if (letter != 'C')
      System.out.println("Matrix " + letter + ": ");
    for (int i = 0; i < arr.length; i++){
      for (int j = 0; j < arr[i].length; j++){
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
}