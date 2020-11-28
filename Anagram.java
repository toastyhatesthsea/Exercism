/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Anagram
{
    public String aWord;
    public HashMap<String, Integer> wordKey;

    public Anagram(String someWord)
    {
        this.aWord = someWord;

        wordKey = processWord(this.aWord);

    }

    public String getaWord()
    {
        return aWord;
    }

    public void setaWord(String aWord)
    {
        this.aWord = aWord;
    }

    public List<String> match(List<String> someList)
    {
        List<String> answer = new ArrayList<>();
    }

    public static HashMap<String, Integer> processWord(String aWord)
    {
        HashMap<String, Integer> answer = new HashMap<>();

        for (int i = 0; i < aWord.length(); i++)
        {
            String aLetter = aWord.substring(i, i + 1);

            Integer returnedValue = answer.putIfAbsent(aLetter, 1);

            if (returnedValue != null)
            {
                answer.replace(aLetter, returnedValue);
            }
        }
        return answer;
    }

}
