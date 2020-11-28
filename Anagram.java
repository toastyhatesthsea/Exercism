/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagram
{
    public String aWord;
    public HashMap<String, Integer> wordKey;

    public Anagram(String someWord)
    {
        this.aWord = someWord.toLowerCase();

        //wordKey = processWord(this.aWord);
    }

    public String getaWord()
    {
        return aWord;
    }

    public void setaWord(String aWord)
    {
        this.aWord = aWord;
    }

    /**
     * Checks object string for Anagrams. Just simply sorts the strings and see if they line up equally.
     * Object string cannot be the same exact word in the list.
     * @param someList List
     * @return List<String></String>
     */
    public List<String> match(List<String> someList)
    {
        char[] objectWord = this.aWord.toCharArray();
        Arrays.sort(objectWord);

        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> mapForEachWord = new HashMap<>();

        for (int i = 0; i < someList.size(); i++)
        {
            String wordFromList = someList.get(i).toLowerCase();
            //mapForEachWord = processWord(wordFromList);

            char[] listWordArray = wordFromList.toCharArray();
            Arrays.sort(listWordArray);

            if (Arrays.equals(listWordArray, objectWord) && !this.aWord.equals(wordFromList))
            {
                answer.add(someList.get(i));
            }

        }

        return answer;
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
