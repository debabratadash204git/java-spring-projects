package leetCode150;

import java.util.*;

public class ValidSudoku {
	private static boolean isValid(int[][] mat) {

		int len = 9;
		
		//array of sets for each rows and columns and boxes
		HashSet<Integer>[] rows = new HashSet[len];
		HashSet<Integer>[] cols = new HashSet[len];
		HashSet<Integer>[] boxs = new HashSet[len];

		for (int i = 0; i < len; i++) {
			rows[i] = new HashSet<Integer>();
			cols[i] = new HashSet<Integer>();
			boxs[i] = new HashSet<Integer>();
		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {

				int val = mat[i][j];

				if (val == 0)
					continue;

				if (rows[i].contains(val))
					return false;
				else
					rows[i].add(val);

				if (cols[i].contains(val))
					return false;
				else
					cols[i].add(val);

				int idx = (i / 3) * 3 + (j / 3);

				if (boxs[idx].contains(val))
					return false;
				else
					boxs[idx].add(val);
			}
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] mat = { { 9, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, { 0, 5, 8, 0, 0, 0, 0, 6, 0 },
				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 }, { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
				{ 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
		System.out.println(isValid(mat) ? "true" : "false");

	}
}
