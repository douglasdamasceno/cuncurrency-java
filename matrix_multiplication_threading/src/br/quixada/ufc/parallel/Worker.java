package br.quixada.ufc.parallel;

public class Worker extends Thread{
	private int row[];
	private int column[];
	private int resultMatrix[][];
	private int rowPosition;
	private int columnPosition;
	public Worker(int row[], int column[], int resultMatrix[][], int rowPosition,int columnPosition) {
		this.row = row;
		this.column = column;
		this.resultMatrix = resultMatrix;
		this.rowPosition = rowPosition;
		this.columnPosition = columnPosition;
	}
	@Override
	public void run() {
		int size = this.row.length;
		int auxSum=0;
		for(int result=0;result<size;result++) {
			auxSum+=row[result]*column[result];
		}
		this.resultMatrix[this.rowPosition][this.columnPosition] = auxSum;
	}
}
