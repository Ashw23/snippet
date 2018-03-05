package hRP4_2DArray_Hourglass;

import java.util.Arrays;
import java.util.Scanner;
/***
 * @author Ashwini
 * 1. Read and print 2d Array
 * 2. For a given 2D array find out the number of hour-glass pattern possible
 * 3. Print the largest (maximum) hourglass sum found in the array.
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the size of 2D Array");
		int rows,columns;
		Scanner sc=new Scanner(System.in);
		rows=sc.nextInt();
		columns=sc.nextInt();
		int arr[][]=new int[rows][columns];
		System.out.println("enter the elements");
		for(int i=0; i<rows;i++){
			System.out.println("row: "+i);
			for(int j=0; j<columns;j++){
				arr[i][j]=sc.nextInt();
			}
		}
		sc.close();
		System.out.println("Display array");
		System.out.println(Arrays.deepToString(arr));
		
		// ********** Solution 2 starts *************
		int rCount = 0, cCount = 0, noOfHrPattern = 0;

		while ((rCount + 2) < rows) // since we need 3 array elements in a row
									// of hourglass
			rCount++;
		while ((cCount + 2) < columns)
			cCount++;
		noOfHrPattern = rCount * cCount;
		System.out.println("No. of hourglass pattern possible for this 2d array: " + noOfHrPattern);

		// ************ Solution 3 starts **************

		int hrGlassSum = Integer.MIN_VALUE; // Since I/P array can also have
											// negetive integers
		for (int i = 0; i < (rows - 2); i++) {
			for (int j = 0; j < (columns - 2); j++) {
				int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 2][j] + arr[i + 2][j + 1]
						+ arr[i + 2][j + 2] + arr[i + 1][j + 1];
				if (sum > hrGlassSum)
					hrGlassSum = sum;
			}

		}
		System.out.println("Maximum sum of hr glass pattern: " + hrGlassSum);

	}

}
