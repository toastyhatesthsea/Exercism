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
        Scanner aScanOfWord = new Scanner(aWordToTranslate);
        //TODO Add a way to scan each word and process

        while (aScanOfWord.hasNext())
        {

        }

        if (aWordToTranslate.length() > 1)
        {
            String firstLetter = aWordToTranslate.substring(0, 1);

        }


        switch (aWordToTranslate)
        {
            case
        }
    }

    public String checkWord(String aWord)
    {

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
            case "y":
                return "vowel";
            default:
                return "const";
        }
    }

}

