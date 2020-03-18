package br.quixada.ufc.serial;

import java.util.Random;

import br.quixada.ufc.dealer.MatrixDealer;

public class Dealer implements MatrixDealer{

	@Override
	public int[][] generateRandomMatrix(int[][] matrix, int size) {
		Random randomNumber = new Random();
		int auxMatrix[][] = new int[size][size];
		for(int row=0;row<size;row++) {
			for(int column=0;column<size;column++) {
				auxMatrix[row][column] = randomNumber.nextInt(size - 1)+1;
			}
		}
		return auxMatrix;
	}

	@Override
	public int[][] multiplyMatrix(int[][] matrix, int[][] matrixTwo) {
		int size = matrix.length;
		int resultMatrix[][] = new int[size][size];
		
		for(int row = 0;row<size;row++) {
			for(int column = 0; column<size;column++) {
				for(int result =0;result<size;result++) {
					resultMatrix[row][column]+=matrix[row][result] * matrixTwo[result][column];
				}
			}
		} 
		return resultMatrix;
	}

	@Override
	public void printMatrix(int[][] matrix) {
		int size = matrix.length;
		for(int row = 0;row<size;row++) {
			for(int column=0;column<size;column++) {
				System.out.print(matrix[row][column]+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
