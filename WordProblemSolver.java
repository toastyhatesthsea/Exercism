/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordProblemSolver
{

    public WordProblemSolver()
    {
        whatToCompute = new String[3];
        parsedDataFromPhrase = new HashMap<>();
    }

    private String[] whatToCompute;
    private HashMap<String, Integer> parsedDataFromPhrase;

    public int solve(String somePhraseToCompute)
    {
        int answer = -1;

        whatToCompute = somePhraseToCompute.split(" ");
        parsePhraseIntoHashMap(somePhraseToCompute);

        for (Map.Entry<String, Integer> anEntry : parsedDataFromPhrase.entrySet())
        {

        }

        for (int i = 0; i < whatToCompute.length; i++)
        {
            String data = whatToCompute[i];
            if (!data.equals("What") && i == 0)
            {
                throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
            } else if (!data.equals("is") && i == 1)
            {
                throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
            } else if (checkForOperatorPhrase(data) && i == 3)
            {
                //TODO Must evaluate properly based on which operator
            }

        }


        return answer;
    }

    public boolean checkForOperatorPhrase(String someWord)
    {
        boolean answer = false;
        if (someWord.equals("divided"))
        {
            answer = true;
        } else if (someWord.equals("plus"))
        {
            answer = true;
        } else if (someWord.equals("minus"))
        {
            answer = true;
        } else if (someWord.equals("multiplied"))
        {
            answer = true;
        }
        return answer;
    }

    public void parsePhraseIntoHashMap(String somePhrase)
    {
        Scanner someScan = new Scanner(somePhrase);

        while (someScan.hasNext())
        {
            String aWord = someScan.next();
            Integer someValue = parsedDataFromPhrase.putIfAbsent(aWord, 1);

            if (someValue != null)
            {
                parsedDataFromPhrase.put(aWord, someValue + 1);
            }
        }
    }

    public void errorCheckers()
    {
        if (parsedDataFromPhrase.get("What") == null)
        {
            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        }
    }

}
