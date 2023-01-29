package com.automation.java;

import java.util.Arrays;
import java.util.Random;

public class Matrix {

	public void addTwoMatrices(int a[][], int b[][], int row, int col) {
		int c[][] = new int[row][col];
		System.out.println("*******************");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				c[i][j] = a[i][j] + b[i][j];
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void subtractTwoMatrices(int a[][], int b[][], int row, int col) {
		int c[][] = new int[row][col];
		System.out.println("*******************");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				c[i][j] = a[i][j] - b[i][j];
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void multiplyTwoMatrices(int a[][], int b[][], int row, int col) {
		int c[][] = new int[row][col];
		System.out.println("*******************");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				c[i][j] = a[i][j] * b[i][j];
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(StringProgram[] args) {
		int row = 3, col = 3;
		int array1[][], array2[][];
		array1 = new int[row][col];
		array2 = new int[row][col];

		Random random = new Random(10);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				array1[i][j] = random.nextInt(10);
				array2[i][j] = random.nextInt(10);
			}
		}
		System.out.println(Arrays.deepToString(array1));
		System.out.println(Arrays.deepToString(array2));

		Matrix m = new Matrix();
		m.addTwoMatrices(array1, array2, row, col);
		m.subtractTwoMatrices(array1, array2, row, col);
		m.multiplyTwoMatrices(array1, array2, row, col);
	}
}
