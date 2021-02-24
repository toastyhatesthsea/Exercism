/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/


import java.util.Stack;

public class RunLengthEncoding
{


    public String encode(String aString)
    {
        String answer = "";
        Stack<String> stackOfSameLetters = new Stack<>();

        for (int i = 0; i < aString.length(); i++)
        {
            String currentChar = aString.substring(i, i + 1);

            if (stackOfSameLetters.empty() || currentChar.equals(stackOfSameLetters.peek()))
            {
                stackOfSameLetters.push(currentChar);
            } else
            {
                int lengthOfSameChars = stackOfSameLetters.size();
                answer = answer.concat(Integer.toString(lengthOfSameChars) + stackOfSameLetters.pop());
                stackOfSameLetters.clear();
            }
        }
        return answer;
    }

    public String decode(String aString)
    {

    }

}