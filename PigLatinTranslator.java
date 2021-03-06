/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

import java.util.Scanner;

public class PigLatinTranslator
{
    private String originalWord;

    public PigLatinTranslator()
    {

    }

    public String translate(String aWordToTranslate)
    {
        aWordToTranslate = aWordToTranslate.toLowerCase();
        Scanner aScanOfWord = new Scanner(aWordToTranslate);
        //TODO Add a way to scan each word and process
        String answer = "";

        while (aScanOfWord.hasNext())
        {
            String someWord = aScanOfWord.next();
            someWord = changeWord(someWord);

            //Adding space between words
            if (!answer.isEmpty())
            {
                answer = answer.concat(" " + someWord);

            } else
            {
                answer = answer.concat(someWord);

            }

        }
        return answer;
    }

    public String changeWord(String aWord)
    {
        //TODO Create methods for each rule, ex. Rule 1 > First method
        Scanner someWord = new Scanner(aWord);
        int index = 0;

        String firstLetter = aWord.substring(0, 1);
        String whatTypeOfLetter = checkLetter(firstLetter);

        if (whatTypeOfLetter.equals("vowel"))
        {
            aWord = aWord.concat("ay");
            return aWord;
        }

        String specialVowelSound = "";
        if (aWord.length() > 1)
        {
            specialVowelSound = aWord.substring(0, 2);

            if (specialVowelSound.equals("xr") || specialVowelSound.equals("yt"))
            {
                aWord = aWord.concat("ay");
                return aWord;
            }
        }

        //Constenent cluster
        if (whatTypeOfLetter.equals("const"))
        {
            boolean clusterDone = false;
            for (int i = 0; i < aWord.length() && !clusterDone; i++)
            {
                firstLetter = aWord.substring(i, i + 1);
                whatTypeOfLetter = checkLetter(firstLetter);

                if (whatTypeOfLetter.equals("vowel") || firstLetter.equals("y") || firstLetter.equals("q"))
                {

                    if (i == aWord.length() - 1) //index reaches end of word
                    {
                        aWord = aWord.substring(i) + aWord.substring(0, i) + "ay";
                        clusterDone = true;
                    }
                    else
                    {
                        String secondLetter = aWord.substring(i + 1, i + 2);
                        //TODO Fix translation when encountering constenant and q or y at end of word

                        if (firstLetter.equals("q"))
                        {
                            if (secondLetter.equals("u"))
                            {
                                aWord = aWord.substring(i + 2) + aWord.substring(0, i + 2) + "ay";
                                clusterDone = true;
                            }
                        } else if (firstLetter.equals("y"))
                        {
                            if (i != 0) // beginning of word
                            {
                                aWord = aWord.substring(i) + aWord.substring(0, i) + "ay";
                                clusterDone = true;
                            }
                        }
                        else
                        {
                            aWord = aWord.substring(i) + aWord.substring(0, i) + "ay";
                            clusterDone = true;
                        }
                    }


                }
            }
        }
        return aWord;
    }

    private String vowelWord(String aWord)
    {
        if (aWord.length() > 1)
        {
            String specialVowelSound = aWord.substring(0, 2);

            if (specialVowelSound.equals("xr") || specialVowelSound.equals("yt"))
            {

            }
        }
        return null;
    }

    public String checkLetter(String aLetter)
    {
        switch (aLetter)
        {
            case "a":
            case "e":
            case "i":
            case "o":
            case "u":
                return "vowel";
            default:
                return "const";
        }
    }

}

class Meowtesters
{
    public static void main(String[] asdasdasd)
    {
        String aString = "Bird";

        String someString = aString.substring(5);
    }
}

