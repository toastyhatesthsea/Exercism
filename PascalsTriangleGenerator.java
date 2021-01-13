/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/


public class PascalsTriangleGenerator
{
    public int[][] generateTriangle(int sizeOfTriangle)
    {
        int[][] answer = new int[sizeOfTriangle][sizeOfTriangle];

        for (int i = 0; i < sizeOfTriangle; i++)
        {
            if (i == 0)
            {
                answer[0][0] = 1;
            } else
            {
                int[] aRow = createArrayRow(answer[i]);
                answer[i] = aRow;
            }
        }

        return answer;
    }

    public int[] createArrayRow(int[] previousAboveArrayInTriangle)
    {
        int[] answer = new int[previousAboveArrayInTriangle.length + 1];
        for (int i = 0; i < answer.length; i++)
        {
            if (i == 0)
            {
                answer[i] = 1;
            } else if (i == answer.length - 1)
            {
                answer[i] = 1;
            } else
            {
                int firstSlot = previousAboveArrayInTriangle[i - 1] + previousAboveArrayInTriangle[i];
                answer[i] = firstSlot;
            }
        }
        return answer;
    }
}