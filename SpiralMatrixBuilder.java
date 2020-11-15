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
    public Integer[][] theMatrix;

    public int processMatrix(String direction, int column, int row, int currentIndex)
    {
        if (direction.equals("Up"))
        {
            for (int i = column; theMatrix[i][row] != null && theMatrix[i][column] == 0; i--)
            {
                theMatrix[i][row] = currentIndex;
                currentIndex = i;
            }
        }
        return currentIndex;
    }


    public Integer[][] buildMatrixOfSize(int size)
    {
        theMatrix = new Integer[size][size];

        int currentRow = 0, currentColumn = 0;

        String right = "Right", left = "Left", up = "Up", down = "Down";

        String direction = right;

        for(int i=1; i<=size; i++)
        {
            switch (direction)
            {
                case "Right":
                {
                    while (currentColumn < size && theMatrix[currentColumn][currentRow] == null)
                    {
                        theMatrix[currentColumn][currentRow] = i;
                        currentColumn++;
                        i++;
                    }
                }
            }

            if (direction.equals("Right"))
            {
                direction = down;
            } else if (direction.equals("Down"))
            {
                direction = left;
            } else if (direction.equals("Left"))
            {
                direction = up;
            } else
            {
                direction = right;
            }


        }




        for (int i = 1; i <= size; i++)
        {
            //Up Direction check

                if (currentColumn-1 != -1 && this.theMatrix[currentColumn - 1][currentRow] == 0)
                {
                    int currentIndex = processMatrix("Up", currentColumn, currentRow, i);
                    currentRow = currentIndex;
                }


        }

        int[][][][] rawr;

        return theMatrix;
    }

    public interface MatrixPredicate
    {
        void fillMatrixOneDirection(String direction, Integer[][] aMatrix);
    }
}

class MeowersTesters
{
    public static void main(String[] asdasdasddas)
    {
        /*
        int[][] someMultiArray = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
        };

        int answer = someMultiArray[-1][0];
        */
        SpiralMatrixBuilder someSpiral = new SpiralMatrixBuilder();

        someSpiral.buildMatrixOfSize(5);


    }
}
