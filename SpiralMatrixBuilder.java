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

    public Integer[][] buildMatrixOfSize(int size)
    {
        theMatrix = new Integer[size][size];

        int currentRow = 0, currentColumn = 0, highestNumber = size * size;

        String right = "Right", left = "Left", up = "Up", down = "Down";

        String direction = right;

        for (int i = 1; i <= highestNumber; i++)
        {
            while (currentColumn < size && currentRow < size && currentColumn >= 0 && currentRow >= 0 && theMatrix[currentRow][currentColumn] == null)
            {
                theMatrix[currentRow][currentColumn] = i;
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

        int answer = someMultiArray[1][0];

        SpiralMatrixBuilder someSpiral = new SpiralMatrixBuilder();

        Integer[][] matrixBuilt = someSpiral.buildMatrixOfSize(2);


    }
}
