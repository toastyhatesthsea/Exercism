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
        Stack<String> blankSpacesAmount = new Stack<>();

        for (int i = 0; i < aString.length(); i++)
        {
            String currentChar = aString.substring(i, i + 1);

            if (stackOfSameLetters.empty() || currentChar.equals(stackOfSameLetters.peek()))
            {
                stackOfSameLetters.push(currentChar);

                if (i + 1 >= aString.length()) //end of string
                {
                    String stringToAdd = processString(stackOfSameLetters, currentChar, answer);
                    answer = stringToAdd;
                }

            } else
            {
                String stringToAdd = processString(stackOfSameLetters, currentChar, answer);
                answer = stringToAdd;

                if (i + 1 >= aString.length()) //end of string
                {
                    stackOfSameLetters.clear();
                    stringToAdd = processString(stackOfSameLetters, currentChar, answer);
                    answer = stringToAdd;
                }

                //Push current back onto stack and refresh
                stackOfSameLetters.clear();
                stackOfSameLetters.push(currentChar);
            }
        }
        return answer;
    }

    private String processString(Stack<String> stackOfSameLetters, String aChar, String currentTotalString)
    {

        int lengthOfSameChars = stackOfSameLetters.size();
        if (lengthOfSameChars == 1)
        {
            currentTotalString = currentTotalString.concat(stackOfSameLetters.pop());
        } else if (lengthOfSameChars == 0)
        {
            currentTotalString = currentTotalString.concat(aChar);
        } else
        {
            currentTotalString = currentTotalString.concat((lengthOfSameChars) + stackOfSameLetters.pop());
        }
        return currentTotalString;
    }

    public String decode(String aString)
    {
        String answer = "";
        Stack<Integer> amountOfLetters = new Stack<>();
        int totalLetters = -1;

        for (int i = 0; i < aString.length(); i++)
        {
            char aChar = aString.charAt(i);
            if (Character.isDigit(aChar))
            {
                if (totalLetters == -1)
                {
                    totalLetters = Integer.parseInt(Character.toString(aChar));
                } else
                {
                    totalLetters = totalLetters * 10 + Integer.parseInt(Character.toString(aChar));;
                }
            } else
            {
                if (totalLetters != -1)
                {
                    String stringMultiplierAmount = stringMultiplier(Character.toString(aChar), totalLetters);
                    answer = answer.concat(stringMultiplierAmount);
                }
                else
                {
                    answer = answer.concat(Character.toString(aChar));
                }
                totalLetters = -1;
            }
        }

        return answer;
    }

    public String stringMultiplier(String aLetter, int totalMultiplier)
    {
        String answer = "";

        for (int i = 0; i < totalMultiplier; i++)
        {
            answer = answer.concat(aLetter);
        }
        return answer;
    }

    /**
     * @param aString String
     * @param start   int
     * @return int returns the amount of same letters and spaces
     */
    public int findDifferentChar(String aString, int start)
    {
        int answer = 1;
        boolean foundDifferentChar = false;
        String previousChar = aString.substring(start, start + 1);

        for (int i = start + 1; i < aString.length() && !foundDifferentChar; i++)
        {
            String someChar = aString.substring(i, i + 1);

            if (!previousChar.equals(someChar))
            {
                foundDifferentChar = true;
            } else
            {
                answer++;
            }
        }
        return answer;
    }

}