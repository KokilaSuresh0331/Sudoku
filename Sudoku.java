package com.kokila.day2;

import java.util.Scanner;

public class Sudoku {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in) ;
	System.out.print("Enter the fixed size of array:");
	int n=sc.nextInt();
	System.out.println("Enter the array values:");
	int [][]a=new int [n][n];
	for(int i=0;i<a.length;i++) {
		for(int j=0;j<a.length;j++) {
			System.out.print("{"+i+"}"+"{"+j+"}"+":");
			a[i][j]=sc.nextInt();
			//System.out.println("{"+i+"}"+"{"+j+"}");
		}
	}
	if (solveSudoku(a)) {
        System.out.println("Sudoku solved successfully:");
        printBoard(a);
    } else {
        System.out.println("No solution exists for the given Sudoku problem.");
    }
}
private static boolean solveSudoku(int [][]board) {
	int n=board.length;
	 for (int row = 0; row < n; row++) {
         for (int col = 0; col < n; col++) {
             if (board[row][col] == 0) {
                 for (int num = 1; num <= n; num++) {
                     if (isValid(board, row, col, num)) {
                         board[row][col] = num;

                         if (solveSudoku(board)) {
                             return true;
                         } else {
                             board[row][col] = 0;
                         }
                     }
                 }
                 return false;
             }
         }
     }

	return true;

}
private static boolean isValid(int[][] board, int row, int col, int num) {
	 int n = board.length;
	for (int i = 0; i < n; i++) {
         if (board[row][i] == num || board[i][col] == num || board[row - row % 3 + i / 3][col - col % 3 + i % 3] == num) {
             return false;
         }
     }
	
	int sqrtN = (int) Math.sqrt(n);
    int startRow = row - row % sqrtN;
    int startCol = col - col % sqrtN;

    for (int i = 0; i < sqrtN; i++) {
        for (int j = 0; j < sqrtN; j++) {
            if (board[i + startRow][j + startCol] == num) {
                return false;
            }
        }
    }
	 return true;
 }
private static void printBoard(int[][] board) {
	System.out.print("Display Array:\n");
	for(int i=0;i<board.length;i++) {
		for(int j=0;j<board.length;j++) {
			System.out.print("|"+board[i][j]+" ");
			
		}
		System.out.println("|");
		
	}
	
	
}
}

