/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

import java.util.HashMap;

public class NucleotideCounter
{
    private String dnaString;
    private HashMap<Character, Integer> dnaCount;

    public NucleotideCounter(String aDnaString)
    {
        this.dnaString = aDnaString;
        this.dnaCount = new HashMap<>();

        this.dnaCount.put('A', 0);
        this.dnaCount.put('C', 0);
        this.dnaCount.put('G', 0);
        this.dnaCount.put('T', 0);
        processDna();
    }

    public HashMap<Character, Integer> nucleotideCounts()
    {

        return this.dnaCount;
    }

    public void processDna()
    {
        for (int i = 0; i < this.dnaString.length(); i++)
        {
            Character aChar = this.dnaString.charAt(i);

            int dnaAmountValue = this.dnaCount.getOrDefault(aChar, -1);

            if (dnaAmountValue == -1)
            {
                throw new IllegalArgumentException();
            }

            this.dnaCount.replace(aChar, dnaAmountValue + 1);
        }
    }
}