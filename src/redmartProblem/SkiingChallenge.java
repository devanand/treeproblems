package redmartProblem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class SkiingChallenge {

	static int longestDecreasingDepth(int mat[][], int memo[][], int i, int j, int x, int y, int sumMemo[][]) {

		//int maxPath=0;
		if(memo[i][j] != 0) {
			int temp = (mat[x][y] - mat[i][j])+sumMemo[i][j];
			if(temp>sumMemo[x][y]) {
				 sumMemo[x][y]=temp;
			}
			return memo[i][j];
		}
		int max = 0;
		if((j+1)<memo.length && mat[i][j+1]<mat[i][j]) {
			int right = longestDecreasingDepth(mat, memo, i, j+1, i, j, sumMemo);
			if(right>max) 
				max = right;
		}
		
		if(j-1>=0 && mat[i][j-1]<mat[i][j]) {
			int left = longestDecreasingDepth(mat, memo, i, j-1, i, j, sumMemo);
			if(left>max)
				max = left;
			
		}
		
		if((i+1)<memo[0].length && mat[i+1][j]<mat[i][j]) {
			int bottom = longestDecreasingDepth(mat, memo, i+1, j, i, j, sumMemo);
			if(bottom>max) 
				max = bottom;
			
		}
		if((i-1)>=0 && mat[i-1][j]<mat[i][j]) {
			int top = longestDecreasingDepth(mat, memo, i-1, j, i, j, sumMemo);
			if(top>max) 
				max = top;
		}
		
		
 		if(max != 0) {
 			int temp = (mat[x][y] - mat[i][j])+sumMemo[i][j];
 			if(temp>sumMemo[x][y]) {
				 sumMemo[x][y]=temp;
			}
			return memo[i][j] = max+1;
		}
 		else {
 			int temp = mat[x][y]-mat[i][j];
 			if(temp>sumMemo[x][y]) {
				 sumMemo[x][y]=temp;
			}
 			return memo[i][j] = 1;
 		}
		
	}
	
	public static void main(String[] args) throws Exception {
		int mat[][] = new int[1000][1000];
		
		File f = new File(SkiingChallenge.class.getResource("map.txt").getFile());
		FileReader f1 = new FileReader(f);
		BufferedReader b = new BufferedReader(f1);
		String line = b.readLine();
		int skip=0, k=0;
		while(line != null) {
			if(skip==0) {
				skip++;
				line = b.readLine();
				continue;
			}
			String temp[] = line.split(" ");
			for(int l=0;l<temp.length;l++) {
				mat[k][l] = Integer.parseInt(temp[l]);
			}
			k++;
			line = b.readLine();
		}
		System.out.println(mat.length);
		System.out.println(mat[0].length);
		int memoDecrease[][] = new int[mat.length][mat[0].length];
		int sumMemo[][] = new int[mat.length][mat[0].length];
		
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				longestDecreasingDepth(mat, memoDecrease, i, j, i, j, sumMemo);
			}
		}
		int maxPath = 0,  maxDrop = 0;
		for(int i=0;i<memoDecrease.length;i++) {
			for(int j=0;j<memoDecrease[i].length;j++) {
				if(memoDecrease[i][j] >= maxPath) {
					if(sumMemo[i][j]>=maxDrop) {
						maxPath = memoDecrease[i][j];
						maxDrop = sumMemo[i][j];
					}
				}
			}
		}
		
		
		System.out.println(maxPath);
		System.out.println(maxDrop);
		
		
	}
}
