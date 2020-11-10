/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

//TODO Must write directional logic code and finish MatrixPredicate


public class SpiralMatrixBuilder
{
    public Integer [][] theMatrix;


    public Integer[][] buildMatrixOfSize(int size)
    {
        theMatrix = new Integer[size][size];

        int currentRow = 0, currentColumn = 0;


        for(int i=1; i<=size; i++)
        {
            if (this.theMatrix[currentColumn - 1][currentRow] != null && this.theMatrix[currentColumn - 1][currentRow] == 0)
            {

            }
        }

        int [][][][] rawr;

        return theMatrix;
    }

    public interface MatrixPredicate
    {
        void fillMatrixOneDirection(String direction);
    }
}

class MeowersTesters
{
    public static void main(String[] asdasdasddas)
    {
        int[][] someMultiArray = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
        };

        int answer = someMultiArray[-1][0];

    }
}
