package br.quixada.ufc.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.quixada.ufc.dealer.MatrixDealer;

public class DealerParralel implements MatrixDealer{
	private List<Worker> workes;
	
	public DealerParralel() {
		workes = new ArrayList<>();
	}
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

		
		// The worker will work just with one column from one matrix and the row of the other
		// will return the
		
		int countRow =0;
		int countColumn = 0;
		
		while(countRow<size) {
			int auxRow[] = new int[size];
			// The array one by time
			for(int i=0;i<size;i++) {
				auxRow[i] = matrix[countRow][i];
			}
			// all column by time
			while(countColumn<size) {
				int auxColumn[] = new int[size];
				for(int i=0;i<size;i++) {
					auxColumn[i] = matrixTwo[i][countColumn];
				}
				workes.add(new
						Worker(auxRow, auxColumn, resultMatrix, countRow, countColumn));
				countColumn++;
			}
			countColumn=0;
			countRow++;
		}
		
		startTheWorkers();
	
		return resultMatrix;
	}

	private void startTheWorkers() {
		for(int i=0;i<workes.size();i++) {
			workes.get(i).start();
			try {
				workes.get(i).join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
