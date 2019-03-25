package AssignmentQs3;

import java.util.Scanner;

public class sudokuSolver {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scn.nextInt();
		int[][] board = createBoard();
		solve(board, 0, 0);
	}

	public static int[][] createBoard() {

		int[][] grid = new int[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				grid[i][j] = scn.nextInt();

			}

		}

		return grid;

	}

	public static boolean solve(int[][] board, int row, int col) {

		if (row == board.length) {
			display(board);
			return true;
		}
		if (col >= board[0].length) {
			return solve(board, row + 1, 0);
		}
		if (board[row][col] != 0) {
			return solve(board, row, col + 1);
		}

		for (int i = 1; i <= 9; i++) {

			if (isPlacedSafe(row, col, board, i)) {

				board[row][col] = i;

				boolean res = solve(board, row, col + 1);

				if (res) {

					return true;

				}

				board[row][col] = 0;
			}

		}

		return false;
	}

	private static void display(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static boolean isPlacedSafe(int row, int col, int[][] board, int value) {

		return (isPlacedSafeRow(row, board, value) && isPlacedSafeCol(col, board, value)
				&& isPlacedSafeCell(row, col, board, value));

	}

	public static boolean isPlacedSafeRow(int row, int[][] board, int value) {

		for (int i = 0; i < board[0].length; i++) {

			if (board[row][i] == value) {

				return false;
			}

		}

		return true;

	}

	public static boolean isPlacedSafeCol(int col, int[][] board, int value) {

		for (int i = 0; i < board.length; i++) {

			if (board[i][col] == value) {

				return false;
			}

		}

		return true;

	}

	public static boolean isPlacedSafeCell(int row, int col, int[][] board, int value) {

		int rs = row - row % 3;
		int cs = col - col % 3;

		for (int i = rs; i < rs + 3; i++) {

			for (int j = cs; j < cs + 3; j++) {

				if (board[i][j] == value) {

					return false;
				}

			}

		}

		return true;

	}

}
