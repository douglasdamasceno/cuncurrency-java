package br.quixada.ufc.dealer;

public interface MatrixDealer {
	public int[][] generateRandomMatrix(int matrix[][], int size);
	public int[][] multiplyMatrix(int matrix[][], int matrixTwo[][]);
	public void printMatrix(int matrix[][]);
}
