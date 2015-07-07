package task6;

public class Main {

	// Testing case for fillArray(int[][] matrix, int row, int col, int a) method
	public static void main(String[] args) {
		int [][] matrix = new int [3][5];

		fillArray(matrix);
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Helper method that restricts indexes of rows and columns to zeros
	 * Also restricts value to start from zero
	 * @param matrix to be filled
	 */
	public static void fillArray(int[][] matrix) {
		fillArray(matrix, 0, 0, 0);
		
	}
	
	/**
	 * Fills 2D array with numbers from 0 
	 * @param matrix to be filled
	 * @param row represents index of row of given matrix
	 * @param col represents index of column of given matrix
	 * @param a increasing value for matrix members
	 */
	public static void fillArray(int[][] matrix, int row, int col, int a) {
	    if (row < matrix.length) {
	        if (col < matrix[row].length) {
	        	matrix[row][col] = a;
	        	fillArray(matrix, row, col + 1, ++a);
	        } else {
	        	fillArray(matrix, row + 1, 0, a);
	        }
	    }
	}
}
