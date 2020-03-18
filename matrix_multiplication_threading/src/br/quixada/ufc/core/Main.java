package br.quixada.ufc.core;

import br.quixada.ufc.dealer.MatrixDealer;
import br.quixada.ufc.parallel.DealerParralel;
import br.quixada.ufc.serial.Dealer;

public class Main {
	
	public static void main(String[] args) {
		int size = 3;
		int matrix[][] = new int [size][size];
		int matrixTwo[][] = new int [size][size];
		int resultMatrix[][]= new int [size][size];
		//serialVersion();
		
		pararrelVersion(size,matrix,matrixTwo,resultMatrix);
	
	}
	
	private static void pararrelVersion(int size,int matrix[][],int matrixTwo[][],int resultMatrix[][]) {
		System.out.println("Initial execution...");
		long initialTime = System.currentTimeMillis();
		MatrixDealer matrixDealer = new DealerParralel();
		matrix  = matrixDealer.generateRandomMatrix(matrix, size);
		System.out.println("Matrix one");
		matrixDealer.printMatrix(matrix);
		
		System.out.println("End Matrix One");
		
		
		System.out.println("Matrix Two");
		matrixTwo = matrixDealer.generateRandomMatrix(matrixTwo, size);
		matrixDealer.printMatrix(matrixTwo);
		
		System.out.println("End Matrix Two");
		System.out.println();
		
		System.out.println("Executing....");
		
		resultMatrix = matrixDealer.multiplyMatrix(matrix, matrixTwo);
		matrixDealer.printMatrix(resultMatrix);
		long endExecution = System.currentTimeMillis();
		
		System.out.println("End executing...");
	}

	private static void serialVersion(int size,int matrix[][],int matrixTwo[][],int resultMatrix[][]) {
		MatrixDealer matrixDealer = new Dealer();
		matrix  = matrixDealer.generateRandomMatrix(matrix, size);
		matrixDealer.printMatrix(matrix);
		
		matrixTwo = matrixDealer.generateRandomMatrix(matrixTwo, size);
		matrixDealer.printMatrix(matrixTwo);
		
		resultMatrix = matrixDealer.multiplyMatrix(matrix, matrixTwo);
		matrixDealer.printMatrix(resultMatrix);
	}
	
	

}
