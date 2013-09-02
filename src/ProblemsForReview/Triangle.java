package ProblemsForReview;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * position link: http://www.yodlecareers.com/jobs/new-york/software-engineer/
 *
     1 - Triangle

     Triangle
     By starting at the top of the triangle and moving to adjacent numbers on the row below,
     the maximum total from top to bottom is 27.

          5
         9 6
        4 6 8
       0 7 1 5

     I.e. 5 + 9 + 6 + 7 = 27.

     Write a program in a language of your choice to find the maximum total from top to bottom
     in triangle.txt, a text file containing a triangle with 100 rows. Send your solution and
     resume to [123456 AT yodle dot com], replacing 123456 with the maximum sum for the triangle.
 */
public class Triangle {
    public BufferedReader dataSource;
    public int[][] numSet;

    public Triangle(String filePath, int[][] arr) {
        try {
            this.dataSource = new BufferedReader(new FileReader(filePath));
            this.numSet = arr;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int trianglePathSum() {
        int currSum = Integer.MIN_VALUE;
        int currRowIndex = 0;
        try {
            while (dataSource.ready()) {
                String s = dataSource.readLine();
                String[] sArr = s.split(" ");
                for(int i = 0; i < sArr.length; i++) {
                    numSet[currRowIndex][i] = Integer.parseInt(sArr[i]);
                }
                currRowIndex++;
            }
            dataSource.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < numSet.length; i++) {
            for(int j = 0; j <= i; j++) {
                int sumOne = Integer.MIN_VALUE;
                int sumTwo = Integer.MIN_VALUE;
                if(i-1 >= 0 && j <= i-1)
                    sumOne = numSet[i-1][j] + numSet[i][j];

                if(i-1 >= 0 && j-1 >= 0 && sumOne < numSet[i-1][j-1] + numSet[i][j])
                    sumTwo =  numSet[i-1][j-1] + numSet[i][j];

                if(sumTwo != Integer.MIN_VALUE)
                    numSet[i][j] = sumTwo;
                else if(sumOne != Integer.MIN_VALUE)
                    numSet[i][j] = sumOne;

                if(i == 99 && currSum < numSet[i][j])
                    currSum = numSet[i][j];
            }
        }
        return currSum;
    }

    public static void main(String[] args) throws IOException {
        String filePath = "/Users/JT026354/Documents/workspace/ProblemsCollection/src/ProblemsForReview/triangle.txt";
        int[][] arr = new int[100][100];
        Triangle t = new Triangle(filePath, arr);
        System.out.println(t.trianglePathSum());
    }
}
