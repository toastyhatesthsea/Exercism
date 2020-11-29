/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

import java.util.ArrayList;
import java.util.List;

public class Series
{
    private String numberString;

    public Series(String aNumberString)
    {
        this.numberString = aNumberString;
    }
    
    public List<String> slices(int amount)
    {
        if (amount > this.numberString.length())
        {
            throw new IllegalArgumentException("Slice size is too big.");
        } else if (amount <= 0)
        {
            throw new IllegalArgumentException("Slice size is too small.");
        }

        List<String> answer = new ArrayList<>();
        for (int i = 0; i + amount <= this.numberString.length(); i++)
        {
            String aSlice = this.numberString.substring(i, i + amount);
            answer.add(aSlice);
        }
        return answer;
    }
}