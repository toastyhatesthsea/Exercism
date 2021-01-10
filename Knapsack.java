/*
Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.
Please remove this comment when submitting your solution.
*/


import java.lang.reflect.Array;
import java.util.ArrayList;

public class Knapsack
{
    public static int maximumValue(int weight, ArrayList<Item> someItems)
    {
        int answer = 0;
        for (Item a : someItems)
        {
            int someMaxValue = maxValue(weight, a, someItems);
            if (someMaxValue > answer)
            {
                answer = someMaxValue;
            }
        }
        return answer;
    }

    public static int maxValue(int weight, Item anItem, ArrayList<Item> someItems)
    {
        int totalWeight =+ anItem.getWeight();
        int answer = anItem.getValue();

        if (anItem.getWeight() > weight)
        {
            return -1;
        } else if (anItem.getWeight() == weight)
        {
            return answer;
        }
        else
        {
            for (Item a:someItems)
            {
                if (a != anItem)
                {
                    if (totalWeight + a.getWeight() <= weight)
                    {
                        totalWeight += a.getWeight();
                        answer += a.getValue();
                    }
                }
            }
        }

        return answer;
    }
}

class Item
{
    protected int weight, value;

    public Item(int aWeight, int aValue)
    {
        this.weight = aWeight;
        this.value = aValue;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }
}