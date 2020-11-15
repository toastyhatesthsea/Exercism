/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

//TODO Must write directional logic code and finish MatrixPredicate


//TODO Have to swap Row and Column values, writing values to wrong index

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

        int currentRow = 0, currentColumn = 0, highestNumber = size * size;

        String right = "Right", left = "Left", up = "Up", down = "Down";

        String direction = right;


        for (int i = 1; i <= highestNumber; i++)
        {
            while (currentColumn < size && currentRow < size && currentColumn >= 0 && currentRow >= 0 && theMatrix[currentColumn][currentRow] == null)
            {
                theMatrix[currentColumn][currentRow] = i;
                switch (direction)
                {
                    case "Right":
                    {
                        currentColumn++;
                        i++;

                        break;
                    }
                    case "Down":
                    {
                        currentRow++;
                        i++;

                        break;
                    }
                    case "Left":
                    {
                        currentColumn--;
                        i++;
                        break;
                    }
                    case "Up":
                    {
                        currentRow--;
                        i++;
                        break;
                    }
                }
            }

            i--;

            if (direction.equals("Right"))
            {
                currentRow++;
                currentColumn--;
                direction = down;
            } else if (direction.equals("Down"))
            {
                currentRow--;
                currentColumn--;
                direction = left;
            } else if (direction.equals("Left"))
            {
                currentRow--;
                currentColumn++;
                direction = up;
            } else
            {
                direction = right;
                currentRow++;
                currentColumn++;
            }


        }




        /*
        for (int i = 1; i <= size; i++)
        {
            //Up Direction check

                if (currentColumn-1 != -1 && this.theMatrix[currentColumn - 1][currentRow] == 0)
                {
                    int currentIndex = processMatrix("Up", currentColumn, currentRow, i);
                    currentRow = currentIndex;
                }


        }*/

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

        int[][] someMultiArray = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
        };

        int answer = someMultiArray[0][0];

        SpiralMatrixBuilder someSpiral = new SpiralMatrixBuilder();

        someSpiral.buildMatrixOfSize(5);


    }
}
